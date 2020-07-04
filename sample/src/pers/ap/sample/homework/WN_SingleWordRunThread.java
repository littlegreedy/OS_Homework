package pers.ap.sample.homework;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WN_SingleWordRunThread implements Runnable {
    private String word;
    private final int index;
    private Storage storage;
    private Object com;


    public WN_SingleWordRunThread(String word, int index, Storage storage, Object com) {
        this.word = word;
        this.index = index;
        this.storage = storage;
        this.com = com;
    }

    @Override
    public void run() {
        try {
            synchronized (com){
                com.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(word);
        try {
            int waitOfTime=(int)(Math.random()*(5-1)+1);
            Thread.sleep(waitOfTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.push(word,index);

        synchronized (com){
            com.notify();
        }

    }
}