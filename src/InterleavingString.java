import java.util.Stack;

public class InterleavingString {
    class Scene {
        boolean isS1;
        int a, b;

        public Scene(boolean isS1, int a, int b) {
            this.isS1 = isS1;
            this.a = a;
            this.b = b;
        }
    }

    public boolean isInterleave_self(String s1, String s2, String s3) {
        if (s3 == null || s1 == s2) return false;
        if (s1 == null) return s2.equals(s3);
        if (s2 == null) return s1.equals(s3);
        Stack<Scene> s = new Stack<>();
        int a = 0, b = 0, l1 = s1.length(), l2 = s2.length();
        if (l1 + l2 != s3.length()) return false;
        for (int i = 0; i < s3.length(); i++) {
            if (a < l1 && s1.charAt(a) == s3.charAt(i)) {
                if (b < l2 && s1.charAt(a) == s2.charAt(b)) {
                    s.push(new Scene(true, a, b));
                }
                a++;
            } else if (b < l2 && s2.charAt(b) == s3.charAt(i)) {
                if (a < l1 && s1.charAt(a) == s2.charAt(b)) {
                    s.push(new Scene(false, a, b));
                }
                b++;
            } else {
                for (int j = 0; j < s.size(); j++) {
                    System.out.print("-");
                }
                System.out.println();
                if (s.isEmpty()) return false;
                else {
                    Scene scene = s.pop();
                    a = scene.a;b = scene.b;
                    if (scene.isS1) b++;
                    else a++;
                    i = a + b - 1;
                }
            }
        }
        return a == l1 && b == l2;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < l2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aa", "ab", "aaba"));
        System.out.println(new InterleavingString().isInterleave(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
;