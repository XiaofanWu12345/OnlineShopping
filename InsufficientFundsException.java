/**
 * InsufficientFundsException gets thrown when there's not enough credit card
 * balance.
 *
 * @author xwu319
 * @version 1.0
 */
public class InsufficientFundsException extends Exception {
    /**
     * Contruct an InsufficientFundsException
     * @param msg the message to pass in to construct the exception
     */
    public InsufficientFundsException(String msg) {
        super(msg);
    }

    /**
     * Directly contruct an InsufficientFundsException with a default message
     */
    public InsufficientFundsException() {
        super("The credit card balance is too low to cover the order's cost.");
    }


}
