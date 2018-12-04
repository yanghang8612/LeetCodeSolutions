import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(4).toString());
    }
}
