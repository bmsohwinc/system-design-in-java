public class IdleState implements State {

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("VM IDLE: In Idle State now!");
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin(int coin) {
        System.out.println("VM IDLE: Coin inserted. Transitioning to COIN_INSERTED state");
        vendingMachine.insertCoin(coin);
        vendingMachine.currentState = new CoinInsertedState(vendingMachine);
    }


    @Override
    public void selectProduct(int productId) {
        System.out.println("VM IDLE. Please insert coin to select product.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("VM IDLE: Sorry, no product selected.");
    }

    @Override
    public void cancelRequest() {
        System.out.println("VM IDLE: Sorry, no active request.");
    }
    
}
