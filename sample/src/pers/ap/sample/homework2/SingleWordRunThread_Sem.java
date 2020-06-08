package pers.ap.sample.homework2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleWordRunThread_Sem implements Runnable {
    private Semaphore sem;
    private String word;
    private Storage storage;

    public SingleWordRunThread_Sem(Semaphore sem, String word, Storage storage){
        this.sem=sem;
        this.word=word;
        this.storage=storage;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
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

        sem.release();
    }
}