package pers.ap.sample.homework;

import java.util.concurrent.CountDownLatch;

public class Latch_SingleWordRunThread_Imp_Thread extends  Thread{
    private  CountDownLatch doneSignal;
    private final String name;
    private Storage storage;

    public Latch_SingleWordRunThread_Imp_Thread(CountDownLatch doneSignal,
                                                String name, Storage storage) {
        this.doneSignal = doneSignal;
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        //            startSignal.await();
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.push(name);
        doneSignal.countDown();

    }
}
