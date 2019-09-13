import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingBasketRepository {

    private List<ShoppingBasket> baskets = new ArrayList<>();

    public ShoppingBasket get(String userId) {
        Optional<ShoppingBasket> basket = baskets.stream()
                                                 .filter(b -> b.getUserId().equals(userId))
                                                 .findFirst();
        return basket.orElse(null);
    }

    public void save(ShoppingBasket basket) {
        baskets.add(basket);
    }
}
