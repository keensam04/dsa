package saman.util.adt.linear.queue;

/**
 * Created by I311125 on 7/31/2017.
 */
public class QueueOverflowException extends Exception {

    public QueueOverflowException(final String msg) {
        super(msg);
    }

    public QueueOverflowException(final Throwable cause) {
        super(cause);
    }

    public QueueOverflowException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
