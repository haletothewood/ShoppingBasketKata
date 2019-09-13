public class ShoppingBasketProvider {
    private ShoppingBasketRepository shoppingBasketRepository;

    public ShoppingBasketProvider(ShoppingBasketRepository shoppingBasketRepository) {

        this.shoppingBasketRepository = shoppingBasketRepository;
    }

    public ShoppingBasket getOrCreate(String userId) {
        ShoppingBasket basket = shoppingBasketRepository.get(userId);
        return basket != null ? basket : new ShoppingBasket(userId);
    }
}
