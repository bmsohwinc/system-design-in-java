public class ProductSelectedState implements State {
    private VendingMachine vendingMachine;

    public ProductSelectedState(VendingMachine vendingMachine) {
        System.out.println("VM PRODUCT_SELECTED: In PRODUCT_SELECTED State now.");
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin(int coin) {
        System.out.println("VM PRODUCT_SELECTED: Sorry, cannot insert coin.");
    }


    @Override
    public void selectProduct(int productId) {
        System.out.println("VM PRODUCT_SELECTED. Product selected.");
        vendingMachine.selectProductUtil(productId);
    }

    @Override
    public void dispenseProduct() {
        System.out.println("VM PRODUCT_SELECTED: Dispensing product: " + vendingMachine.selectedProduct);
        if (vendingMachine.canDispenseProduct()) {
            vendingMachine.dispenseProductUtil();
            vendingMachine.currentState = new IdleState(vendingMachine);
        } else {
            System.out.println("VM PRODUCT_SELECTED: Insufficient coins inserted. Please insert more coins.");
            vendingMachine.currentState = new CoinInsertedState(vendingMachine);
        }
    }

    @Override
    public void cancelRequest() {
        System.out.println("VM PRODUCT_SELECTED: Refunding coins. Thank you.");
        vendingMachine.cancelRequestUtil();
        vendingMachine.currentState = new IdleState(vendingMachine);
    }
}
