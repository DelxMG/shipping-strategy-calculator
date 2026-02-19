package domain;

public enum ShippingMethod {

    AIR("Air shipping"),
    GROUND("Ground shipping"),
    SEA("Sea shipping");

    private final String displayName;

    ShippingMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
