package standard;

public class N069_SqrtX {

    public int mySqrt(int x) {
        int l = 0, r = x;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (mid < x / mid) l = mid;
            else r = mid;
        }
        return r * r <= x && r * r >= 0 ? r : l;
    }

    strictfp public static void main(String[] args) {
        System.out.println(1.0f - 0.9f);
        System.out.println(0.9f - 0.8f);
    }
}
