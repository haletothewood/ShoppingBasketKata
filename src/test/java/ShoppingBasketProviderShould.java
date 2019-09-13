import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ShoppingBasketProviderShould {
    @Test
    void create_a_new_basket_for_a_new_user_adding_first_item() {
        ShoppingBasketRepository shoppingBasketRepository = Mockito.mock(ShoppingBasketRepository.class);
        ShoppingBasketProvider shoppingBasketProvider = new ShoppingBasketProvider(shoppingBasketRepository);

        String userId = "1";
        ShoppingBasket expected = new ShoppingBasket(userId);

        assertThat(shoppingBasketProvider.getOrCreate(userId)).isEqualTo(expected);
    }
    @Test
    void get_basket_for_same_user_when_item_exits_in_basket() {
        ShoppingBasketRepository shoppingBasketRepository = Mockito.mock(ShoppingBasketRepository.class);
        ShoppingBasketProvider shoppingBasketProvider = new ShoppingBasketProvider(shoppingBasketRepository);

        String userId = "1";
        ShoppingBasket expected = new ShoppingBasket(userId);
        Item dummyItem = new Item("1");
        expected.addItem(dummyItem);

        when(shoppingBasketRepository.get(userId)).thenReturn(expected);

        assertThat(shoppingBasketProvider.getOrCreate(userId)).isEqualTo(expected);
    }
}
