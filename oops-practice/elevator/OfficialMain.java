// Enums
enum ElevatorState {
    IDLE,
    UP,
    DOWN;
}

enum Direction {
    UP,
    DOWN;
}

enum DoorState {
    OPEN,
    CLOSE;
}

abstract class Button {
    private boolean status;
    
    public boolean isPressed() {}
    public void press() {}
}

class HallButton extends Button {
    private Direction direction;
}

class ElevatorButton extends Button {
    private int floorNumber;
}

class DoorButton extends Button {
    private DoorState state;
}

class ElevatorPanel {
    List<ElevatorButton> elevatorButtons;
    DoorButton openButton;
    DoorButton closeButton;
}

class HallPanel {
    HallButton upButton;
    HallButton closeButton;
}

class Display {
    int currentFloor;
    int currentDirection;
    public void display();
}

class Elevator {
    DoorState doorState;
    int currentFloor;
    int targetFloor;
    int currentCapacity;
    int maxCapacity;
    Direction currentDirection;
    ElevatorPanel panel;
    ElevatorState currentState;
    Display display;
    
    public void start() {}
    public void stop() {}
    public void openDoor() {}
    public void closeDoor() {}
    
}

class Floor {
    List<Display> displays;
    List<HallPanel> panels;
    
    public void pressUp(HallPanel panel) {}
    public void pressDown(HallPanel panel) {}
    public showStatus(Display display) {}
}

class ElevatorSystem {
    List<Floor> floors;
    List<Elevator> elevators;
    
    public Elevator requestElevator(int sourceFloor, int targetFloor) {}
}


