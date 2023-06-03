package abstractThings;

public enum State {
    SLEEP("asleep"),
    AWAKE("awake");

    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getState() {
        return value;
    }
}

