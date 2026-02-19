package strategy;

import domain.Product;
import domain.ShippingQuote;

public interface ShippingStrategy {

    ShippingQuote calculate(Product product);

}
