package abstractions;

public enum Location {
    INITIAL("initial"),
    ASTRONOMICAL_CABIN("astronomical cabin"),
    FOOD_COMPARTMENT("food compartment"),
    EARTH("Earth");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
