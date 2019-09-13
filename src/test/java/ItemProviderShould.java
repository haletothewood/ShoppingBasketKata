import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemProviderShould {
    @Test
    void create_an_item_given_productId_and_quantity() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ItemProvider itemProvider = new ItemProvider(productRepository);
        String productId = "1";
        Product product = mock(Product.class);
        int quantity = 1;

        when(productRepository.get(productId)).thenReturn(product);


        assertThat(itemProvider.create(productId, quantity)).isEqualTo(new Item(product, quantity));
    }
}
