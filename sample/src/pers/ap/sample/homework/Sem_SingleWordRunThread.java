package pers.ap.sample.homework;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sem_SingleWordRunThread implements Runnable {
    private Semaphore sem;
    private String word;
    private Storage storage;

    public Sem_SingleWordRunThread(Semaphore sem, String word, Storage storage){
        this.sem=sem;
        this.word=word;
        this.storage=storage;
    }

    @Override
    public void run() {

        try {
            sem.acquire();
            storage.push(word);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(word);

//        try {
//            Thread.sleep(2*1000);
//        }catch (InterruptedException e){
//            Logger.getLogger(SemaphoreMain.class.getName()).log(Level.SEVERE,null,e);
//        }

        sem.release();
    }
}