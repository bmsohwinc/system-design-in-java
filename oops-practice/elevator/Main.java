Elevator System


User
- weight

Admin
- crud elevator

Elevator
- has max capacity -- weight


CallButton -> Up, Down
- outside elevator

FloorPanel
- inside elevator

Elevator State
- MOVING_UP
- MOVING_DOWN
- HALTED


many people use 
- one elevator for now
- extend to many elevators later





10 floors


UP: User -> at floor 1 -> push up button -> elevator opens at floor 1 -> enters elevator -> selects floor 5 -> elevator arrives at floor 5 -> exits
DOWN: ... 5 -> 1

floor 3 -> call up (floor 10)
floor 2 -> call up (floor 5)

elevator at floor 6
- 6 -> 3 -> 10 -> 2 -> 5 (down, up, down, up) -> more time
- 6 -> 3 -> 2 -> 5 -> 10 (down, down, up, up) -> less time (reach farthest called in moving direction)

up_queue of requests 
down_queue
next_queue

Request:
(source_floor, dest_floor)


use cases:
# Admin
- crud elevator
- add floors
- override elevator movement

# User
- call elevator from floor
- select destination floor inside elevator
- open/close elevator doors

# System
- allocate elevator optimally
- determine elevator direction


enum ElevatorState {
    IDLE,
    UP,
    DOWN;
}

enum DoorState {
    OPEN,
    CLOSE;
}

enum ButtonState {
    ON,
    OFF;
}

abstract class Button {
    ButtonState currentState;
    // getters, setters    
}


class FloorButton extends Button {
    private int floorNumber;
    public FloorButton(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    // no setter
}

class OpenDoorButton extends Button {}

class CloseDoorButton extends Button {}

class UpButton extends Button {}

class DownButton extends Button {}

interface Displayable {
    List<String> getProps();
}

class DisplayPanel {
    // change the params.
    public void display(Displayable displayable) {}
}

class ElevatorPanel {
    List<FloorButton> floorButtons;
    OpenDoorButton openDoorButton;
    CloseDoorButton closeDoorButton;
    DisplayPanel displayPanel;
}

class Elevator {
    ElevatorPanel elevatorPanel;
    ElevatorState state;
    DoorState doorState;
    
    // setter and getter
    int targetFloor;
    int currentFloor;
    int maxCapacity;
    int currentCapacity;
    
    public boolean openDoor() {}
    public boolean closeDoor() {}
    public boolean start() {}
    public boolean stop() {}
}

class HallPanel {
    UpButton upButton;
    DownButton downButton;
}

class Floor {
    private int floorNumber;
    List<HallPanel> panels;
}

class Building {
    private int buildingNumber;
    private List<Floor> floors;
    private List<Elevator> elevators;
}

class ElevatorSystem {
    List<Building> buildings;
    
    public Elevator requestElevator(Building building, Floor sourcefloor, Floor targetFloor) {}
    
}


