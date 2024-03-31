package food;

public enum FoodGrade {
    UNKNOWN("unknown"),
    GOOD("good"),
    BAD("bad");

    private final String value;

    FoodGrade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}