package yobdc;

public class Problem6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int numCols = s.length()/2+1;
        char[][] mat = new char[numRows][numCols];

        int rowIndex = 0;
        int colIndex = 0;
        int rowStep = 1;
        int colStep = 0;

        for (int i = 0; i < s.length(); i++) {
            mat[rowIndex][colIndex] = s.charAt(i);
            if (rowIndex + rowStep >= 0 && rowIndex + rowStep < numRows) {
                rowIndex += rowStep;
            }
            if (colIndex + colStep >= 0 && colIndex + colStep < numCols) {
                colIndex += colStep;
            }
            if (rowIndex == 0) {
                rowStep = 1;
                colStep = 0;
            }
            if (rowIndex == numRows - 1) {
                rowStep = -1;
                colStep = 1;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (mat[i][j] != 0) {
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
