package domain;

public enum Product {

    T_SHIRT("T-shirt", 15.0),
    PANTS("Pants", 25.0),
    SNEAKERS("Sneakers", 60.0);

    private final String displayName;
    private final double price;

    Product(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }
}