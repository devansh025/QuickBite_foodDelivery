# QuickBite Lite 🍕

A simple food delivery system built in Java. Manage menu items and orders all from your console.

## What It Does

- **View & manage a menu** — add, remove, or search for food items
- **Place orders** — pick items from the menu and see your total
- **Track orders** — see the status of your orders anytime
- **Update status** — mark orders as preparing, out for delivery, or delivered

No database, no file system, no login. Just a clean console app that works instantly.

## How to Run

### Setup
1. Create a folder for the project (e.g., `E:\QuickBiteLite`)
2. Inside it, create a `src` folder
3. Put all 6 `.java` files in the `src` folder

### Compile & Run

Open cmd in your project folder and run:

```bash
mkdir out
javac -d out src\MenuItem.java src\Order.java src\FoodDeliveryException.java src\MenuService.java src\OrderService.java src\Main.java
java -cp out Main
```

That's it! The app starts with 6 default menu items ready to test.

## Project Structure

```
QuickBiteLite/
├── src/
│   ├── MenuItem.java              (food item model)
│   ├── Order.java                 (order model with status)
│   ├── FoodDeliveryException.java  (custom exceptions)
│   ├── MenuService.java           (menu operations)
│   ├── OrderService.java          (order operations)
│   └── Main.java                  (console interface)
└── out/                           (compiled files — auto-created)
```

## Files Explained

**MenuItem.java** — Represents a food item
- id, name, category, price
- Simple getters and toString

**Order.java** — Represents a customer order
- id, list of items, total price, status (enum)
- Status can be: PENDING, PREPARING, OUT_FOR_DELIVERY, DELIVERED
- Calculates total automatically when items are added

**FoodDeliveryException.java** — Custom exception
- Thrown when something goes wrong (invalid item, order not found, etc.)

**MenuService.java** — Handles all menu operations
- addItem(), removeItem(), viewMenu(), searchItem()
- Keeps items in an ArrayList

**OrderService.java** — Handles all order operations
- placeOrder(), getOrder(), updateStatus(), viewAllOrders()
- Keeps orders in an ArrayList with auto-incrementing IDs

**Main.java** — The console interface
- Displays a menu with 9 options
- Takes user input and calls the right service method

## How to Use (Step by Step)

When you launch the app, you'll see:

```
=========== QuickBite Lite ===========
1. View Full Menu
2. Search Menu Item
3. Add New Item to Menu
4. Remove Item from Menu
5. Place an Order
6. Track an Order
7. Update Order Status
8. View All Orders
9. Exit
```

### Try this flow:

1. **Press 1** → See all 6 default items (Burger, Pizza, Fries, etc.)
2. **Press 5** → Place an order
   - Enter item IDs (e.g., 1, 2, 3)
   - Type 0 when done
   - See your order ID and total
3. **Press 6** → Track that order by entering the order ID
4. **Press 7** → Update the order status to "PREPARING"
5. **Press 6 again** → See the status changed
6. **Press 3** → Add your own menu item
7. **Press 8** → View all orders you've placed
8. **Press 9** → Exit

## Java Concepts Covered

- **OOP** — Classes, objects, encapsulation
- **Collections** — ArrayList for items and orders
- **Enums** — Order.Status (PENDING, PREPARING, OUT_FOR_DELIVERY, DELIVERED)
- **Custom Exceptions** — FoodDeliveryException for error handling
- **Exception Handling** — try/catch blocks throughout
- **File I/O** — (not included in lite version, but structure supports it)

## Default Menu

The app comes with these items pre-loaded:

| ID | Item | Category | Price |
|----|------|----------|-------|
| 1 | Burger | Main | $8 |
| 2 | Pizza | Main | $12 |
| 3 | Fries | Sides | $3 |
| 4 | Coke | Beverages | $2 |
| 5 | Ice Cream | Desserts | $5 |
| 6 | Salad | Sides | $6 |

## Troubleshooting

**"javac is not recognized"**
- Java isn't installed or not in PATH
- Download & install Java JDK from [java.com](https://java.com)

**"Main class not found"**
- Make sure the `out` folder was created
- Check that all 6 files compiled (no red errors)

**"Can't find MenuItem.java"**
- All `.java` files must be in the `src` folder
- Check the path is correct

## What's NOT Included

- Database (everything is in-memory)
- File saving (data disappears when you exit)
- User login/accounts
- GUI (console only)
- Real payment processing

## Future Ideas

Want to extend it? Try:
- Save/load data to files (JSON or .txt)
- Add user accounts with login
- Implement a simple rating system
- Add payment methods
- Create a GUI using Swing or JavaFX

## Notes

This is a learning project — great for understanding:
- How OOP structures a real app
- Collections and data management
- Exception handling in practice
- Console-based user interfaces

Code is intentionally simple and human-readable, not production-grade. No fancy patterns or frameworks — just straightforward Java.

---

**Made with ☕ and 🍕**
