package ui;

import domain.Product;
import domain.ShippingMethod;
import domain.ShippingQuote;
import registry.ShippingStrategyRegistry;
import service.ShippingService;
import strategy.ShippingStrategy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {

    private final ShippingService shippingService;
    private final ShippingStrategyRegistry registry;
    private final Scanner scanner;

    public ConsoleUI(ShippingService shippingService, ShippingStrategyRegistry registry, Scanner scanner){
        this.shippingService = shippingService;
        this.registry = registry;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Welcome to the Shipping Cost Calculator!");

        Product product = askProduct();
        ShippingMethod method = askShippingMethod();

        ShippingStrategy strategy = registry.get(method);
        ShippingQuote quote = shippingService.calculate(product, strategy);
        double total = shippingService.calculateTotal(product, quote);
        showResult(product, method, quote, total);
    }

    private Product askProduct(){
        System.out.println("Enter product name: ");

        Product[] products = Product.values();
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].getDisplayName()
                    + "(" + products[i].getPrice() + " $)");
        }
        int choise = readOption(1, products.length);
        return products[choise - 1];
    }

    private ShippingMethod askShippingMethod(){
        System.out.println("Select shipping method:");
        ShippingMethod[] methods = ShippingMethod.values();
        for (int i = 0; i < methods.length; i++) {
            System.out.println((i + 1) + ". " + methods[i].getDisplayName());
        }
        int choise = readOption(1, methods.length);
        return methods[choise - 1];
    }

    private int readOption(int min, int max) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < min || choice > max) {
                    System.out.println("Choose a number between " + min + " and " + max + ".");
                    continue;
                }
                return choice;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private void showResult(Product product, ShippingMethod method, ShippingQuote quote, double total){
        System.out.println("\n--- ORDER SUMMARY ---");
        System.out.println("Product: " + product.getDisplayName());
        System.out.println("Product price: $" + product.getPrice());
        System.out.println("Shipping method: " + method.getDisplayName());
        System.out.println("Shipping cost: $" + quote.cost());
        System.out.println("Estimated delivery: " + quote.estimatedDays() + " days");
        System.out.println("TOTAL: $" + total);
    }
}
