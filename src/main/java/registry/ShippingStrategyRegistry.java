package registry;

import domain.ShippingMethod;
import service.ShippingService;
import strategy.AirShippingStrategy;
import strategy.GroundShippingStrategy;
import strategy.SeaShippingStrategy;
import strategy.ShippingStrategy;

import java.util.EnumMap;
import java.util.Map;

public class ShippingStrategyRegistry {

    private final Map<ShippingMethod, ShippingStrategy> strategies;

    public ShippingStrategyRegistry() {
        strategies = new EnumMap<>(ShippingMethod.class);
        strategies.put(ShippingMethod.AIR, new AirShippingStrategy());
        strategies.put(ShippingMethod.GROUND, new GroundShippingStrategy());
        strategies.put(ShippingMethod.SEA, new SeaShippingStrategy());
    }

    public ShippingStrategy get(ShippingMethod method) {
        ShippingStrategy strategy = strategies.get(method);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy registered for: " + method);
        }
        return strategy;
    }
}
