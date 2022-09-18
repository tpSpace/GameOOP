package StraB.Exceptions;

public class gameException extends Exception {
    public gameException() {
    }

    public gameException(String str) {
        super(str);
    }

    public gameException(Throwable cause) {
        super(cause);
    }

    public gameException(String str, Throwable cause) {
        super(str, cause);
    }
}
