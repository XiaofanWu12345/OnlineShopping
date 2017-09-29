import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
/**
 * Represents the website server
 *
 * @author Isabella Plonk
 * @author xwu319
 * @version 1.0
 */
public class Server {
    private static final int PERCENT_FAIL = 50;
    private static final int PERCENT_OUT_OF_STOCK = 10;

    /**
     * Check the traffic condition of the site
     * @throws SiteOverloadException if the site's traffic is overloaded
     */
    public static void checkTraffic() throws SiteOverloadException {
        Random r = new Random();
        int num = r.nextInt(100);
        if (num < PERCENT_FAIL) {
            throw new SiteOverloadException();
        }
    }

    /**
     * Check whether an item is available in the stock
     * @param product the product to be added to the shopping cart
     * @throws ProductOutOfStockException if the product trying to add is out of
     * stock.
     */
    public static void checkStock(Product product)
            throws ProductOutOfStockException {
        Random r = new Random();
        int num = r.nextInt(100);
        if (num < PERCENT_OUT_OF_STOCK) {
            throw new ProductOutOfStockException(product);
        }
    }

    /**
     * Scans in all of the products
     * from a text file into an array list
     * @return an array list of all of the products
     */
    public static ArrayListInterface<Product> getProducts() {
        try {
            ArrayListInterface<Product> products = new MyArrayList<>();
            Scanner csv = new Scanner(new File("products.csv"));
            csv.nextLine(); // Skip the header
            while (csv.hasNext()) {
                String[] line = csv.nextLine().split("-");
                Product product;
                if (line[0].equals("Kyshadow")) {
                    product = new Kyshadow(line[1],
                        Boolean.valueOf(line[2]));
                } else if (line[0].equals("Kyliner")) {
                    product = new Kyliner(line[1],
                        Boolean.valueOf(line[2]));
                } else {
                    product = new LipKit(line[1],
                        Boolean.valueOf(line[2]));
                }
                products.add(product);
            }
            return products;
        } catch (FileNotFoundException e) {
            System.out.println("Check location of products.csv.");
            System.exit(1);
        }
        return new MyArrayList<>();
    }
}
