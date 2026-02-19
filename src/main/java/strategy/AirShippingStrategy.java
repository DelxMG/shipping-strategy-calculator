package strategy;

import domain.Product;
import domain.ShippingQuote;

public class AirShippingStrategy implements ShippingStrategy {

    private static final double BASE_COST = 20.0;
    private static final int ESTIMATED_DAYS = 2;

    @Override
    public ShippingQuote calculate(Product product) {
        return new ShippingQuote(BASE_COST, ESTIMATED_DAYS);
    }
}