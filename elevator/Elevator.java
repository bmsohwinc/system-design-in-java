import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Predicate;

enum Direction {
    UP,
    DOWN;
}

enum Status {
    STARTED,
    STOPPED;
}

class ElevatorUnit {
    
    UUID id;
    
    int currentFloor;
    Direction currentDirection;
    Status currentStatus;

    SortedSet<Integer> activeUpRequests;
    SortedSet<Integer> nextUpRequests;
    
    SortedSet<Integer> activeDownRequests;
    SortedSet<Integer> nextDownRequests;

    Comparator<Integer> upComparator = (r1, r2) -> r1 - r2;
    Comparator<Integer> downComparator = (r1, r2) -> r2 - r1;

    RequestScheduler requestScheduler;

    int idleCount = 0;

    public ElevatorUnit() {
        id = UUID.randomUUID();
        currentFloor = 0;
        currentDirection = Direction.UP;
        currentStatus = Status.STOPPED;

        activeUpRequests = new TreeSet<>(upComparator);
        nextUpRequests = new TreeSet<>(upComparator);
        
        activeDownRequests = new TreeSet<>(downComparator);
        nextDownRequests = new TreeSet<>(downComparator);

        // Strategy Pattern: We can plug-in any scheduler strategy implementation here
        requestScheduler = new RequestSchedulerImpl(this);
    }

    void requestElevator(UserRequest userRequest) {
        System.out.println("[ r ] " + LocalDateTime.now() + ": Got request: " + userRequest.toString());
        requestScheduler.scheduleRequest(userRequest);
    }

    void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Could not pause.");
            e.printStackTrace();
        }
    }

    void moveUp() {
        pause();
        currentFloor++;
        System.out.println("[ up ] to " + currentFloor);
    }

    void moveDown() {
        pause();
        currentFloor--;
        System.out.println("[ down ] to " + currentFloor);
    }

    int getUpdatedTargetFloor(SortedSet<Integer> activeRequests, int target, BiFunction<Integer, Integer, Boolean> comparator) {
        if (!activeRequests.isEmpty()) {
            if (comparator.apply(activeRequests.first(), target)) {
                activeRequests.add(target);
                target = activeRequests.first();
                activeRequests.remove(target);
            } else if (activeRequests.first() == target) {
                activeRequests.remove(target);
            }
        }
        return target;
    }

    void completeUpwardTrip() {
        while (!activeUpRequests.isEmpty()) {
            int target = activeUpRequests.first();
            activeUpRequests.remove(target);
            while (currentFloor <= target) {
                moveUp();
                target = getUpdatedTargetFloor(activeUpRequests, target, (a, b) -> a < b);
            }
        }

        if (!nextDownRequests.isEmpty() && currentFloor < nextDownRequests.first()) {
            // keep going up
            currentDirection = Direction.UP;
            activeUpRequests.add(nextDownRequests.first());
            return;
        }

        // TOGGLE direction
        currentDirection = Direction.DOWN;
        activeDownRequests = new TreeSet<>(nextDownRequests);
        nextDownRequests.clear();
    }

    void completeDownwardTrip() {
        while (!activeDownRequests.isEmpty()) {
            int target = activeDownRequests.first();
            activeDownRequests.remove(target);
            while (currentFloor >= target) {
                moveDown();
                target = getUpdatedTargetFloor(activeDownRequests, target, (a, b) -> a > b);
            }
        }

        if (!nextUpRequests.isEmpty() && currentFloor > nextUpRequests.first()) {
            // keep going down
            currentDirection = Direction.DOWN;
            activeDownRequests.add(nextUpRequests.first());
            return;
        }
        
        // TOGGLE direction
        currentDirection = Direction.UP;
        activeUpRequests = new TreeSet<>(nextUpRequests);
        nextUpRequests.clear();
    }

    void travel() {
        if (allRequestsFufilled()) {
            System.out.println("[ e ] No requests in queue. Not moving.");
            idleCount++;
            return;
        }

        idleCount = 0;        
        System.out.println("[ e ] Have requests in queue. Moving.");

        if (currentDirection == Direction.UP) {
            completeUpwardTrip();
        } else {
            completeDownwardTrip();
        }
    }

    boolean allRequestsFufilled() {
        return activeUpRequests.isEmpty() && nextUpRequests.isEmpty() && 
            activeDownRequests.isEmpty() && nextDownRequests.isEmpty();
    }
}

/*
 * Testing the elevator movement and scheduler strategy.
 */
public class Elevator {
    public static void main(String[] args) {
        ElevatorUnit elevatorUnit = new ElevatorUnit();
        // thread 1
        new Thread(new Runnable() {
            public void run() {
                try {
                    elevatorUnit.requestElevator(new UserRequest(0, 2, Direction.UP));
                    Thread.sleep(600);
                    elevatorUnit.requestElevator(new UserRequest(1, 6, Direction.UP));
                    Thread.sleep(2000);
                    elevatorUnit.requestElevator(new UserRequest(10, 2, Direction.DOWN));
                    Thread.sleep(6400);
                    elevatorUnit.requestElevator(new UserRequest(3, 6, Direction.UP));
                    Thread.sleep(6000);
                    elevatorUnit.requestElevator(new UserRequest(5, 4, Direction.DOWN));
                    Thread.sleep(4000);
                    elevatorUnit.requestElevator(new UserRequest(7, 3, Direction.DOWN));
                    Thread.sleep(9000);
                    elevatorUnit.requestElevator(new UserRequest(8, 2, Direction.DOWN));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // thread 2
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        elevatorUnit.travel();
                        if (elevatorUnit.idleCount == 3) {
                            System.out.println("[ e ] Max idle count reached. Exiting");
                            break;
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
