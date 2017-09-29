/**
 * Represents the checkout page
 *
 * @author Isabella Plonk
 * @author xwu319
 * @version 1.0
 */
public class CheckoutPage {
    private MyArrayList<Product> shoppingCart;
    private ArrayListInterface<Product> itemsInStock;

    /**
     * Construct a check out page
     */
    public CheckoutPage() {
        shoppingCart = new MyArrayList<Product>();
        itemsInStock = Server.getProducts();
    }

    /**
     * Sum up items' prices in shopping cart
     * @return double the total cost of the items in shopping cart
     */
    public double getSubtotal() {
        double subtotal = 0.0;
        for (int i = 0; i < shoppingCart.getNumElements(); i++) {
            if (shoppingCart.get(i) != null) {
                subtotal += shoppingCart.get(i).getPrice();
            }
        }
        return subtotal;
    }

    /**
     * Caluclate the shipping cost in shopping cart
     * @return double the shipping cost of the items in shopping cart
     */
    public double getShipping() {
        if (getSubtotal() > 50.0 || getSubtotal() == 0.0) {
            return 0.0;
        } else {
            return 8.95;
        }
    }

    /**
     * Calclate the total cost
     * @return double the total cost of shopping
     */
    public double getTotal() {
        return (getSubtotal() + getShipping());
    }

    /**
     * Adds item to shopping cart
     * @param product the product to be added to the shopping cart
     */
    public void addToCart(Product product) {
        if (product.getIsLimitedEdition()) {
            try {
                Server.checkStock(product);
                shoppingCart.add(product);
            } catch (ProductOutOfStockException e) {
                System.out.println(e.getMessage());
                ((MyArrayList<Product>) itemsInStock).removeAll(product);
            }
        } else {
            shoppingCart.add(product);
        }
        System.out.println("Successfully add " + product.toString()
                        + "to the shopping cart.");
    }

    /**
     * Pay for items in shopping cart
     * @param card the credit card used to pay for items in the shopping cart
     */
    public void payForCart(CreditCard card) {
        if (getSubtotal() != 0.0) {
            try {
                Server.checkTraffic();
                card.pay(getTotal());
                shoppingCart.clear();
                System.out.println("Payment successful.");
            } catch (SiteOverloadException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientFundsException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Remove the item in certain poistion of the shopping cart
     * @param position the position in the shopping cart to remove the item from
     */
    public void removeFromCart(int position) {
        shoppingCart.remove(position);
        System.out.printf("Removes item at position %d successfully%n.",
                position);
    }

    /**
     * Getter method for shoppingCart
     * @return the check out page's shopping cart
     */
    public MyArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Getter method for itemsInStock
     * @return the check out page's itemsInStock
     */
    public ArrayListInterface<Product> getItemsInStock() {
        return itemsInStock;
    }

    /**
     * toString method for the check out page
     * @return the string representation of the check out page
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                           KYLIE COSMETICS℠\n");
        s.append("----------------------------------------------------------"
            + "------------\n");
        int i = 1;
        for (Product product : shoppingCart) {
            s.append("(" + i + ") " + product + "\n");
            i++;
        }
        s.append(String.format("Total number of items: %d%n",
            shoppingCart.size()));
        s.append(String.format("Subtotal: $%.2f%n", getSubtotal()));
        s.append(String.format("Shipping: $%.2f%n", getShipping()));
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("Total: $%.2f%n", getTotal()));
        s.append("Enter 'pay' to checkout or 'back' to"
                + " return to the main menu.\n");
        s.append("Enter the number of an item to remove it"
                + " from the shopping cart.\n");
        return s.toString();
    }
}
