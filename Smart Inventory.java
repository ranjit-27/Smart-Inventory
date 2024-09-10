import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price;
    }
}


public class InventoryManagementSystem {
    private List<Product> inventory = new ArrayList<>();
    private int productIdCounter = 1;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.run();
    }


    public void run() {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. View All Products");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Product product = new Product(productIdCounter++, name, quantity, price);
        inventory.add(product);
        System.out.println("Product added successfully.");
    }


    private void updateProduct() {
        System.out.print("Enter the ID of the product to update: ");
        int id = scanner.nextInt();

        Product product = findProductById(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new quantity: ");
        int newQuantity = scanner.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();

        product.setQuantity(newQuantity);
        product.setPrice(newPrice);

        System.out.println("Product updated successfully.");
    }
    private void viewAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
    }

 
    private void deleteProduct() {
        System.out.print("Enter the ID of the product to delete: ");
        int id = scanner.nextInt();

        Product product = findProductById(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        inventory.remove(product);
        System.out.println("Product deleted successfully.");
    }

   
    private Product findProductById(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
