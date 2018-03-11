package yobdc;

import java.util.*;

public class Problem13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = buildMap();
        List<String> keys = new ArrayList<>();
        keys.addAll(map.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int result = 0;
        int start = 0;
        while (start < s.length()) {
            for (String key : keys) {
                if (s.indexOf(key, start) == start) {
                    result += map.get(key);
                    start += key.length();
                    break;
                }
            }
        }

        return result;
    }

    private Map<String, Integer> buildMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);

        map.put("X", 10);
        map.put("XX", 20);
        map.put("XXX", 30);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("LX", 60);
        map.put("LXX", 70);
        map.put("LXXX", 80);
        map.put("XC", 90);

        map.put("C", 100);
        map.put("CC", 200);
        map.put("CCC", 300);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("DC", 600);
        map.put("DCC", 700);
        map.put("DCCC", 800);
        map.put("CM", 900);

        map.put("M", 1000);
        map.put("MM", 2000);
        map.put("MMM", 3000);
        return map;
    }

    public void test() {
        System.out.println(romanToInt("MDCXCV"));
    }
}
