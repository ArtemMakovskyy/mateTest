package tasks;

public class TipCalculator {
    public Integer calculateTip(double amount, String rating) {
        switch (rating.toLowerCase()) {
            case "terrible":
                return 0;
            case "poor":
                return (int) Math.ceil(amount / 100 * 5);
            case "good":
                return (int) Math.ceil(amount / 10);
            case "great":
                return (int) Math.ceil(amount / 100 * 15);
            case "excellent":
                return (int) Math.ceil(amount / 100 * 20);
            default:
                return null;
        }
    }
}
