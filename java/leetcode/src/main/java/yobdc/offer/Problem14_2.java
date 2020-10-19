package yobdc.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1）
 * ，每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段
 * ，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 2*3*3*3...为最佳解
 */
public class Problem14_2 {
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
            long left = cuttingRope2(i);
            long right = cuttingRope2(n - i);
            long tmp = left * right;
            if (tmp > 1000000007) {
                tmp = tmp - 1000000007;
            }
            max = (int)Math.max(max, tmp);
        }
        map.put(n, max);
        return max;
    }

    public long cuttingRope2(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 4) {
            return n;
        }
        long max = n;
        for (int i = 1; i <= n / 2; i++) {
            long left = cuttingRope2(i);
            long right = cuttingRope2(n - i);
            long tmp = left * right;
            if (tmp > 1000000007) {
                tmp = tmp - 1000000007;
            }
            max = (int)Math.max(max, tmp);
        }
        map.put(n, (int)max);
        return max;
    }

    public static void main(String[] args) {
        Problem14_2 app = new Problem14_2();
        System.out.println(app.cuttingRope(120));
    }
}