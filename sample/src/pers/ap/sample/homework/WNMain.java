package pers.ap.sample.homework;



public class WNMain {
    public static void main(String[] args){
       Storage storage=new Storage();
       Object com=new Object();
       Thread thread2=new Thread(new WN_SingleWordRunThread("nihao",storage,com));
       Thread thread3=new Thread(new WN_SingleWordRunThread("buhao",storage,com));
       Thread thread4=new Thread(new WN_SingleWordRunThread("keyi",storage,com));
       Thread thread1=new Thread(new AwokeRunThread_WN(com));

       thread2.start();
       thread3.start();
       thread4.start();
       thread1.start();
    }

     void vm(){
        Storage storage=new Storage();
        Object com=new Object();


        Thread thread2=new Thread(new WN_SingleWordRunThread("nihao",storage,com));
        Thread thread3=new Thread(new WN_SingleWordRunThread("buhao",storage,com));
        Thread thread4=new Thread(new WN_SingleWordRunThread("keyi",storage,com));
        Thread thread1=new Thread(new AwokeRunThread_WN(com));

        thread2.start();
        thread3.start();
        thread4.start();
        thread1.start();



    }
}
