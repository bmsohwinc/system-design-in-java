package factory.pattern;

import java.util.HashMap;
import java.util.Map;

public class SeaTransport implements Transport {

    String name = "st-" + System.currentTimeMillis();

    Map<MetricType, Double> metrics = new HashMap<>();

    public void sail() {
        System.out.println(name + " is sailing.");
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
        return "SeaTransport{" +
                "name='" + name + '\'' +
                '}';
    }
}
