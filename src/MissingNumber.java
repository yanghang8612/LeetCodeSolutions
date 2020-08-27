public class MissingNumber {

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ nums.length;
    }

    public static void main(String[] args) {
        
    }
}
