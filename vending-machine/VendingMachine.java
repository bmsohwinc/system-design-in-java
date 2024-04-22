import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    List<Integer> coins;
    List<Integer> products;
    int totalSum;
    State currentState;
    int selectedProduct;

    public VendingMachine() {
        this.coins = new ArrayList<>();
        this.products = List.of(10, 5, 15, 20, 25);
        this.currentState = new IdleState(this);
        this.selectedProduct = -1;
        this.totalSum = 0;
    }

    public void viewProducts() {
        System.out.println(products);
    }

    public void insertCoin(int coin) {
        currentState.insertCoin(coin);
    }
    
    public void selectProduct(int productId) {
        currentState.selectProduct(productId);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void cancelRequest() {
        currentState.cancelRequest();
    }

    public void insertCoinUtil(int coin) {
        coins.add(coin);
        totalSum += coin;
    }

    public void selectProductUtil(int productId) {
        selectedProduct = productId;
    }

    public void cancelRequestUtil() {
        refundCoins();
        resetSelection();
    }
    
    public boolean canDispenseProduct() {
        // Product should be available
        // Funds should be sufficient
        return isValidProductId() && totalSum >= products.get(selectedProduct);
    }

    public void dispenseProductUtil() {
        System.out.println("VM: Take your product! " + selectedProduct);
        dispenseChange();
        resetSelection();
    }

    private boolean isValidProductId() {
        return selectedProduct > 0 && selectedProduct < products.size();
    }

    private void refundCoins() {
        System.out.println(coins);
        coins = new ArrayList<>();
        System.out.println("VM: Coins refunded.");
    }

    private void resetSelection() {
        selectedProduct = -1;
    }

    private void dispenseChange() {
        int change = totalSum - products.get(selectedProduct);
        System.out.println("VM: Please collect the change of " + change);
        totalSum -= change;
    }

}
