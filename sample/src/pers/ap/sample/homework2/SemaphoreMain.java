package pers.ap.sample.homework2;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {
   public static void main(String[] args){
       Semaphore semaphore = new Semaphore(1);
       Storage storage = new Storage();

//       Thread thread1=new Thread(new TotalWordRunThread(semaphore));
       Thread thread2 = new Thread(new SingleWordRunThread_Sem(semaphore, "nihao", storage));
       Thread thread3 = new Thread(new SingleWordRunThread_Sem(semaphore, "buhao", storage));
       Thread thread4 = new Thread(new SingleWordRunThread_Sem(semaphore, "keyi", storage));
//       thread1.start();
       thread2.start();
       thread3.start();
       thread4.start();

   }
    void se() {
        Semaphore semaphore = new Semaphore(1);
        Storage storage = new Storage();

//       Thread thread1=new Thread(new TotalWordRunThread(semaphore));
        Thread thread2 = new Thread(new SingleWordRunThread_Sem(semaphore, "nihao", storage));
        Thread thread3 = new Thread(new SingleWordRunThread_Sem(semaphore, "buhao", storage));
        Thread thread4 = new Thread(new SingleWordRunThread_Sem(semaphore, "keyi", storage));
//       thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
//   }

}
