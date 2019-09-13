public class ShoppingBasketProvider {
    private ShoppingBasketRepository shoppingBasketRepository;

    public ShoppingBasketProvider(ShoppingBasketRepository shoppingBasketRepository) {

        this.shoppingBasketRepository = shoppingBasketRepository;
    }

    public ShoppingBasket getOrCreate(String userId) {
        return null;
    }
}
