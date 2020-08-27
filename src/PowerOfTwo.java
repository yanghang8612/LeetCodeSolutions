public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(0));
    }
}
