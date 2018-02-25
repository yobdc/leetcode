package yobdc;


public class Problem5 {
    public String longestPalindrome(String s) {
        String delimiter = ":";
        String s1 = joinWith(s, delimiter);

        int size = s1.length();
        int maxSize = 1;
        int maxIndex = 0;
        for (int i = 1; i < size - 1; i++) {
            boolean stop = false;
            int distance = 1;
            while (!stop) {
                if (i - distance < 0 || i + distance >= size) {
                    break;
                }
                if (delimiter.equals(s1.charAt(i - distance))) {
                    distance++;
                    continue;
                }
                if (s1.charAt(i - distance) == s1.charAt(i + distance)) {
                    distance++;
                } else {
                    break;
                }
            }
            if (distance > maxSize) {
                maxIndex = i;
                maxSize = distance;
            }
        }

        if (delimiter.equals(s1.charAt(maxIndex))) {
            return s1.substring(maxIndex - maxSize, maxIndex + maxSize).replaceAll(delimiter, "");
        } else {
            return s1.substring(maxIndex - maxSize + 1, maxIndex + maxSize).replaceAll(delimiter, "");
        }
    }

    private String joinWith(String s, String c) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append(c);
        }
        return sb.toString();
    }

    public void test() {
        System.out.println(longestPalindrome("accav"));
    }
}
