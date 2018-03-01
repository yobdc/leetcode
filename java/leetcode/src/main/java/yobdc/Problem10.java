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

        int sIndex = 0;
        int pIndex = 0;
        char prePChar = 0;
        char postPChar = 0;
        while (sIndex < s.length() && pIndex < p.length()) {
            char sChar = s.charAt(sIndex);
            char pChar = p.charAt(pIndex);

            if (p.length() - pIndex > s.length() - sIndex) {
                if (pIndex + 1 < p.length()) {
                    if (p.charAt(pIndex + 1) == '*') {
                        pIndex += 2;
                        continue;
                    }
                }
            }

            if (pChar == '.') {
                sIndex++;
                pIndex++;
                prePChar = pChar;
            } else if (pChar == '*') {
                if (prePChar == '.' || prePChar == sChar) {
                    sIndex++;
                    if (p.length() - pIndex > s.length() - sIndex) {
                        pIndex++;
                    }
                } else {
                    if (pIndex + 1 < p.length()) {
                        postPChar = p.charAt(pIndex + 1);
                    } else {
                        postPChar = 0;
                    }
                    if (postPChar == sChar) {
                        sIndex++;
                        pIndex += 2;
                        prePChar = postPChar;
                    } else {
                        return false;
                    }
                }
            } else {
                if (sChar != pChar) {
                    if (pIndex + 1 < p.length()) {
                        postPChar = p.charAt(pIndex + 1);
                    }
                    if (postPChar == '*') {
                        pIndex++;
                        prePChar = pChar;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    sIndex++;
                    pIndex++;
                    prePChar = pChar;
                }
            }
        }
        if (sIndex - s.length() != pIndex - p.length()) {
            if (pIndex + 1 == p.length() && p.charAt(pIndex) == '*') {
                match = true;
            } else {
                match = false;
            }
        }

        return match;
    }

    public void test() {
        System.out.println(isMatch("aaa", "a*a*a"));
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
    }
}
