package yobdc.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 13. 机器人的运动范围
 */
public class Problem13 {
    Map<String, Boolean> map = new HashMap<>();

    public int movingCount(int m, int n, int k) {
        return movingCount(m, n, k, 0, 0);
    }

    public int movingCount(int m, int n, int k, int x, int y) {
        String key = "" + x + "," + y;
        if (!map.containsKey(key)
                && check(x, y, k)) {
            map.put(key, true);
            if (x - 1 >= 0) {
                movingCount(m, n, k, x - 1, y);
            }
            if (x + 1 < m) {
                movingCount(m, n, k, x + 1, y);
            }
            if (y - 1 >= 0) {
                movingCount(m, n, k, x, y - 1);
            }
            if (y + 1 < n) {
                movingCount(m, n, k, x, y + 1);
            }
        }
        return map.size();
    }

    public boolean check(int x, int y, int k) {
        int sum = 0;
        while (x / 10 >= 0) {
            sum += x % 10;
            if (sum > k) {
                return false;
            }
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        while (y / 10 >= 0) {
            sum += y % 10;
            if (sum > k) {
                return false;
            }
            y = y / 10;
            if (y == 0) {
                break;
            }
        }

        return sum <= k;
    }

    public static void main(String[] args) {
        Problem13 app = new Problem13();
        System.out.println(app.movingCount(2, 3, 17));
    }
}
