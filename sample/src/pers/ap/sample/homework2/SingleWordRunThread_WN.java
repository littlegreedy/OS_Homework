package pers.ap.sample.homework2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleWordRunThread_WN implements Runnable {
    private String word;
    private Storage storage;
    private Object com;

    public SingleWordRunThread_WN(String word, Storage storage, Object com) {
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
        try {
            Thread.sleep(2*1000);
        }catch (InterruptedException e){
            Logger.getLogger(SemaphoreMain.class.getName()).log(Level.SEVERE,null,e);
        }

        synchronized (com){
            com.notify();
        }

    }
}