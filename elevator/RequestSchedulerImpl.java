public class RequestSchedulerImpl implements RequestScheduler {

    ElevatorUnit elevatorUnit;

    // Constructor-based Dependency Injection
    public RequestSchedulerImpl(ElevatorUnit elevatorUnit) {
        this.elevatorUnit = elevatorUnit;
    }

    @Override
    public void scheduleRequest(UserRequest userRequest) {
        if (elevatorUnit.allRequestsFufilled()) {
            if (userRequest.direction == Direction.UP) {
                if (elevatorUnit.currentFloor <= userRequest.sourceFloor) {
                    elevatorUnit.currentDirection = Direction.UP;
                    elevatorUnit.activeUpRequests.add(userRequest.sourceFloor);
                    elevatorUnit.activeUpRequests.add(userRequest.destinationFloor);
                } else {
                    elevatorUnit.currentDirection = Direction.DOWN;
                    elevatorUnit.activeDownRequests.add(userRequest.sourceFloor);
                    
                    elevatorUnit.nextUpRequests.add(userRequest.sourceFloor);
                    elevatorUnit.nextUpRequests.add(userRequest.destinationFloor);
                }
            } else {
                if (elevatorUnit.currentFloor >= userRequest.sourceFloor) {
                    elevatorUnit.currentDirection = Direction.DOWN;
                    elevatorUnit.activeDownRequests.add(userRequest.sourceFloor);
                    elevatorUnit.activeDownRequests.add(userRequest.destinationFloor);
                } else {
                    elevatorUnit.currentDirection = Direction.UP;
                    elevatorUnit.activeUpRequests.add(userRequest.sourceFloor);
                    
                    elevatorUnit.nextDownRequests.add(userRequest.sourceFloor);
                    elevatorUnit.nextDownRequests.add(userRequest.destinationFloor);
                }
            }
        } else if (userRequest.direction == elevatorUnit.currentDirection) {
            if (elevatorUnit.currentDirection == Direction.UP) {
                if (elevatorUnit.currentFloor <= userRequest.sourceFloor) {
                    elevatorUnit.activeUpRequests.add(userRequest.sourceFloor);
                    elevatorUnit.activeUpRequests.add(userRequest.destinationFloor);
                } else {
                    elevatorUnit.nextUpRequests.add(userRequest.sourceFloor);
                    elevatorUnit.nextUpRequests.add(userRequest.destinationFloor);
                }
            } else {
                if (elevatorUnit.currentFloor >= userRequest.sourceFloor) {
                    elevatorUnit.activeDownRequests.add(userRequest.sourceFloor);
                    elevatorUnit.activeDownRequests.add(userRequest.destinationFloor);
                } else {
                    elevatorUnit.nextDownRequests.add(userRequest.sourceFloor);
                    elevatorUnit.nextDownRequests.add(userRequest.destinationFloor);
                }
            }
        } else {
            if (userRequest.direction == Direction.UP) {
                elevatorUnit.nextUpRequests.add(userRequest.sourceFloor);
                elevatorUnit.nextUpRequests.add(userRequest.destinationFloor);
            } else {
                elevatorUnit.nextDownRequests.add(userRequest.sourceFloor);
                elevatorUnit.nextDownRequests.add(userRequest.destinationFloor);
            }
        }
    }    
}
