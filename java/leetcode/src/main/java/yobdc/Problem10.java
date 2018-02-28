package yobdc;

public class Problem10 {
    public boolean isMatch(String s, String p) {
        if ((p == null && s != null) || (p != null && s == null)) {
            return false;
        }
        if (p == s) {
            return true;
        }
        if (!p.contains("*") && p.length() != s.length()) {
            return false;
        }
        return false;
    }

    public void test() {
        System.out.println(isMatch("aa", "aa"));
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
    }
}
