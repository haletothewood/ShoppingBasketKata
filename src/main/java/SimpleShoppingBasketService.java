public class SimpleShoppingBasketService implements ShoppingBasketService {
    private ShoppingBasketProvider shoppingBasketProvider;
    private ItemProvider itemProvider;

    public SimpleShoppingBasketService(ShoppingBasketProvider shoppingBasketProvider, ItemProvider itemProvider) {
        this.shoppingBasketProvider = shoppingBasketProvider;
        this.itemProvider = itemProvider;
    }

    @Override
    public void addItem(String userId, String productId, int quantity) {
        ShoppingBasket basket = shoppingBasketProvider.getOrCreate(userId);
        Item item = itemProvider.create(productId, quantity);
        basket.addItem(item);
        shoppingBasketProvider.save(basket);
    }

    @Override
    public ShoppingBasket basketFor(String userId) {
        return shoppingBasketProvider.getOrCreate(userId);
    }
}
