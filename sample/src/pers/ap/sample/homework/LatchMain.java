package pers.ap.sample.homework;

import java.util.concurrent.CountDownLatch;

public class LatchMain {

    public static void main(String[] args){

        la();

    }
    static void la(){
        int cnt=3;
//        CountDownLatch startSignal=new CountDownLatch(1);
        CountDownLatch doneSignal=new CountDownLatch(cnt);
        Storage storage=new Storage();

        Thread thread2=new Thread(new Latch_SingleWordRunThread(doneSignal,"nihao",storage));
        Thread thread3=new Thread(new Latch_SingleWordRunThread(doneSignal,"buhao",storage));
        Thread thread4=new Thread(new Latch_SingleWordRunThread(doneSignal,"keyi",storage));

        thread2.start();
        thread3.start();
        thread4.start();
//        startSignal.countDown();
        System.out.println("begin");
        try {
            doneSignal.await();
            System.out.println("finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
//    }
}