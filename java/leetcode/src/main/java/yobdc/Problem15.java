package yobdc;

import java.util.ArrayList;
import java.util.List;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        result.add(tmp);
                    }
                }
            }
        }
        return result;
    }

    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
