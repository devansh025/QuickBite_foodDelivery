import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum Status {
        PLACED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, CANCELLED
    }

    // order ids will start from 101
    private static int idCounter = 101;

    private int orderId;
    private List<MenuItem> items;
    private double total; 
    private Status status;

    public Order(List<MenuItem> items) {
        this.orderId = idCounter++;
        this.items = new ArrayList<>(items);
        this.status = Status.PLACED;

        // calculate total at the time of placing
        double sum = 0;
        for (MenuItem m : items) {
            sum += m.getPrice();
        }
        this.total = sum;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    @Override
    public String toString() {
        String result = "  Order ID : " + orderId + "\n";
        result += "  Items    :\n";
        for (MenuItem m : items) {
            result += "             - " + m.getName() + "  (Rs." + m.getPrice() + ")\n";
        }
        result += "  Total    : Rs." + total + "\n";
        result += "  Status   : " + status;
        return result;
    }
}
