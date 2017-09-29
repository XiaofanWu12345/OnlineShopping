/**
 * Represents a Credit Card
 *
 * @author xwu319
 * @version 1.0
 */
public class CreditCard {
    private double balance;

    /**
     * Contruct a Credit Card
     * @param b the balance of a credit card
     */
    public CreditCard(double b) {
        balance = b;
    }

    /**
     * Pay with the Credit Card
     * @param amount the amount to pay for by the credit card
     * @throws InsufficientFundsException when the balance of the credit card is
     * not enough to pay for the amount
     */
    public void pay(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException();
        }
    }
}
