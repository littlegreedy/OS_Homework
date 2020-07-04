package pers.ap.sample.homework;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sem_SingleWordRunThread implements Runnable {
    private Semaphore sem;
    private String word;
    private final int index;
    private Storage storage;

    public Sem_SingleWordRunThread(Semaphore sem, String word, int index, Storage storage) {
        this.sem = sem;
        this.word = word;
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

        try {
            sem.acquire();
            storage.push(word,index);
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