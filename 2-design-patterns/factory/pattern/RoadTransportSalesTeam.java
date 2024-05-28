package factory.pattern;

public class RoadTransportSalesTeam {

    public void sellRoadTransport(RoadTransport roadTransport) {
        RoadTransportPricingTeam roadTransportPricingTeam = new RoadTransportPricingTeam();
        Double roadTransportPrice = roadTransportPricingTeam.getTransportPrice(roadTransport);
        System.out.println(roadTransport + " was sold for price: " + roadTransportPrice);
    }

}
