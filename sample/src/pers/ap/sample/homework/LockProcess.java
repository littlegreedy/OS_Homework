package pers.ap.sample.homework;

import java.util.concurrent.locks.ReentrantLock;

public class LockProcess {
    private Storage storage;
//    private final int index;
    private static final ReentrantLock queueLock=new ReentrantLock();  //可重入锁

    public LockProcess(Storage storage) {
        this.storage = storage;
    }


    public static void main(String[] args){
//        printStringWord();
//        LockProcess.printStringWord( new Storage());
    }
    public void tryTOPrint(int index){
        boolean flag=true;
        while(flag){
            if(queueLock.tryLock()){
//                queueLock.lock();
//                System.out.println(Thread.currentThread().getName());
                String str=Thread.currentThread().getName();
                storage.push(str,index);
                flag=false;
                queueLock.unlock();
            }else {
                System.out.println("wait for minutes");
            }
            if(flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void printStringWord(String[] input){
        Storage storage=new Storage();
        LockProcess lockProcess=new LockProcess(storage);
        int cnt=3;

        Thread[] singleWord=new Thread[cnt];

        //初始化线程
        for(int i=0;i<cnt;i++){
            int finalI = i;
            singleWord[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    try{

                        int waitOfTime=(int)(Math.random()*(5-1)+1);
                        Thread.sleep(waitOfTime*1000);

                        lockProcess.tryTOPrint(finalI);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
            singleWord[i].start();
        }
        singleWord[0].setName(input[0]);
        singleWord[1].setName(input[1]);
        singleWord[2].setName(input[2]);
    }

}
