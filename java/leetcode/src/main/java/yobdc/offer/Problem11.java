package yobdc.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Problem11 {

    public int minArray(int[] numbers) {
        if (numbers == null) {
            return -1;
        }

        for (int i = 0, j = 1; j < numbers.length; i++, j++) {
            if (numbers[i] > numbers[j]) {
                return numbers[j];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        Problem11 app = new Problem11();
        System.out.println(app.minArray(new int[]{32, 1}));
    }
}
