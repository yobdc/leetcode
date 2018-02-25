package yobdc;

public class Problem6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuffer[] mat = new StringBuffer[numRows];

        int rowIndex = 0;
        int rowStep = 1;

        for (int i = 0; i < s.length(); i++) {
            if (mat[rowIndex] == null) {
                mat[rowIndex] = new StringBuffer();
            }
            mat[rowIndex].append(s.charAt(i));
            if (rowIndex + rowStep >= 0 && rowIndex + rowStep < numRows) {
                rowIndex += rowStep;
            }
            if (rowIndex == 0) {
                rowStep = 1;
            }
            if (rowIndex == numRows - 1) {
                rowStep = -1;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            if (mat[i] != null && !mat[i].equals("")) {
                sb.append(mat[i]);
            }
        }
        return sb.toString();
    }

    public void test() {
        System.out.println(convert("ABC", 2));
    }
}
