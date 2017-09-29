/**
 * Represent a product called LipKit
 *
 * @author xwu319
 * @version 1.0
 */
public class LipKit extends Product {

    /**
     * Contruct a LipKit product
     * @param c a String that represents the color of the product
     * @param limit a boolean to represent if the product is LimitedEdition
     */
    public LipKit(String c, boolean limit) {
        super(c, limit, 29.00);
    }

    /**
     * toString method for the product
     * @return the string representation of the product
     */
    @Override
    public String toString() {
        return super.toString() + " LipKit: $" + String.format("%.2f", 29.00);
    }
}
