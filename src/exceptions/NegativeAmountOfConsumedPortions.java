package exceptions;

public class NegativeAmountOfConsumedPortions extends RuntimeException {
    public NegativeAmountOfConsumedPortions(String message) {
        super(message);
    }
}
