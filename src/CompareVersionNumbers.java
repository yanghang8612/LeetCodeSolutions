public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] res1 = version1.replaceAll("(\\.0+)+$", "").split("\\.");
        String[] res2 = version2.replaceAll("(\\.0+)+$", "").split("\\.");
        int minLen = Math.min(res1.length, res2.length);
        for (int i = 0; i < minLen; i++) {
            int ret = Integer.compare(Integer.valueOf(res1[i]), Integer.valueOf(res2[i]));
            if (ret != 0) return ret;
        }
        return Integer.compare(res1.length, res2.length);
    }

    public static void main(String[] args) {
        System.out.println("1.0.00".replaceAll("(\\.0+)+$", ""));
    }
}
