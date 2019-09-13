import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private List<Product> products = new ArrayList<Product>(){{
       add(new Product("10001", "Lord Of The Rings", 10));
       add(new Product("10002", "The Hobbit", 5));
       add(new Product("20001", "Game of Thrones", 10));
       add(new Product("20110", "Breaking Bad", 7));
    }};

    public Product get(String productId) {
        Optional<Product> product = products.stream().filter(p -> p.getId().equals(productId)).findFirst();
        return product.orElse(null);
    }
}
