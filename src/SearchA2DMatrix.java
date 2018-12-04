/**
 * 这个题比较esay，其实就是个二分查找的问题
 * 注意几个问题，除2这种操作，用移位
 */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n  - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] > target) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 1));
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 50));
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 10));
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 20));
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 21));
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 0));
    }
}
