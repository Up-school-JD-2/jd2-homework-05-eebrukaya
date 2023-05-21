package enums;

import java.util.Objects;

public enum PaymentMethod {
    CREDIT_CARD("Kredi Kartı");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
