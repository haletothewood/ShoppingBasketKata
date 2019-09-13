import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketServiceFeature {
    @Test
    void add_items_to_a_basket() {
        SimpleShoppingBasketService service = new SimpleShoppingBasketService(
                new ShoppingBasketProvider(
                        new ShoppingBasketRepository(),
                        new MockTimeProvider()),
                new ItemProvider(
                        new ProductRepository())
        );

        service.addItem("1", "20110", 1);
        ShoppingBasket expected = new ShoppingBasket("1", LocalDate.of(1983, 1, 26));
        expected.addItem(new Item(new Product("20110", "Breaking Bad", 7), 1));

        assertThat(service.basketFor("1")).isEqualTo(expected);
    }

    @Test
    void add_items_to_the_same_basket_if_already_exists() {
        SimpleShoppingBasketService service = new SimpleShoppingBasketService(
                new ShoppingBasketProvider(
                        new ShoppingBasketRepository(),
                        new MockTimeProvider()),
                new ItemProvider(
                        new ProductRepository())
        );

        service.addItem("1", "20110", 1);
        service.addItem("1", "20001", 1);

        ShoppingBasket expected = new ShoppingBasket("1", LocalDate.of(1983, 1, 26));
        expected.addItem(new Item(new Product("20110", "Breaking Bad", 7), 1));
        expected.addItem(new Item(new Product("20001", "Game Of Thrones", 10), 1));
    }

    private class MockTimeProvider implements TimeProvider {
        @Override
        public LocalDate getTime() {
            return LocalDate.of(1983, 1, 26);
        }
    }
}
