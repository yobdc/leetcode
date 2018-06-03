package yobdc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class Problem17 {
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        List<String> result = build(map, digits, 0, null);

        return result;
    }

    public List<String> build(Map<String, String> map, String digits, int index, List<String> preResult) {
        if (preResult == null) {
            preResult = new ArrayList<>();
        }
        if (digits == null || digits.isEmpty() || index >= digits.length()) {
            return preResult;
        }
        List<String> thisResult = new ArrayList<>();
        String vals = map.get(String.valueOf(digits.charAt(index)));
        if (preResult.isEmpty()) {
            for (int i = 0; i < vals.length(); i++) {
                thisResult.add(String.valueOf(vals.charAt(i)));
            }
        } else {
            for (int i = 0; i < vals.length(); i++) {
                for (String tmp : preResult) {
                    thisResult.add(tmp + vals.charAt(i));
                }
            }
        }
        return build(map, digits, index + 1, thisResult);
    }

    public void test() {
        System.out.println(letterCombinations("23"));
    }
}
