package yobdc.dynamicprogramming;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 类似于斐波那契
 */
public class Problem70 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if(n<=2) {
            return n;
        }
        int preA = 1;
        int preB = 2;
        for (int i=3;i<n;i++) {
            int tmp = preA + preB;
            preA = preB;
            preB = tmp;
        }
        return (preA + preB) ;
    }
}
