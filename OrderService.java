import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orderList = new ArrayList<>();

    public Order placeOrder(List<MenuItem> selectedItems) throws FoodDeliveryException {
        if (selectedItems == null || selectedItems.isEmpty()) {
            throw new FoodDeliveryException("Your cart is empty. Please add items first.");
        } 

        Order newOrder = new Order(selectedItems);
        orderList.add(newOrder);
        System.out.println("  Order placed! Your order ID is " + newOrder.getOrderId());
        return newOrder;
    }

    public void trackOrder(int id) throws FoodDeliveryException {
        Order o = findOrder(id);
        System.out.println("\n  Order Details:");
        System.out.println(o);
    }

    public void updateStatus(int id, Order.Status newStatus) throws FoodDeliveryException {
        Order o = findOrder(id);
        o.setStatus(newStatus);
        System.out.println("  Order " + id + " is now " + newStatus);
    }

    public void showAllOrders() {
        if (orderList.isEmpty()) {
            System.out.println("  No orders yet.");
            return;
        }

        System.out.println("\n  ------- ALL ORDERS -------");
        for (Order o : orderList) {
            System.out.println(o);
            System.out.println("  --------------------------");
        }
    }

    // helper method to find an order by id
    private Order findOrder(int id) throws FoodDeliveryException {
        for (Order o : orderList) {
            if (o.getOrderId() == id) {
                return o;
            }
        }
        throw new FoodDeliveryException("Order ID " + id + " not found.");
    }
}
