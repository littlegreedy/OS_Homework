package pers.ap.sample.homework;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {
   public static void main(String[] args){
//

   }
    void se(String[] input) {
        Semaphore semaphore = new Semaphore(1);
        Storage storage = new Storage();

//       Thread thread1=new Thread(new TotalWordRunThread(semaphore));
        Thread thread2 = new Thread(new Sem_SingleWordRunThread(semaphore, input[0], 0,storage));
        Thread thread3 = new Thread(new Sem_SingleWordRunThread(semaphore, input[1], 1,storage));
        Thread thread4 = new Thread(new Sem_SingleWordRunThread(semaphore, input[2],2, storage));
//       thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
//   }

}
