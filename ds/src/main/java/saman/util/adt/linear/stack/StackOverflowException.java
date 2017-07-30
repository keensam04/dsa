package saman.util.adt.linear.stack;

/**
 * Created by I311125 on 7/31/2017.
 */
public class StackOverflowException extends Exception {

    public StackOverflowException(final String msg) {
        super(msg);
    }

    public StackOverflowException(final Throwable cause) {
        super(cause);
    }

    public StackOverflowException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
