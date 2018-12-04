public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int divisor = 2, count = num == 1 ? 0 : 1;
        while (divisor * divisor <= num) {
            if (num % divisor == 0) {
                count += divisor;
                count += num / divisor;
            }
            divisor += 1;
        }
        return count == num;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectNumber().checkPerfectNumber(28));
        System.out.println(new PerfectNumber().checkPerfectNumber(0));
    }
}
