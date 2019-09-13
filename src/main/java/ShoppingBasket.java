import java.util.Objects;

public class ShoppingBasket {
    private String userId;

    public ShoppingBasket(String userId) {

        this.userId = userId;
    }

    public void addItem(Item item) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
