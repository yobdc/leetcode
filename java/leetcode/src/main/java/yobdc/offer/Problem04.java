package yobdc.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 以右上角为root，可以视为类似于二叉搜索树
 */
public class Problem04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = 0;
        int y = 0;
        if (matrix.length > 0) {
            y = matrix[0].length - 1;
        }
        while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
            int current = matrix[x][y];
            if (target == current) {
                return true;
            } else if (target < current) {
                y--;
            } else if (target > current) {
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem04 app = new Problem04();
        int[][] arr = new int[][]{
        };
        System.out.println(app.findNumberIn2DArray(arr, 190));
    }
}
