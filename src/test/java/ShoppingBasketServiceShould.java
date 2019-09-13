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
        Item item = createTestItem();

        when(shoppingBasketProvider.getOrCreate(userId)).thenReturn(shoppingBasket);
        when(itemProvider.get(item.getId())).thenReturn(item);

        service.addItem(userId, item.getId(), quantity);

        verify(shoppingBasketProvider).getOrCreate(userId);
        verify(itemProvider).get(item.getId());
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

    private Item createTestItem() {
        String id = "1";
        String title = "Breaking Bad";
        int cost = 7;
        return new Item(id, title, cost);
    }
}
