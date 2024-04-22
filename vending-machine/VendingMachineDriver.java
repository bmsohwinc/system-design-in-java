/*
 * VM can be in few states:
 * 1. Idle
 *     | (coin insertion)
 * 2. Coin Inserted State
 *     | (select product)
 * 3. Product Selected State
 *     | (dispense product)
 * 1. Idle
 * 
 */

public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        vendingMachine.viewProducts();

        vendingMachine.currentState.cancelRequest();
        vendingMachine.currentState.dispenseProduct();

        vendingMachine.currentState.insertCoin(10);
        vendingMachine.currentState.selectProduct(1);
        vendingMachine.currentState.dispenseProduct();

    }
}
