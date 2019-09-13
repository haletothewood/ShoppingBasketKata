import java.time.LocalDate;

public class ShoppingBasketProvider {
    private ShoppingBasketRepository shoppingBasketRepository;
    private TimeProvider timeProvider;

    public ShoppingBasketProvider(ShoppingBasketRepository shoppingBasketRepository, TimeProvider timeProvider) {
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.timeProvider = timeProvider;
    }

    public ShoppingBasket getOrCreate(String userId) {
        ShoppingBasket basket = shoppingBasketRepository.get(userId);

        return basket != null ? basket : createShoppingBasket(userId);
    }

    private ShoppingBasket createShoppingBasket(String userId) {
        LocalDate creationDate = timeProvider.getTime();
        return new ShoppingBasket(userId, creationDate);
    }

    public void save(ShoppingBasket basket) {
        shoppingBasketRepository.save(basket);
    }
}
