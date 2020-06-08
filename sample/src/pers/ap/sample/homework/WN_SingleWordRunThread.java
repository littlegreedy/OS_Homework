package pers.ap.sample.homework;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WN_SingleWordRunThread implements Runnable {
    private String word;
    private Storage storage;
    private Object com;

    public WN_SingleWordRunThread(String word, Storage storage, Object com) {
        this.word = word;
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
        storage.push(word);
//        try {
//            Thread.sleep(1*1000);
//        }catch (InterruptedException e){
//            Logger.getLogger(SemaphoreMain.class.getName()).log(Level.SEVERE,null,e);
//        }

        synchronized (com){
            com.notify();
        }

    }
}