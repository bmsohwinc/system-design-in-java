package factory.pattern;




public class FactoryPattern {

    public static void main(String[] args) {
        RoadTransportFactory roadTransportFactory = new RoadTransportFactory();
        RoadTransport roadTransport = roadTransportFactory.getInstanceOf();
        
    }

}
