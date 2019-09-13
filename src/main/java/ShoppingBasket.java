import java.time.LocalDate;
import java.util.Objects;

public class ShoppingBasket {
    private String userId;
    private LocalDate creationDate;
    private Item item;

    public ShoppingBasket(String userId, LocalDate creationDate) {
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public void addItem(Item item) {
        this.item = item;
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
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, creationDate, item);
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "userId='" + userId + '\'' +
                ", creationDate=" + creationDate +
                ", item=" + item +
                '}';
    }
}
