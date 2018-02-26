package yobdc;

public class Problem8 {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        long result = 0;
        int tmp = 0;
        boolean negative = false;
        int symbolCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                symbolCount++;
            }
            if (c != '-' && c != '+' && !(c >= '0' && c <= '9')) {
                break;
            }
            if (symbolCount > 1) {
                break;
            }
            if (c == '-' || c == '+') {
                if (c == '-') {
                    negative = true;
                }
                continue;
            }
            tmp = c - '0';
            result = result * 10 + tmp;
            if (!negative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (negative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return negative ? (int) -result : (int) result;
    }

    public void test() {
        System.out.println(myAtoi("-2147483649"));
    }
}
