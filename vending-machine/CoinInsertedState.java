public class CoinInsertedState implements State {

    private VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        System.out.println("VM COIN_INSERTED: In COIN_INSERTED State now.");
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin(int coin) {
        System.out.println("VM COIN_INSERTED: Coin inserted.");
        vendingMachine.insertCoinUtil(coin);
    }


    @Override
    public void selectProduct(int productId) {
        System.out.println("VM COIN_INSERTED. Product selected. Transitioning to PRODUCT_SELECTED state.");
        vendingMachine.selectProductUtil(productId);
        vendingMachine.currentState = new ProductSelectedState(vendingMachine);
    }

    @Override
    public void dispenseProduct() {
        System.out.println("VM COIN_INSERTED: Please select a product to dispense.");
    }

    @Override
    public void cancelRequest() {
        System.out.println("VM COIN_INSERTED: Refunding coins. Thank you.");
        vendingMachine.cancelRequestUtil();
        vendingMachine.currentState = new IdleState(vendingMachine);
    }    
}
