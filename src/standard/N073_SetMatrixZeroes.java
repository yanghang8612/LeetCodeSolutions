package standard;

public class N073_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return;
        int n = matrix.length, m = matrix[0].length;
        boolean isRowContainZero = false, isColumnContainZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                isRowContainZero = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isColumnContainZero = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isRowContainZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isColumnContainZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
