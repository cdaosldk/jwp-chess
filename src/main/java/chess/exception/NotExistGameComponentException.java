package chess.exception;

public class NotExistGameComponentException extends RuntimeException {
    public NotExistGameComponentException(String message) {
        super(message);
    }
}