package standard;

public class N902_NumbersAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] D, int N) {
        String s = Integer.toString(N);
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += Math.pow(D.length, i);
        }
        for (int i = 0; i < s.length(); i++) {
            boolean hasSame = false;
            for (int j = 0; j < D.length; j++) {
                if (D[j].charAt(0) < s.charAt(i)) res += Math.pow(D.length, s.length() - i - i);
                else if (D[j].charAt(0) == s.charAt(i)) {
                    hasSame = true;
                }
            }
            if (!hasSame) return res;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
