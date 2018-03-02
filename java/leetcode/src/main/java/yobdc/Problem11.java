package yobdc;

import java.util.Date;

public class Problem11 {
    public int maxArea(int[] height) {
        Date start = new Date();
        int maxArea = 0;

//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int tmpArea = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
//                maxArea = maxArea > tmpArea ? maxArea : tmpArea;
//            }
//        }

        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
        return maxArea;
    }

    public void test() {
        int[] arr = new int[15000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        System.out.println(maxArea(arr));
    }
}
