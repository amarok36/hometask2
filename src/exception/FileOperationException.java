package exception;

public class FileOperationException extends Exception {
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}