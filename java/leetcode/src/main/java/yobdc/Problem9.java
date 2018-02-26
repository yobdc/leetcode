package yobdc;

public class Problem9 {
    public boolean isPalindrome(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
            return false;
        }
        String str = new Integer(x).toString();
        int left = str.length() / 2 - 1;
        int right = str.length() / 2;
        if (str.length() % 2 == 1) {
            right = str.length() / 2 + 1;
        }
        int distance = 0;
        while (left - distance >= 0 && right + distance < str.length()) {
            if (str.charAt(left - distance) != str.charAt(right + distance)) {
                return false;
            }
            distance++;
        }
        return true;
    }

    public void test() {
        System.out.println(isPalindrome(-2147447412));
    }
}
