package standard;

import java.util.concurrent.Semaphore;

public class N1115_PrintFooBarAlternately {

class FooBar {
    private final int n;
    private final Semaphore semaphore0;
    private final Semaphore semaphore1;

    public FooBar(int n) {
        this.n = n;
        this.semaphore0 = new Semaphore(1);
        this.semaphore1 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore0.acquire(1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore1.release(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire(1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore0.release(1);
        }
    }
}
}
