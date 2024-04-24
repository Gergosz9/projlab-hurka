package Java.util;

/**
 * The RepositoryCreationException class represents an exception that is thrown when a repository creation fails.
 * It is a subclass of the RuntimeException class.
 */
public class RepositoryOperationException extends RuntimeException {
    /**
     * Constructs a new RepositoryCreationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public RepositoryOperationException(Throwable cause) {
        super(cause);
    }
}
