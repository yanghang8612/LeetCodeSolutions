package standard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class N349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(set::contains).toArray();
    }

    public static void main(String[] args) throws InterruptedException {
//        Object object = new Object();
//        synchronized (object) {
//            object.wait();
//        }
    }
}
