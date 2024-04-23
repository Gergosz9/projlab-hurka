package Java.util;

/**
 * The RepositoryCreationException class represents an exception that is thrown when a repository creation fails.
 * It is a subclass of the RuntimeException class.
 */
public class RepositoryCreationException extends RuntimeException {
    /**
     * Constructs a new RepositoryCreationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public RepositoryCreationException(Throwable cause) {
        super(cause);
    }
}
