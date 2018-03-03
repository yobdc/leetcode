package yobdc;

/**
 * I(1),X(10),C(100),M(1000),V(5),L(50),D(500)
 */
public class Problem12 {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        String[][] table = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
                , {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}
                , {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}
                , {"", "M", "MM", "MMM"}};
        for (int i = 3; i >= 0; i--) {
            int base = (int) Math.pow(10, i);
            int start = (int) Math.floor(num / base);
            if (start > 0) {
                sb.append(table[i][start]);
            }
            num = num % base;
        }
        return sb.toString();
    }

    public void test() {
        System.out.println(intToRoman(91));
    }
}
