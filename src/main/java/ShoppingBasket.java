import java.util.Objects;

public class ShoppingBasket {
    private String userId;
    private Item item;

    public ShoppingBasket(String userId) {
        this.userId = userId;
    }

    public void addItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, item);
    }
}
