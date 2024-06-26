package factory.pattern;

import java.util.HashMap;
import java.util.Map;

public class RoadTransport implements Transport {
    String name = "rt-" + System.currentTimeMillis();

    Map<MetricType, Double> metrics = new HashMap<>();

    public void drive() {
        System.out.println(name + " is driving.");
    }

    public void deliver() {
        System.out.println(name + " delivered.");
    }

    @Override
    public Map<MetricType, Double> getMetrics() {
        return metrics;
    }

    @Override
    public String toString() {
        return "RoadTransport{" +
                "name='" + name + '\'' +
                '}';
    }
}
