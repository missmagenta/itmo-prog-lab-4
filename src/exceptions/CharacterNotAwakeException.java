package exceptions;

public class CharacterNotAwakeException extends RuntimeException {
    public CharacterNotAwakeException(String message) {
        super(message);
    }
}
