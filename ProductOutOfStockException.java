/**
 * ProductOutOfStockException gets thrown when the product is not in stock.
 *
 * @author xwu319
 * @version 1.0
 */
public class ProductOutOfStockException extends ElementNotFoundException {

    /**
     * Contruct an ProductOutOfStockException
     * @param p the product to pass in to construct the exception
     */
    public ProductOutOfStockException(Product p) {
        super(p, p.toString()
                + " is no longer in stock and cannot be purchased.");
    }

    /**
     * Contruct an ProductOutOfStockException with a customized message
     * @param p the product to pass in to construct the exception
     * @param message the String message to pass in to construct the exception
     */
    public ProductOutOfStockException(Product p, String message) {
        super(p, message);
    }

}
