package factory.pattern;

public class SeaTransporter extends Transporter {
    protected SeaTransporter(FareCalculator fareCalculator) {
        super(fareCalculator);
    }

    @Override
    public Transport getTransport() {
        return new SeaTransport();
    }
}
