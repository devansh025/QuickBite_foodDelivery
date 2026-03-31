import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {

    static Scanner sc = new Scanner(System.in);
    static MenuService menuService = new MenuService();
    static OrderService orderService = new OrderService();

    public static void main(String[] args) {

        // adding some default items so we can test right away
        menuService.addItem("Veg Burger", "Snack", 79.0);
        menuService.addItem("Paneer Pizza", "Main Course", 199.0);
        menuService.addItem("Masala Fries", "Snack", 59.0);
        menuService.addItem("Mango Shake", "Beverage", 89.0);
        menuService.addItem("Gulab Jamun", "Dessert", 49.0);
        menuService.addItem("Veg Biryani", "Main Course", 149.0);

        System.out.println("\n  Welcome to QuickBite!");

        int choice = 0;

        while (choice != 9) {
            printMenu();

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a valid number.");
                continue;
            }

            System.out.println();

            if (choice == 1) {
                menuService.showMenu();

            } else if (choice == 2) {
                System.out.print("  Enter keyword: ");
                String kw = sc.nextLine().trim();
                menuService.searchItem(kw);

            } else if (choice == 3) {
                addItem();

            } else if (choice == 4) {
                removeItem();

            } else if (choice == 5) {
                placeOrder();

            } else if (choice == 6) {
                System.out.print("  Enter order ID: ");
                try {
                    int id = Integer.parseInt(sc.nextLine().trim());
                    orderService.trackOrder(id);
                } catch (NumberFormatException e) {
                    System.out.println("  Invalid ID entered.");
                } catch (FoodDeliveryException e) {
                    System.out.println("  Error: " + e.getMessage());
                }

            } else if (choice == 7) {
                updateStatus();

            } else if (choice == 8) {
                orderService.showAllOrders();

            } else if (choice == 9) {
                System.out.println("  Thanks for using QuickBite. Bye!");

            } else {
                System.out.println("  Invalid option. Try again.");
            }

            System.out.println();
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("  ================================");
        System.out.println("       QuickBite Food App");
        System.out.println("  ================================");
        System.out.println("  1. View Menu");
        System.out.println("  2. Search Item");
        System.out.println("  3. Add Item to Menu");
        System.out.println("  4. Remove Item from Menu");
        System.out.println("  5. Place Order");
        System.out.println("  6. Track Order");
        System.out.println("  7. Update Order Status");
        System.out.println("  8. View All Orders");
        System.out.println("  9. Exit");
        System.out.println("  ================================");
        System.out.print("  Your choice: ");
    }

    static void addItem() {
        try {
            System.out.print("  Item name    : ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                throw new FoodDeliveryException("Name cannot be blank.");
            }

            System.out.print("  Category     : ");
            String cat = sc.nextLine().trim();

            if (cat.isEmpty()) {
                throw new FoodDeliveryException("Category cannot be blank.");
            }

            System.out.print("  Price (Rs.)  : ");
            double price = Double.parseDouble(sc.nextLine().trim());

            if (price <= 0) {
                throw new FoodDeliveryException("Price must be more than 0.");
            }

            menuService.addItem(name, cat, price);

        } catch (NumberFormatException e) {
            System.out.println("  Please enter a valid price.");
        } catch (FoodDeliveryException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }

    static void removeItem() {
        menuService.showMenu();
        System.out.print("  Enter item ID to remove: ");
        try {
            int id = Integer.parseInt(sc.nextLine().trim());
            menuService.removeItem(id);
        } catch (NumberFormatException e) {
            System.out.println("  Please enter a valid ID.");
        } catch (FoodDeliveryException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }

    static void placeOrder() {
        menuService.showMenu();

        List<MenuItem> cart = new ArrayList<>();

        System.out.println("  Enter item IDs one by one. Type 0 when done.");

        while (true) {
            System.out.print("  Item ID: ");
            try {
                int id = Integer.parseInt(sc.nextLine().trim());

                if (id == 0) {
                    break;
                }

                MenuItem item = menuService.getItemById(id);
                cart.add(item);
                System.out.println("  Added: " + item.getName());

            } catch (NumberFormatException e) {
                System.out.println("  That's not a valid number, try again.");
            } catch (FoodDeliveryException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }

        try {
            Order o = orderService.placeOrder(cart);
            System.out.println("\n  Your order summary:");
            System.out.println(o);
        } catch (FoodDeliveryException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }

    static void updateStatus() {
        System.out.print("  Enter order ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.println("  Choose new status:");
            System.out.println("  1. PREPARING");
            System.out.println("  2. OUT_FOR_DELIVERY");
            System.out.println("  3. DELIVERED");
            System.out.println("  4. CANCELLED");
            System.out.print("  Choice: ");

            String opt = sc.nextLine().trim();
            Order.Status status = null;

            if (opt.equals("1")) {
                status = Order.Status.PREPARING;
            } else if (opt.equals("2")) {
                status = Order.Status.OUT_FOR_DELIVERY;
            } else if (opt.equals("3")) {
                status = Order.Status.DELIVERED;
            } else if (opt.equals("4")) {
                status = Order.Status.CANCELLED;
            } else {
                System.out.println("  Invalid choice.");
                return;
            }

            orderService.updateStatus(id, status);

        } catch (NumberFormatException e) {
            System.out.println("  Invalid order ID.");
        } catch (FoodDeliveryException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }
}
