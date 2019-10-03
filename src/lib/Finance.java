package lib;

/**
 * Finance
 */
public class Finance {

    public static double gratuity(double _subTotal, double _percent) {
        return _subTotal * (_percent / 100);
    }

    public static double compoundSavings(double _monthlySavings, double _interest, int _months) {
        double total = 0;
        for (int i = 0; i < _months; i++) {
            total = (total + _monthlySavings) * (1 + (_interest / 1200));
        }
        return total;
    }

    public static double paymentInterest(double _balance, double _interest) {
        return _balance * (_interest / 1200);
    }

    public static double futureValue(double _investment, double _interest, int _years) {
        
        return _investment * Math.pow(1 + (_interest / 1200), _years * 12);
    }

    public static int[] computeChange(double _change) {
        int[] change = new int[10];
        int div[] = {10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
        int cents = (int) (_change * 100);
        for (int i = 0; i < div.length; i++) {
            change[i] = cents / div[i];
            cents = cents % div[i];
        }
        return change;

    }

    public static double currancyExchange(double _amount, double _rate) {
        return _amount * _rate;
    }

    public static double[] compareCost(double[] _item1, double[] _item2) {
        double[] best = new double[2];
        if (_item1[0] / _item1[1] > _item2[0] / _item2[1]) {
            best = _item1;
        } else { 
            best = _item2;
        }
        return best;
    }
}