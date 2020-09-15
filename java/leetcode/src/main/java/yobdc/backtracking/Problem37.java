package yobdc.backtracking;

import java.util.*;

/**
 * 37. 解数独
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class Problem37 {
    public void solveSudoku(char[][] board) {
        boolean result = true;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == '.') {
                    List<Integer> possibleNums = getPossibleNums(x, y, board);
                    if (possibleNums.isEmpty()) {
                        throw new RuntimeException("no numbers available");
                    }
                    for (Integer num : possibleNums) {
                        board[x][y] = (char) (num + '0');
                        try {
                            solveSudoku(board);
                        } catch (RuntimeException ex) {
                            board[x][y] = '.';
                        }
                        if (board[x][y] != '.') {
                            break;
                        }
                    }
                    if (board[x][y] == '.') {
                        throw new RuntimeException("no numbers available at end");
                    }
                }
            }
        }
    }

    private List<Integer> getPossibleNums(int x, int y, char[][] board) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][y] != '.') {
                nums[board[i][y] - '1'] = 1;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != '.') {
                nums[board[x][i] - '1'] = 1;
            }
        }
        int xStart = ((int) (x / 3)) * 3;
        int yStart = ((int) (y / 3)) * 3;
        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                if (board[i][j] != '.') {
                    nums[board[i][j] - '1'] = 1;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        Problem37 app = new Problem37();
        app.solveSudoku(chars);


        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
