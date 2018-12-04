import java.util.Stack;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] h = new int[matrix[0].length + 1];
        int maxArea = 0;
        for (char[] row : matrix) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i <= row.length; i++) {
                if (i < row.length) h[i] = row[i] == '1' ? h[i] + 1 : 0;
                while (!s.isEmpty() && h[i] < h[s.peek()]) {
                    int l = Integer.min(h[s.pop()], s.isEmpty() ? i : i - 1 - s.peek());
                    maxArea = Integer.max(maxArea, l * l);
                }
                s.push(i);
            }
        }
        return maxArea;
    }
}
