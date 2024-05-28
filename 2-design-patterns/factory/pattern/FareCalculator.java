package factory.pattern;

public class FareCalculator {

    public double getDeliveryCharges(Transport transport) {
        double totalCharges = 0;
        for (var entry : transport.getMetrics().entrySet()) {
            totalCharges += entry.getValue() * entry.getKey().getConversionRate();
        }
        return totalCharges;
    }

}
