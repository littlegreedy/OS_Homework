package pers.ap.sample.homework;

import java.util.Calendar;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    public static void main(String[] args){
        ba();
    }

    public static void ba(){
        Storage storage=new Storage();
        PrintResult finalPrint=new PrintResult();
        CyclicBarrier barrier=new CyclicBarrier(3,finalPrint);
//        CalculateFinalResult

        PrintString printString=new PrintString(barrier,"nihao", storage);
        PrintString printString2=new PrintString(barrier,"buhao", storage);
        PrintString printString3=new PrintString(barrier,"keyi", storage);

        new Thread(printString).start();
        new Thread(printString2).start();
        new Thread(printString3).start();
    }

}
class PrintResult implements Runnable{
    @Override
    public void run() {
        System.out.println("ALL OK");
    }
}

class PrintString implements Runnable {
    final CyclicBarrier barrier;
    final String str;
    Storage storage;

    PrintString(CyclicBarrier barrier, String str,Storage storage) {
        this.barrier = barrier;
        this.str = str;
        this.storage=storage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
        storage.push(str);
        try {
            barrier.await();

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
