package yobdc.offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Problem10 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int preA = 0;
        int preB = 1;
        for (int i = 2; i < n; i++) {
            int tmp = preA + preB;
            if (tmp > 1000000007) {
                tmp -= 1000000007;
            }
            preA = preB;
            preB = tmp;
        }
        return (preA + preB) % 1000000007;
    }

    public static void main(String[] args) {
        Problem10 app = new Problem10();
        System.out.println(app.fib(45));
    }
}
