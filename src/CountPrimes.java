public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                cnt += 1;
                for (int j = 2; i * j < n; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
