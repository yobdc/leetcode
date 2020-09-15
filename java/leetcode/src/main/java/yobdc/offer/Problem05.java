package yobdc.offer;

/**
 * 剑指 Offer 05. 替换空格
 */
public class Problem05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; s != null && i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem05 app = new Problem05();
        System.out.println(app.replaceSpace("We are happy."));
    }
}
