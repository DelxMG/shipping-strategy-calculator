package app;

import registry.ShippingStrategyRegistry;
import service.ShippingService;
import ui.ConsoleUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShippingService service = new ShippingService();
        ShippingStrategyRegistry registry = new ShippingStrategyRegistry();
        Scanner scanner = new Scanner(System.in);

        ConsoleUI ui = new ConsoleUI(service, registry, scanner);
        ui.start();
    }
}
