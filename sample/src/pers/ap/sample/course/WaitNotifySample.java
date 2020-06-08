package pers.ap.sample.course;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WaitNotifySample  {

    public static void main(String[] args){
//        Semaphore semaphore=new Semaphore(0);
        Object com=new Object();
        WaitThread thread1=new WaitThread("sleep",com);
        NotifyThread thread2=new NotifyThread("wakeup",com);
        thread1.start();
        try {
            Thread.sleep(2*1000);
        }catch (InterruptedException e){
            Logger.getLogger(SemaphoreMain.class.getName()).log(Level.SEVERE,null,e);
        }

        thread2.start();
    }
}
