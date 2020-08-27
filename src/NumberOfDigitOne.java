public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        if (n < 0) return 0;
        String nStr = String.valueOf(n);
        int len = nStr.length();
        if (len == 1) return n == 0 ? 0 : 1;
        int high = nStr.charAt(0) - '0';
        int low = Integer.parseInt(nStr.substring(1));
        if (high == 1) return low + 1 + countDigitOne(low) + helper(len - 1);
        else return (int) Math.pow(10, len - 1) + high * helper(len - 1) + countDigitOne(low);
    }

    private int helper(int len) {
        if (len == 1) return 1;
        return (int) Math.pow(10, len - 1) + 10 * helper(len - 1);
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfDigitOne().countDigitOne(2134983278));
    }
}
