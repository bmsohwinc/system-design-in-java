package factory.pattern;

public class RoadTransport {
    String name = "rt-" + System.currentTimeMillis();
    public void drive() {
        System.out.println(name + " is driving.");
    }
}
