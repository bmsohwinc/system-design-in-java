public interface State {
    void insertCoin(int coin);
    void selectProduct(int productId);
    void dispenseProduct();
    void cancelRequest();
}
