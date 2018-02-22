package yobdc;

public class Problem50 {
    public double myPow(double x, int n) {
        long num = n;
        num = num >= 0 ? num : -num;
        double result = pow2(x, num);

        return n >= 0 ? result : 1 / result;
    }

    public double pow2(double x, long n) {
        double result = 1;
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n % 2 == 0) {
            result = pow2(x, n / 2);
            result *= result;
        } else {
            result = pow2(x, (n - 1) / 2);
            result = result * result * x;
        }
        return result;
    }
}
