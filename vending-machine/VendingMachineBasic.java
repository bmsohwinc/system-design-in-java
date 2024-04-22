/*
 * 
 * User
 * - gets all items + prices
 * - chooses one item
 * - pays amount
 *   - fails (insufficient funds/service issue)
 *   - no item dispensed
 * - picks item
 * 
 * Vending machine
 * - shows items
 * - accepts payments
 * - dispenses item
 * 
 * Admin
 * - adds item
 * - updates prices
 * 
 * ------
 * 
 * Item {
 * - UUID id
 * - String name
 * - double price
 * }
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

class Item {
    UUID id;
    String name;
    double price;
}

enum PaymentType {
    CREDIT_CARD,
    CASH;
}

interface PaymentProcessor {
    boolean pay(double amount);
}

class CrediCardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean pay(double amount) {
        return true;
    }
    
}

class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean pay(double amount) {
        return true;
    }
    
}


public class VendingMachineBasic {

    private List<Item> itemsDb = new ArrayList<>();

    private CashPaymentProcessor cashPaymentProcessor = new CashPaymentProcessor();

    private CrediCardPaymentProcessor cardPaymentProcessor = new CrediCardPaymentProcessor();

    List<Item> getAllItems() {
        return itemsDb;
    }

    Item getItemById(UUID itemId) {
        List<Item> itemsMatchedById = itemsDb.stream().filter(item -> item.id.equals(itemId)).collect(Collectors.toList());
        return itemsMatchedById.get(0);
    }

    Item buyItem(UUID itemId, PaymentType paymentType) throws Exception {
        Item item = getItemById(itemId);
        if (paymentType == PaymentType.CREDIT_CARD) {
            cardPaymentProcessor.pay(item.price);
        } else if (paymentType == PaymentType.CASH) {
            cashPaymentProcessor.pay(item.price);
        } else {
            throw new Exception("Unsupported payment method");
        }
        removeItemFromDb(itemId);
        return item;
    }

    private void removeItemFromDb(UUID itemId) {
        itemsDb = itemsDb.stream().filter(item -> !item.id.equals(itemId)).collect(Collectors.toList());
    }
}
