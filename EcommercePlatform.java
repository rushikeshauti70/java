import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    public Product() {
        this.name = "unknown";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public static double applyDiscount(double total) {
        if (total > 500) {
            return total * 0.85;
        } else if (total > 200) {
            return total * 0.90;
        } else if (total > 100) {
            return total * 0.95;
        }
        return total;
    }

    public void displayProduct() {
        System.out.println(name + " | PRICE: $" + price + " | QUANTITY: " + quantity + " | TOTAL: " + getTotalCost());
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product p1 = new Product("Laptop", 800, 1);
        Product p2 = new Product("Headphone", 150, 2);

        System.out.println("Enter product name:");
        String name = scanner.nextLine();

        System.out.println("Enter product price:");
        double price = scanner.nextDouble();

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();

        Product userProduct = new Product(name, price, quantity);

        System.out.println("\nOrder Summary:");
        p1.displayProduct();
        p2.displayProduct();
        userProduct.displayProduct();

        double totalCost = p1.getTotalCost() + p2.getTotalCost() + userProduct.getTotalCost();
        double finalAmount = Product.applyDiscount(totalCost);

        System.out.println("\nTotal cost before discount: " + totalCost);
        System.out.println("Discounted price: " + finalAmount);

        System.out.println("Thank you for shopping!");

        scanner.close();
    }
}