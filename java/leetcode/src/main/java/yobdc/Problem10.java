package yobdc;

public class Problem10 {
    public boolean isMatch(String s, String p) {
        if ((p == null && s != null) || (p != null && s == null)) {
            return false;
        }
        if (p == s) {
            return true;
        }
        boolean match = true;
        if (!p.contains("*")) {
            if (p.length() != s.length()) {
                return false;
            } else {
                for (int i = 0; i < p.length(); i++) {
                    char pChar = p.charAt(i);
                    if (pChar != '.' && pChar != s.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return match;
    }

    public void test() {
        System.out.println(isMatch("aaa", "..."));
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
    }
}
