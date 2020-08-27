package standard;

import java.util.concurrent.atomic.AtomicInteger;

public class N1114_PrintInOrder {

    class Foo {

        private final AtomicInteger mState = new AtomicInteger(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            mState.getAndAdd(1);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (mState.get() != 1) {
                Thread.yield();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            mState.getAndAdd(1);
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (mState.get() != 2) {
                Thread.yield();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
