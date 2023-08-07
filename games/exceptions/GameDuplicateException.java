package games.exceptions;

public class GameDuplicateException extends RuntimeException {
    public GameDuplicateException(final String message) {
        super(message);
    }
}
