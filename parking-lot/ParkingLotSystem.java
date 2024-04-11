import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class Ticket {
    String vehicleNumber;
    LocalDateTime entranceTime;
    UUID parkingSpotId;
}

abstract class ParkingSpot {
    UUID parkingSpotId;
    boolean isFree;
}

class HandicapParkingSpot extends ParkingSpot {}

class BikeParkingSpot extends ParkingSpot {}

class CarParkingSpot extends ParkingSpot {}


abstract class SpotAllotmentStrategy {
    ParkingSpot allotSpot() { return null; }
}

class NearestSpotAllotmentStrategy extends SpotAllotmentStrategy {
    // Use Min heap to pick nearest free spot
}

abstract class Payment {
    void makePayment() {};
}

class CreditCardPayment extends Payment {}

class CashPayment extends Payment {}

abstract class FareCalculator {
    double calculateTariff() { return 0; };
}

class HourlyFareCalculator extends FareCalculator {}

abstract class Terminal {
    UUID terminalId;
}

class EntranceTerminal extends Terminal {
    ParkingSpot allotParkingSpot(SpotAllotmentStrategy spotAllotmentStrategy) { return null; }

    Ticket issueTicket(ParkingSpot parkingSpot) { return null; }
}

class ExitTerminal extends Terminal {
    void freeParkingSpot() {}

    double calculateTariff(FareCalculator fareCalculator, Ticket ticket) { return 0; }

    void collectFare(Payment paymentStrategy, double tariffAmount) {}
}

public class ParkingLotSystem {
    List<ParkingSpot> parkingSpots;
    List<EntranceTerminal> entranceTerminals;
    List<ExitTerminal> exitTerminals;
    FareCalculator fareCalculator;
    Payment payment;
    SpotAllotmentStrategy spotAllotmentStrategy;
}

class Test {
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    void testAvailability() {
        int terminalId = 0;
        parkingLotSystem.entranceTerminals.get(terminalId).allotParkingSpot(parkingLotSystem.spotAllotmentStrategy);
    }

    void testAllotment() {}

    void testTicketGeneration() {}

    void testFareCalculation() {}

    void testPaymentProcessing() {}

    void testClearance() {}
}

