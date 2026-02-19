package service;

import domain.Product;
import domain.ShippingQuote;
import strategy.ShippingStrategy;

public class ShippingService {

    public ShippingQuote calculate(Product product, ShippingStrategy strategy) {
        return strategy.calculate(product);
    }

    public double calculateTotal(Product product, ShippingQuote quote) {
        return product.getPrice() + quote.cost();
    }
}
