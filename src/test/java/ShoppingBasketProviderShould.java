import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ShoppingBasketProviderShould {

    private TimeProvider timeProvider;
    private ShoppingBasketRepository shoppingBasketRepository;
    private ShoppingBasketProvider shoppingBasketProvider;

    @BeforeEach
    void setUp() {
        timeProvider = mock(TimeProvider.class);
        shoppingBasketRepository = Mockito.mock(ShoppingBasketRepository.class);
        shoppingBasketProvider = new ShoppingBasketProvider(shoppingBasketRepository, timeProvider);
    }

    @Test
    void create_a_new_basket_for_a_new_user_adding_first_item() {
        String userId = "1";
        LocalDate creationDate = LocalDate.of(1983, 1, 26);
        ShoppingBasket expected = new ShoppingBasket(userId, creationDate);
        when(timeProvider.getTime()).thenReturn(LocalDate.of(1983, 1, 26));

        assertThat(shoppingBasketProvider.getOrCreate(userId)).isEqualTo(expected);
    }

    @Test
    void get_basket_for_same_user_when_item_exits_in_basket() {
        String userId = "1";
        LocalDate creationDate = LocalDate.of(1983, 1, 26);
        ShoppingBasket expected = new ShoppingBasket(userId, creationDate);
        Item dummyItem = createTestItem();
        expected.addItem(dummyItem);

        when(shoppingBasketRepository.get(userId)).thenReturn(expected);

        assertThat(shoppingBasketProvider.getOrCreate(userId)).isEqualTo(expected);
    }

    @Test
    void save_basket_to_repository() {
        String userId = "1";
        LocalDate creationDate = LocalDate.of(1983, 1, 26);
        ShoppingBasket basket = new ShoppingBasket(userId, creationDate);
        Item dummyItem = createTestItem();
        basket.addItem(dummyItem);

        shoppingBasketProvider.save(basket);

        verify(shoppingBasketRepository).save(basket);
    }

    private Item createTestItem() {
        String title = "Breaking Bad";
        int cost = 7;
        String id = "20110";
        return new Item(id, title, cost);
    }
}
