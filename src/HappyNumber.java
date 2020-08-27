import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(18));
    }
}
