import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketRepositoryShould {
    @Test
    void not_return_a_basket_if_it_does_not_exist_for_given_user() {
        ShoppingBasketRepository shoppingBasketRepository = new ShoppingBasketRepository();
        String userId = "1";

        assertThat(shoppingBasketRepository.get(userId)).isNull();
    }

    @Test
    void store_a_basket() {
        ShoppingBasketRepository shoppingBasketRepository = new ShoppingBasketRepository();
        String userId = "1";
        LocalDate creationDate = LocalDate.of(1983, 1, 26);
        ShoppingBasket shoppingBasket = new ShoppingBasket(userId, creationDate);
        shoppingBasket.addItem(new Product("20110", "Breaking Bad", 7)); //new Item()

        shoppingBasketRepository.save(shoppingBasket);

        assertThat(shoppingBasketRepository.get(userId)).isEqualTo(shoppingBasket);
    }
}
