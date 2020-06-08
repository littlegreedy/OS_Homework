package pers.ap.sample.homework;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Latch_SingleWordRunThread implements  Runnable{
    private  CountDownLatch doneSignal;
    private final String name;
    private Storage storage;

    public Latch_SingleWordRunThread(CountDownLatch doneSignal,
                                     String name, Storage storage) {
        this.doneSignal = doneSignal;
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        System.out.println("arrive");
        //            startSignal.await();
        try {

            int waitOfTime=(int)(Math.random()*(3-1)+1);
            Thread.sleep(waitOfTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.push(name);
        doneSignal.countDown();

        System.out.println("down");

    }
}
