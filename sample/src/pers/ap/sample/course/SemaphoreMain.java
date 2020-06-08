package pers.ap.sample.course;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreMain {
   public static void main(String[] args){
       Semaphore semaphore=new Semaphore(0);

       Thread thread1=new Thread(new FirstRunThread(semaphore));
       Thread thread2=new Thread(new SecondRunThread(semaphore));
       thread2.start();
       try {
           Thread.sleep(2*1000);
       }catch (InterruptedException e){
           Logger.getLogger(SemaphoreMain.class.getName()).log(Level.SEVERE,null,e);
       }
       thread1.start();


   }

}
