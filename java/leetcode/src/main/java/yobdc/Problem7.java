package yobdc;

public class Problem7 {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int current = x;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            current = -x;
        }
        long result = 0;
        int left = 0;
        int base = 1;
        while (current > 0) {
            left = current % 10;
            current = current / 10;
            result = result * 10 + left;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return negative ? (int) -result : (int) result;
    }

    public void test() {
        System.out.println(reverse(1534236469));
    }
}
