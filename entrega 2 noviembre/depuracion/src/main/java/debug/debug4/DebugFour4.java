package debug.debug4;

// This class discounts prices by 10%
public class DebugFour4 {
    public static void main(String[] args) {
        final double discountRate = 0.90;
        int price = 100;
        double price2 = 100.00;
        tenPercentOff1(price, discountRate);
        tenPercentOff2(price2, discountRate);
    }

    public static void tenPercentOff1(double price, double discountRate) {
        double newPrice = price * discountRate;
        System.out.println("Ten percent off " + price);
        System.out.println("  New price is " + newPrice);
    }

    public static void tenPercentOff2(double price2, double discountRate) {
        double newPrice = price2 * discountRate;
        System.out.println("Ten percent off " + price2);
        System.out.println("  New price is " + newPrice);
    }
}
