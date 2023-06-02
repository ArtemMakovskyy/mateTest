package tasks;

import java.util.ArrayList;
import java.util.List;

public class SupermarketQueue {
    public int calculateTotalTime(int[] customers, int checkout) {
        List<Checkout> checkoutList = new ArrayList<>();
        for (int i = 0; i < checkout; i++) {
            checkoutList.add(i, new Checkout());
        }
        int currentCheckout = 0;
        for (int i = 0; i < customers.length; i++) {
            checkoutList.get(currentCheckout).addInt(customers[i]);
            currentCheckout++;
            if (currentCheckout == checkout) {
                currentCheckout = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < checkout; i++) {
            System.out.println(checkoutList.get(i).getSum() + " " + checkoutList.get(i));
            if (max < checkoutList.get(i).getSum()) {
                max = checkoutList.get(i).getSum();
            }
        }
        return max;
    }

    static class Checkout {
        private List<Integer> customers = new ArrayList<>();

        void addInt(int time) {
            customers.add(time);
        }

        Integer getSum() {
            Integer sum = 0;
            if (customers.size() == 0) {
                return 0;
            }
            for (int i = 0; i < customers.size(); i++) {
                sum = sum + customers.get(i);
            }
            return sum;
        }

        @Override
        public String toString() {
            return customers.toString();
        }
    }
}
