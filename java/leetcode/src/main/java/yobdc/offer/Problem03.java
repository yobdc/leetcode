package yobdc.offer;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 解法：数组内交换数字到对应index，如果发现一样，则表示有重复。
 */
public class Problem03 {
    public int findRepeatNumber(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (i != j && nums[j] == nums[i]) {
                return j;
            } else {
                int tmp = nums[j];
                nums[j] = j;
                nums[i] = tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem03 app = new Problem03();
        app.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }
}
