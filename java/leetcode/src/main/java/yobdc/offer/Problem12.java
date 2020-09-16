package yobdc.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 12. 矩阵中的路径
 */
public class Problem12 {
    Map<String, Boolean> map = new HashMap<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean result = exist(board, word, i, j, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int x, int y, int wordIndex) {
        if (!map.containsKey("" + x + "," + y)
                && board[x][y] == word.charAt(wordIndex)) {
            map.put("" + x + "," + y, true);
            if (wordIndex + 1 == word.length()) {
                return true;
            }
            boolean result = false;
            if (x - 1 >= 0) {
                result = exist(board, word, x - 1, y, wordIndex + 1);
            }
            if (result) {
                return true;
            }
            if (y + 1 < board[x].length) {
                result = exist(board, word, x, y + 1, wordIndex + 1);
            }
            if (result) {
                return true;
            }
            if (x + 1 < board.length) {
                result = exist(board, word, x + 1, y, wordIndex + 1);
            }
            if (result) {
                return true;
            }
            if (y - 1 >= 0) {
                result = exist(board, word, x, y - 1, wordIndex + 1);
            }
            if (result) {
                return true;
            }
            map.remove("" + x + "," + y);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem12 app = new Problem12();
        System.out.println(app.exist(new char[][]{
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab".toCharArray(),
        }, "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
