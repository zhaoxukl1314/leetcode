import java.text.DecimalFormat;
import java.util.*;

public class Solution50 {

    public static void main(String[] args) {
        double result = myPow(2.00000, 10);
        System.out.println(result);
    }

    public static double myPow(double x, int n) {
        return n >= 0 ? getResult(x, n): 1.0 / getResult(x, -n);
    }

    private static double getResult(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = getResult(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

}
