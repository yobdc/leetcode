package yobdc;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        boolean isEven = size % 2 == 0;
        double result = 0;

        int tarIndex1 = -1;
        int tarIndex2 = -1;
        double median = 0;
        double tmp = 0;

        int current = 0;
        int idx1 = 0;
        int idx2 = 0;

        if (isEven) {
            tarIndex1 = size / 2;
            tarIndex2 = tarIndex1 - 1;
            while (current <= tarIndex2 + 1) {
                if (idx1 >= nums1.length || idx2 >= nums2.length) {
                    if (idx1 < nums1.length) {
                        tmp = nums1[idx1];
                        idx1++;
                    }
                    if (idx2 < nums2.length) {
                        tmp = nums2[idx2];
                        idx2++;
                    }
                } else {
                    if (nums1[idx1] < nums2[idx2]) {
                        tmp = nums1[idx1];
                        idx1++;
                    } else {
                        tmp = nums2[idx2];
                        idx2++;
                    }
                }
                if (current == tarIndex1 || current == tarIndex2) {
                    median += tmp;
                }
                current++;
            }
            result = median / 2;
        } else {
            tarIndex1 = (size - 1) / 2;
            while (current <= tarIndex1) {
                if (idx1 >= nums1.length || idx2 >= nums2.length) {
                    if (idx1 < nums1.length) {
                        tmp = nums1[idx1];
                        idx1++;
                    }
                    if (idx2 < nums2.length) {
                        tmp = nums2[idx2];
                        idx2++;
                    }
                } else {
                    if (nums1[idx1] < nums2[idx2]) {
                        tmp = nums1[idx1];
                        idx1++;
                    } else {
                        tmp = nums2[idx2];
                        idx2++;
                    }
                }
                if (current == tarIndex1) {
                    median += tmp;
                }
                current++;
            }
            result = median;
        }

        return result;
    }
}
