/**
 * Represent a product called Kyshadow
 *
 * @author xwu319
 * @version 1.0
 */
public class Kyshadow extends Product {

    /**
     * Contruct a Kyshadow product
     * @param c a String that represents the color of the product
     * @param limit a boolean to represent if the product is LimitedEdition
     */
    public Kyshadow(String c, boolean limit) {
        super(c, limit, 42.00);
    }

    /**
     * toString method for the product
     * @return the string representation of the product
     */
    @Override
    public String toString() {
        return super.toString() + " Kyshadow: $" + String.format("%.2f", 42.00);
    }
}
