package pers.ap.sample.course;

import java.util.concurrent.Semaphore;

public class SecondRunThread implements Runnable {
    private Semaphore sem;

    public SecondRunThread(Semaphore sem){
        this.sem=sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 2 start up !");
    }
}
