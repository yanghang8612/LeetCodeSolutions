import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ErBi {
    private void say() {

    }
}

public class Test {

    {
        int a = 1;
    }

    abstract class GrandFather {
        abstract void think();
    }

    class A {}

    class B {}

    class Father {
        public void sayHello(A a) {
            System.out.println("Father choose A");
        }

        public void sayHello(B b) {
            System.out.println("Father choose B");
        }
    }

    interface ShaBi {
        int a = 1;
    }

    class Son extends Father {
        public void sayHello(A a) {
            System.out.println("Son choose A");
        }

        public void sayHello(B b) {
            System.out.println("Son choose B");
        }
    }

    private void test() {
        Father father = new Father();
        Son son = new Son();
        father.sayHello(new A());
        son.sayHello(new B());
    }

    private void fun() {

    }

    private int fun(int i) {
        return 0;
    }

    public static void main(String[] args) throws Throwable {
//        getPrintLnMH(new ErBi()).invokeExact();
        Object o = new Object();
        synchronized (o) {
            o.wait();
        }
    }

//    private static MethodHandle getPrintLnMH(Object receiver) throws Throwable {
//        MethodType mt = MethodType.methodType(void.class);
//        return MethodHandles.lookup().findSpecial(receiver.getClass(), "say", mt, receiver.getClass()).bindTo(receiver);
//    }
}
