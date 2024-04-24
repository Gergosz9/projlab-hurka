package Java.util;

/**
 * The GameSavingException class represents an exception that is thrown when a game saving operation fails.
 * It is a subclass of the RuntimeException class.
 */
public class GameSavingException extends RuntimeException {
    public GameSavingException(Throwable cause) {
        super(cause);
    }

    public GameSavingException(String message) {
        super(message);
    }
}
