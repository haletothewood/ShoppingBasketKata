public class Product {
    private final String id;
    private String title;
    private final int cost;

    public Product(String id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
