public class Sqrt {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int result = (int) Math.ceil(x / 2);
        return (int) Math.sqrt(x);
    }

    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(1));
        System.out.println((int) Math.sqrt(2));
        System.out.println((int) Math.sqrt(3));
        System.out.println((int) Math.sqrt(4));
        System.out.println((int) Math.sqrt(5));
        System.out.println((int) Math.sqrt(Integer.MAX_VALUE));
        System.out.println((int) Math.sqrt(-1));
        System.out.println((int) Math.sqrt(-2));
        System.out.println((int) Math.sqrt(Integer.MIN_VALUE));
    }
}
