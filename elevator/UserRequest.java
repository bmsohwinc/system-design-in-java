import java.time.LocalDateTime;

public class UserRequest {
    
    LocalDateTime timestamp;
    int sourceFloor;
    int destinationFloor;
    Direction direction;

    public UserRequest(int sourceFloor, int destinationFloor, Direction direction) {
        this.timestamp = LocalDateTime.now();
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "UserRequest [sourceFloor=" + sourceFloor + 
                ", destinationFloor=" + destinationFloor + ", direction=" + direction + "]";
    }
}
