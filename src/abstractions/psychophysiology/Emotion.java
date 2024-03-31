package abstractions.psychophysiology;

public enum Emotion {
    NORMAL("normal"),
    SHOCKED("shocked"),
    ENCHANTED("enchanted"),
    AFRAID("afraid");

    private final String value;

    Emotion(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
