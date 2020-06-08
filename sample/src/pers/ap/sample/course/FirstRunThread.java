package pers.ap.sample.course;

import java.util.concurrent.Semaphore;

public class FirstRunThread  implements Runnable{
    private Semaphore sem;

    public FirstRunThread(Semaphore sem){
        this.sem=sem;
    }

    @Override
    public void run() {
        System.out.println("Thread 1 start up !");
        sem.release();
    }
}
