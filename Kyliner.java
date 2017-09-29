/**
 * Represent a product called Kyliner
 *
 * @author xwu319
 * @version 1.0
 */
public class Kyliner extends Product {

    /**
     * Contruct a Kyliner product
     * @param c a String that represents the color of the product
     * @param limit a boolean to represent if the product is LimitedEdition
     */
    public Kyliner(String c, boolean limit) {
        super(c, limit, 26.00);
    }

    /**
     * toString method for the product
     * @return the string representation of the product
     */
    @Override
    public String toString() {
        return super.toString() + " Kyliner: $" + String.format("%.2f", 26.00);
    }
}
