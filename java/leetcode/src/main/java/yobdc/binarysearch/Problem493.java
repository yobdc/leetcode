package yobdc.binarysearch;

/**
 * 493. 翻转对
 */
public class Problem493 {
    public int reversePairs(int[] nums) {
        int result = mergeSort(nums, 0, nums.length - 1);
        return result;
    }

    int mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int count = 0;
        if (start + 1 == end) {
            if ((long) nums[start] > (long) 2 * nums[end]) {
                count++;
            }
            if (nums[start] < nums[end]) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
            return count;
        }
        int mid = (start + end) >> 1;
        int l1 = mergeSort(nums, start, mid);
        int l2 = mergeSort(nums, mid + 1, end);
        int[] arr = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = mid + 1;
        int arrIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if ((long) nums[leftIndex] > (long) 2 * nums[rightIndex]) {
                count++;
            }
            if (nums[leftIndex] < nums[rightIndex]) {
                arr[arrIndex++] = nums[rightIndex++];
            } else {
                arr[arrIndex++] = nums[leftIndex++];
            }
        }
        if (leftIndex <= mid) {
            System.arraycopy(nums, leftIndex, arr, arrIndex, mid - leftIndex + 1);
        }
        if (rightIndex <= end) {
            System.arraycopy(nums, rightIndex, arr, arrIndex, end - rightIndex + 1);
        }
        System.arraycopy(arr, 0, nums, start, arr.length);

        return l1 + l2 + count;
    }

    public static void main(String[] args) {
        Problem493 app = new Problem493();
        app.reversePairs(new int[]{1, 3, 2, 3, 1});
    }
}
