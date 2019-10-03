package lib;

/**
 * Time
 */
public class Time {

    public static int futureDoW(int _currentDay, int _after) {
        return (_currentDay + _after) % 7;
    }

    public static int daysInMonth(int _year, int _month) {
        boolean isLeapYear = (_year % 4 == 0 && _year % 100 != 0) || (_year % 400 == 0);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return (_month == 2) && isLeapYear ? 29 : days[_month - 1];
    }

    public static int dayOfWeek(int[] _date) {
        int q = _date[2];
        int m = _date[1];
        int k = _date[0] % 100;
        int j = _date[0] / 100;
        return (q + (26 * (m + 1) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
    }

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return month[(int)(Math.random() * 100) % 12];
        
    }

    public static int[] minToYears(int _minutes) {
        final int MINUTES_PER_DAY = 1440;
        final int MINUTES_PER_YEAR = 525_600;
        int[] result = new int[3];
        result[0] = _minutes / MINUTES_PER_YEAR;
        result[1] = (_minutes % MINUTES_PER_YEAR) / MINUTES_PER_DAY;
        result[2] = (_minutes % MINUTES_PER_YEAR) % MINUTES_PER_DAY; 
        return result;
    }
}