package factory.pattern;


public class FactoryPattern {

    private static Transporter transporter;

    private static String env = "ROAD"; // Can come from system property/env variable

    private static final FareCalculator fareCalculator = new FareCalculator();

    public static void main(String[] args) {
        configureSystem();
        transporter.deliverGoods();
    }

    private static void configureSystem() {
        if ("ROAD".equals(env)) {
            transporter = new RoadTransporter(fareCalculator);
        } else {
            transporter = new SeaTransporter(fareCalculator);
        }
    }

}
