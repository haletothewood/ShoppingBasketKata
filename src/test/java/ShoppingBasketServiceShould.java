import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShoppingBasketServiceShould {

    @Test
    void create_a_new_basket_for_item() {
        ShoppingBasketProvider shoppingBasketProvider = Mockito.mock(ShoppingBasketProvider.class);
        ShoppingBasket shoppingBasket = Mockito.mock(ShoppingBasket.class);
        ItemProvider itemProvider = Mockito.mock(ItemProvider.class);
        SimpleShoppingBasketService service = new SimpleShoppingBasketService(shoppingBasketProvider, itemProvider);
        String userId = "1";
        int quantity = 1;
        Product product = createTestProduct();

        when(shoppingBasketProvider.getOrCreate(userId)).thenReturn(shoppingBasket);
        when(itemProvider.get(product.getId())).thenReturn(item);

        service.addItem(userId, product.getId(), quantity);

        verify(shoppingBasketProvider).getOrCreate(userId);
        verify(itemProvider).get(product.getId());
        verify(shoppingBasket).addItem(item);
    }


    @Test
    void use_the_same_basket_for_each_user() {
        ShoppingBasketProvider shoppingBasketProvider = Mockito.mock(ShoppingBasketProvider.class);
        ItemProvider itemProvider = Mockito.mock(ItemProvider.class);
        SimpleShoppingBasketService service = new SimpleShoppingBasketService(shoppingBasketProvider, itemProvider);
        ShoppingBasket shoppingBasket = Mockito.mock(ShoppingBasket.class);
        String userId = "1";

        when(shoppingBasketProvider.getOrCreate(userId)).thenReturn(shoppingBasket);

        service.basketFor(userId);

        verify(shoppingBasketProvider).getOrCreate(userId);
    }

    private Product createTestProduct() {
        String id = "1";
        String title = "Breaking Bad";
        int cost = 7;
        return new Product(id, title, cost);
    }
}
