/**
 * 刚开始没有理解题意，元素为0，直接把其所在的行和列注释为0就可以了
 * 但是这样存在一个问题，原始的矩阵不能遍历的时候被更改，否则的话有一个0元素则整个矩阵都变成了0
 * 看了tips之后，这题的关键在于是否可以压缩空间到一个常数，也就是说不额外开辟空间
 * 很显然的想法开辟一个矩阵的copy，然后在这个copy上操作，空间为o(mn)
 * 这样不好，又想到针对每一行每一列，只要其行中或列中有0，则这行或列的状态就可以确定了
 * 那针对每一行每一列开辟存储状态，空间为o(m + n)
 * 那能不能压缩到常数的空间开销，我最初想法是针对每一个为0的元素，标记它所在的行列中其他非0元素为一个特殊值，
 * 完成遍历后，在遍历一遍将标记为特殊值的元素置为0，但是这个特殊值不好找，Integer.MAX_VALUE和Integer.MIN_VALUE居然都有测试用例，
 * 而且当整个矩阵为全0时，时间复杂度比较高o((m + n) * mn)
 * 所以这时候依然要考虑存储行列的状态，可以利用原矩阵中的0行和0列来存储对应行和列的状态，这样就无需额外的空间开销
 * 但是要注意，0行和0列本身的状态也需要存储，也就是0行0列这个元素只能表示0行或者0列的状态，所以需要额外一个变量来辅助
 */

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, col0 = 1;
        for (int x = 0; x < m; x++) {
            if (matrix[x][0] == 0) {
                col0 = 0;
            }
            for (int y = 1; y < n; y++) {
                if (matrix[x][y] == 0) {
                    matrix[x][0] = matrix[0][y] = 0;
                }
            }
        }
        for (int x = m - 1; x >= 0; x--) {
            for (int y = n - 1; y >= 1; y--) {
                if (matrix[x][0] == 0 || matrix[0][y] == 0) {
                    matrix[x][y] = 0;
                }
            }
            if (col0 == 0) {
                matrix[x][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 1}};
        new SetMatrixZeroes().setZeroes(matrix);
    }
}
