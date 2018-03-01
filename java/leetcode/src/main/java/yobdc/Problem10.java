package yobdc;

public class Problem10 {
    public boolean isMatch(String s, String p) {
        if ((p == null && s != null) || (p != null && s == null)) {
            return false;
        }
        if (p == s) {
            return true;
        }
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && isAllFuzzy(p, pIndex)) {
            return true;
        }
        if (sIndex < s.length() && pIndex < p.length()) {
            char curSChar = s.charAt(sIndex);
            char curPChar = p.charAt(pIndex);
            boolean fuzzy = false;
            boolean matchCurrent = false;
            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                fuzzy = true;
            }
            if (curPChar == '.' || curPChar == curSChar) {
                matchCurrent = true;
            }

            if (fuzzy) {
                if (matchCurrent) {
                    return isMatch(s, sIndex, p, pIndex + 2)
                            || isMatch(s, sIndex + 1, p, pIndex)
                            || isMatch(s, sIndex + 1, p, pIndex + 2);
                } else {
                    return isMatch(s, sIndex, p, pIndex + 2);
                }
            } else {
                if (matchCurrent) {
                    return isMatch(s, sIndex + 1, p, pIndex + 1);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    boolean isAllFuzzy(String p, int pIndex) {
        if ((p.length() - pIndex) % 2 == 1) {
            return false;
        }
        for (int i = pIndex + 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }


    public void test() {
        System.out.println(isMatch("aaa", "a*b*"));
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
    }
}
