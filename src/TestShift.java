public class TestShift {

    public static void doShift(int times) {
        long now = System.nanoTime();
        //System.out.println(now);
        int result;
        for (int i = 0; i < times; i++) {
            result = i >> 1;
            result += 1;
        }
        System.out.println(System.nanoTime() - now);
    }

    public static void doNormal(int times) {
        long now = System.nanoTime();
        //System.out.println(now);
        int result;
        for (int i = 0; i < times; i++) {
            result = i / 2;
            result += 1;
        }
        System.out.println(System.nanoTime() - now);
    }

    public static void main(String[] args) {
//        System.out.println("1次执行效果");
//        doShift(1);
//        doNormal(1);
//        System.out.println("10次执行效果");
//        doShift(10);
//        doNormal(10);
//        System.out.println("50次执行效果");
//        doShift(50);
//        doNormal(50);
//        System.out.println("100次执行效果");
//        doShift(100);
//        doNormal(100);
//        System.out.println("1000次执行效果");
//        doShift(1000);
//        doNormal(1000);
//        System.out.println("10000次执行效果");
//        doShift(10000);
//        doNormal(10000);
//        System.out.println("100000次执行效果");
//        doShift(100000);
//        doNormal(100000);
//        System.out.println("1000000次执行效果");
//        doShift(1000000);
//        doNormal(1000000);
//        System.out.println("10000000次执行效果");
//        doShift(10000000);
//        doNormal(10000000);
//        System.out.println("100000000次执行效果");
//        doShift(100000000);
//        doNormal(100000000);
        for (int i = 0; i < 10; i++) {
            System.out.println("1000000000次执行效果");
            doShift(1000000000);
            doNormal(1000000000);
        }
//        System.out.println("10000000000次执行效果");
//        doShift(10000000000L);
//        doNormal(10000000000L);
    }
}
