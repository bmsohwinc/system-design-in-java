package factory.pattern;

import java.util.Map;

public interface Transport {
    void deliver();
    Map<MetricType, Double> getMetrics();
}
