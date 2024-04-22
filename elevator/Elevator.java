/**
 * 
 * Elevator
 * 1. current floor
 * 2. max capacity
 * 3. direction (up/down)
 * 4. stop
 * 5. start
 * 6. current floor
 * 7. selected floors
 * 
 * Elevator System
 * 
 * use cases:
 * 1. has many elevators
 * 2. floors
 * 3. call elevator
 * 4. set floor
 * 5. allow selection from outer panel and inner panel
 * 
 * 
 * user presses up/down button -> elevator starts -> elevator arrives -> user enters
 * -> user selects target floor -> elevator starts -> elevator arrives at target floor
 * -> user exits
 * 
 * ElevatorStatus {
 *  Idle,
 *  Moving
 * }
 * 
 * Direction {
 *  Up,
 *  Down
 * }
 * 
 * Elevator {
 *  ElevatorStatus status;
 *  Boolean doorStatus;
 *  int maxCapacity;
 *  int currentFloor;
 *  Direction currentDirection;
 *  List<FloorButton> floorButtons;
 *  Button open;
 *  Button close;
 *  Alarm alarm;
 * 
 *  call(srcFloor, destFloor) {
 *      
 *  }
 * }
 * 
 * ElevatorSystem {
 *  Elevator elevator;
 *  
 *  
 * }
 * 
 * 
 * 
 * es = new ElevatorSystem();
 * elevator = new Elevator();
 * 
 * elevator.call(10);
 * 
 * 
 */

public class Elevator {
    
}
