package factory.pattern;

public enum MetricType {

    PETROL(100),
    KMS(50),
    DIESEL(80),
    KNOTS(30);

    private final int conversionRate;

    MetricType(int conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getConversionRate() {
        return conversionRate;
    }
}
