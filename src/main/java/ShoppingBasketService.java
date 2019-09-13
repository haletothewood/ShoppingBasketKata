public interface ShoppingBasketService {
    void addItem(String userId, String itemId, int quantity);
    ShoppingBasket basketFor(String userId);
}
