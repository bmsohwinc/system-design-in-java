package factory.pattern;

public class RoadTransporter extends Transporter {

    protected RoadTransporter(FareCalculator fareCalculator) {
        super(fareCalculator);
    }

    @Override
    public Transport getTransport() {
        return new RoadTransport();
    }
}
