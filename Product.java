/**
 * Represent a product can be sold
 *
 * @author xwu319
 * @version 1.0
 */
public class Product {
    private String color;
    private boolean isLimitedEdition;
    private double price;

    /**
     * Contruct a Kyliner product
     * @param c a String that represents the color of the product
     * @param ile a boolean to represent if the product is LimitedEdition
     * @param p a double that represents the product's price
     */
    public Product(String c, boolean ile, double p) {
        color = c;
        isLimitedEdition = ile;
        price = p;
    }

    /**
     * getter method for color
     * @return the string that represents the color of the product
     */
    public String getColor() {
        return color;
    }

    /**
     * getter method for isLimitedEdition
     * @return the string that represents if the product is limited edition
     */
    public boolean getIsLimitedEdition() {
        return isLimitedEdition;
    }

    /**
     * getter method for price
     * @return the double that represents the product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * toString method for the product
     * @return the string representation of the product
     */
    @Override
    public String toString() {
        if (isLimitedEdition) {
            return "Limited edition " + color;
        } else {
            return color;
        }
    }

    /**
     * Equals method for the product
     * @return the boolean represents whether two products equal one another
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (!(other instanceof Product)) {
            return false;
        } else {
            return (color.equals(((Product) other).color)
                    && isLimitedEdition == ((Product) other).isLimitedEdition
                    && price == ((Product) other).price);
        }
    }

    /**
     * hashcode method for the equals method
     * @return an int
     */
    @Override
    public int hashCode() {
        int result = 10;
        int c = color.hashCode();
        c += isLimitedEdition ? 1 : 0;
        c += (int) (Double.doubleToLongBits(price)
            ^ (Double.doubleToLongBits(price) >>> 32));
        return c + 31 * result;
    }
}
