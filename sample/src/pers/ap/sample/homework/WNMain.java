package pers.ap.sample.homework;



public class WNMain {
    public static void main(String[] args){
//      vm()
    }

     void vm(String[] input){
        Storage storage=new Storage();
        Object com=new Object();


        Thread thread2=new Thread(new WN_SingleWordRunThread(input[0],0,storage,com));
        Thread thread3=new Thread(new WN_SingleWordRunThread(input[1],1,storage,com));
        Thread thread4=new Thread(new WN_SingleWordRunThread(input[2],2,storage,com));
        Thread thread1=new Thread(new AwokeRunThread_WN(com));

        thread2.start();
        thread3.start();
        thread4.start();
        thread1.start();



    }
}
