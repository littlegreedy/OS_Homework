package pers.ap.sample.homework;

import java.util.Calendar;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
//    public static void main(String[] args){
//        ba();
//    }

    public static void ba(String[] input){
        Storage storage=new Storage();
        PrintResult finalPrint=new PrintResult();
        CyclicBarrier barrier=new CyclicBarrier(3,finalPrint);
//        CalculateFinalResult

        PrintString printString=new PrintString(barrier,input[0], 0,storage);
        PrintString printString2=new PrintString(barrier,input[1], 1,storage);
        PrintString printString3=new PrintString(barrier,input[2], 2,storage);

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
    private final int index;
    Storage storage;

    public PrintString(CyclicBarrier barrier, String str, int index, Storage storage) {
        this.barrier = barrier;
        this.str = str;
        this.index = index;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {

            int waitOfTime=(int)(Math.random()*(5-1)+1);
            Thread.sleep(waitOfTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.push(str,index);
        try {
            barrier.await();

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
