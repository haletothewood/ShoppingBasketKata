import java.time.LocalDate;
import java.util.Objects;

public class ShoppingBasket {
    private String userId;
    private LocalDate creationDate;
    private Product product;

    public ShoppingBasket(String userId, LocalDate creationDate) {
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public void addItem(Product product) {
        this.product = product;
    }

    String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, creationDate, product);
    }
}
