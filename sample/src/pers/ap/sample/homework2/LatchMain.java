package pers.ap.sample.homework2;

import java.util.concurrent.CountDownLatch;

public class LatchMain {

    public static void main(String[] args){
        int cnt=1;
        CountDownLatch startSignal=new CountDownLatch(1);
        CountDownLatch doneSignal=new CountDownLatch(cnt);
        Storage storage=new Storage();

        Thread thread2=new Thread(new SingleWordRunThread_Latch(startSignal,doneSignal,"nihao",storage));
        Thread thread3=new Thread(new SingleWordRunThread_Latch(startSignal,doneSignal,"buhao",storage));
        Thread thread4=new Thread(new SingleWordRunThread_Latch(startSignal,doneSignal,"keyi",storage));

        thread2.start();
        thread3.start();
        thread4.start();
        startSignal.countDown();
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    void la(){
        int cnt=3;
        CountDownLatch startSignal=new CountDownLatch(1);
        CountDownLatch doneSignal=new CountDownLatch(cnt);
        Storage storage=new Storage();

        Thread thread2=new Thread(new SingleWordRunThread_Latch(startSignal,doneSignal,"nihao",storage));
        Thread thread3=new Thread(new SingleWordRunThread_Latch(startSignal,doneSignal,"buhao",storage));
        Thread thread4=new Thread(new SingleWordRunThread_Latch(startSignal,doneSignal,"keyi",storage));

        thread2.start();
        thread3.start();
        thread4.start();
        startSignal.countDown();
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
//    }
}
