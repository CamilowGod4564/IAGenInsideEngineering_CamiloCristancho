package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model;

public enum MembershipType {
    BASIC("Basic", 0.0),
    PREMIUM("Premium", 0.20);

    private final String displayName;
    private final double discountRate;

    MembershipType(String displayName, double discountRate) {
        this.displayName = displayName;
        this.discountRate = discountRate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static MembershipType fromString(String text) {
        for (MembershipType type : MembershipType.values()) {
            if (type.displayName.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return BASIC; // default
    }
}