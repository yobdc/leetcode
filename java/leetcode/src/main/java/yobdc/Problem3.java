package yobdc;


import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<Character>();
        int start = 0;
        int current = 0;
        int maxSize = 0;
        int strSize = s.length();

        while (start + maxSize < strSize) {
            char c = s.charAt(start + current);
            while (!charSet.contains(c)) {
                charSet.add(c);
                current++;
                if (start + current < strSize) {
                    c = s.charAt(start + current);
                } else {
                    break;
                }
            }
            maxSize = maxSize > current ? maxSize : current;
            int oldStart = start;
            start = s.indexOf(c, start) + 1;
            String subStr = s.substring(oldStart, start);
            charSet.clear();
            current = 0;
        }

        return maxSize;
    }
}
