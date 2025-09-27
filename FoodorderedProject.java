import java.util.*;

class FoodItem {
    int id;
    String name;
    double price;

    FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Override equals() and hashCode() for correct Map behavior
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FoodItem)) return false;
        FoodItem other = (FoodItem) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Fooddelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu
        List<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem(1, "Pizza", 250.00));
        menu.add(new FoodItem(2, "Burger", 120.00));
        menu.add(new FoodItem(3, "Pasta", 150.00));
        menu.add(new FoodItem(4, "Sandwich", 80.00));
        menu.add(new FoodItem(5, "Coffee", 60.00));

        // Order cart
        Map<FoodItem, Integer> cart = new HashMap<>();

        System.out.println("===== Welcome to Food Ordering System =====");

        while (true) {
            System.out.println("\n---- MENU ----");
            for (FoodItem item : menu) {
                System.out.println(item.id + ". " + item.name + " - ₹" + item.price);
            }
            System.out.println("0. Checkout");
            System.out.print("Choose item ID: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            FoodItem selected = null;
            for (FoodItem item : menu) {
                if (item.id == choice) {
                    selected = item;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("❌ Invalid choice! Try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            cart.put(selected, cart.getOrDefault(selected, 0) + qty);
            System.out.println("✅ Added " + qty + " x " + selected.name + " to cart.");
        }

        // Bill
        System.out.println("\n===== BILL =====");
        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : cart.entrySet()) {
            FoodItem item = entry.getKey();
            int qty = entry.getValue();
            double cost = qty * item.price;
            System.out.println(item.name + " x " + qty + " = ₹" + cost);
            total += cost;
        }
        System.out.println("-------------------");
        System.out.println("TOTAL = ₹" + total);
        System.out.println("Thank you! Visit again.");
    }
}
