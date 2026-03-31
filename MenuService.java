import java.util.ArrayList;
import java.util.List;
  
public class MenuService { 
 
    private List<MenuItem> menuList = new ArrayList<>(); 
 
    public void addItem(String name, String category, double price) {
        MenuItem item = new MenuItem(name, category, price);
        menuList.add(item); 
        System.out.println("  Added \"" + name + "\" to the menu."); 
    }
 
    public void removeItem(int id) throws FoodDeliveryException { 
        MenuItem toRemove = null;

        for (MenuItem m : menuList) {
            if (m.getItemId() == id) {
                toRemove = m;
                break;
            }
        }

        if (toRemove == null) {
            throw new FoodDeliveryException("No item found with ID " + id);
        }

        menuList.remove(toRemove);
        System.out.println("  Removed \"" + toRemove.getName() + "\" from menu.");
    }

    public void showMenu() {
        if (menuList.isEmpty()) {
            System.out.println("  Menu is empty right now.");
            return;
        }

        System.out.println("\n  ----------- MENU -----------");
        for (MenuItem m : menuList) {
            System.out.println(m);
        }
        System.out.println("  ----------------------------");
    }

    public void searchItem(String keyword) {
        System.out.println("  Results for \"" + keyword + "\" :");
        boolean found = false;

        for (MenuItem m : menuList) {
            if (m.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(m);
                found = true;
            }
        }

        if (!found) {
            System.out.println("  Nothing matched your search.");
        }
    }

    // this is also used by order service to validate item ids
    public MenuItem getItemById(int id) throws FoodDeliveryException {
        for (MenuItem m : menuList) {
            if (m.getItemId() == id) {
                return m;
            }
        }
        throw new FoodDeliveryException("Item with ID " + id + " does not exist.");
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }
}
