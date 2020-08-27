public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l = Math.max(A, E), r = Math.min(C, G);
        int b = Math.max(B, F), t = Math.min(D, H);
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        if (l >= r || b >= t) return total;
        return total - (r - l) * (t - b);
    }

    public static void main(String[] args) {

    }
}
