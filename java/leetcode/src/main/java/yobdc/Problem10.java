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
        } else {
            String[] pList = p.split("\\*");
            int startIndex = 0;
            for (int i = 0; i < pList.length; i++) {
                String pStr = pList[i];
                if (pStr == null || pStr.isEmpty()) {
                    continue;
                }
                int tmpStart = indexOf(s, pStr, startIndex);
                if (tmpStart < 0) {
                    return false;
                } else {
                    startIndex += pStr.length();
                }
            }
            if (startIndex < s.length() && p.charAt(p.length() - 1) != '*') {
                return false;
            }
        }
        return match;
    }

    private int indexOf(String src, String tar, int startIndex) {
        if (tar.contains(".")) {
            boolean found = false;
            for (int i = 0; i < src.length() - startIndex - tar.length(); i++) {
                if (src.charAt(startIndex + i) == tar.charAt(i) || tar.charAt(i) == '.') {
                    continue;
                } else {

                }
            }
        } else {
            return src.indexOf(tar, startIndex);
        }
    }

    public void test() {
        System.out.println(isMatch("abbbc", "a*b*"));
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
    }
}
