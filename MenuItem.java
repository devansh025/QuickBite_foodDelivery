public class MenuItem {

    // using a static counter to auto assign ids
    private static int idCounter = 1;

    private int itemId;
    private String name;
    private String category;
    private double price;

    public MenuItem(String name, String category, double price) {
        this.itemId = idCounter++;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    @Override
    public String toString() {
        return "  [" + itemId + "] " + name + "  |  " + category + "  |  Rs." + price;
    }
}
