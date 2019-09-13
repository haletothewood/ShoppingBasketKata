public class ItemProvider {
    private ProductRepository productRepository;

    public ItemProvider(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product get(String productId) {
        return null;
    }

    public Item create(String productId, int quantity) {
        Product product = productRepository.get(productId);
        return new Item(product, quantity);
    }
}
