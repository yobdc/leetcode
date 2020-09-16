package yobdc.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 14- I. 剪绳子
 */
public class Problem14 {
    Map<Integer, Integer> map = new HashMap<>();

    public int cuttingRope(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        int max = 1;
        for (int i = 1; i <= n / 2; i++) {
            int left = cuttingRope2(i);
            int right = cuttingRope2(n - i);
            max = Math.max(max, left * right);
        }
        map.put(n, max);
        return max;
    }

    public int cuttingRope2(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 4) {
            return n;
        }
        int max = n;
        for (int i = 1; i <= n / 2; i++) {
            int left = cuttingRope2(i);
            int right = cuttingRope2(n - i);
            max = Math.max(max, left * right);
        }
        map.put(n, max);
        return max;
    }

    public static void main(String[] args) {
        Problem14 app = new Problem14();
        System.out.println(app.cuttingRope(32));
    }
}
