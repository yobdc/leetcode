package yobdc.offer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>
 * 类似于斐波那契问题，最后的总可能数为f(n)，最后一步可能是走1步，可能走2步，则f(n)=f(n-1)+f(n-2)
 */
public class Problem10_2 {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int preA = 1;
        int preB = 2;
        for (int i = 3; i < n; i++) {
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
        Problem10_2 app = new Problem10_2();
        System.out.println(app.numWays(7));
    }
}
