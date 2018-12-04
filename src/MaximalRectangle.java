import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] h = new int[matrix[0].length + 1];
        int maxArea = 0;
        for (char[] row : matrix) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i <= row.length; i++) {
                if (i < row.length) h[i] = row[i] == '1' ? h[i] + 1 : 0;
                while (!s.isEmpty() && h[i] < h[s.peek()])
                    maxArea = Integer.max(maxArea, h[s.pop()] * (s.isEmpty() ? i : i - 1 - s.peek()));
                s.push(i);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'1', '1', '1', '1', '1'}}));
    }
}
