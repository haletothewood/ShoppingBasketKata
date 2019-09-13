import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class ShoppingBasketServiceShould {

    @Test
    void create_a_new_basket_for_item() {
        ShoppingBasketProvider shoppingBasketProvider = mock(ShoppingBasketProvider.class);
        ShoppingBasket shoppingBasket = mock(ShoppingBasket.class);
        ItemProvider itemProvider = mock(ItemProvider.class);
        Item item = mock(Item.class);

        SimpleShoppingBasketService service = new SimpleShoppingBasketService(shoppingBasketProvider, itemProvider);
        String userId = "1";
        int quantity = 1;
        Product product = createTestProduct();

        when(shoppingBasketProvider.getOrCreate(userId)).thenReturn(shoppingBasket);
        ;
        when(itemProvider.create(product.getId(), quantity)).thenReturn(item);

        service.addItem(userId, product.getId(), quantity);

        verify(shoppingBasketProvider).getOrCreate(userId);
        verify(itemProvider).create(product.getId(), quantity);
        verify(shoppingBasket).addItem(item);
    }


    @Test
    void use_the_same_basket_for_each_user() {
        ShoppingBasketProvider shoppingBasketProvider = mock(ShoppingBasketProvider.class);
        ItemProvider itemProvider = mock(ItemProvider.class);
        SimpleShoppingBasketService service = new SimpleShoppingBasketService(shoppingBasketProvider, itemProvider);
        ShoppingBasket shoppingBasket = mock(ShoppingBasket.class);
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
