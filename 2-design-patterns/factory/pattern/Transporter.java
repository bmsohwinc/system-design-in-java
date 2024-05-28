package factory.pattern;

public abstract class Transporter {

    private final FareCalculator fareCalculator;

    protected Transporter(FareCalculator fareCalculator) {
        this.fareCalculator = fareCalculator;
    }

    public void deliverGoods() {
        Transport transport = getTransport();
        transport.deliver();
        System.out.println("Total delivery charges: " + fareCalculator.getDeliveryCharges(transport));
    }

    // *** FACTORY METHOD *** //
    // *** You let the subclasses decide what to instantiate *** //
    public abstract Transport getTransport();
}
