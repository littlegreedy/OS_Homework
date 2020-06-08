package pers.ap.sample.homework2;

import java.util.concurrent.CountDownLatch;

public class SingleWordRunThread_Latch implements  Runnable{
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final String name;
    private Storage storage;

    public SingleWordRunThread_Latch(CountDownLatch startSignal, CountDownLatch doneSignal,
                                     String name, Storage storage) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            startSignal.await();

            storage.push(name);

            doneSignal.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
