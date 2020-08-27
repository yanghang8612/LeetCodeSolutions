package standard;

public class Sum {

    private int solve(int n) {
        n += 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1] * 2;
    }

    public static void main(String[] args) {
        var a = 1;
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            System.out.println(scanner.nextLine().trim());
//        }
        System.out.println(new Sum().solve(12));
    }
}
