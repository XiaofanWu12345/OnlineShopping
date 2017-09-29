/**
 * SiteOverloadException gets thrown when the site is experiencing a traffic
 * overload.
 *
 * @author xwu319
 * @version 1.0
 */
public class SiteOverloadException extends Exception {
    /**
     * Contruct an SiteOverloadException with a default message
     */
    public SiteOverloadException() {
        super("The site is experiencing an increased amount of traffic.");
    }

    /**
     * Contruct an SiteOverloadException
     * @param msg the message to pass in to construct the exception
     */
    public SiteOverloadException(String msg) {
        super(msg);
    }
}
