package pers.ap.sample.homework;

import java.util.concurrent.Phaser;

public class PhaserProcess {
    public static void main(String[] args){

    }
    public static void ph(String[] input){
        int cnt=3;
        Storage storage=new Storage();
        Phaser phaser=new Phaser(cnt);

        new Thread(new PrintWord(phaser,input[0],0,storage)).start();
        new Thread(new PrintWord(phaser,input[1],1,storage)).start();
        new Thread(new PrintWord(phaser,input[2],2,storage)).start();
    }

}

class PrintWord implements Runnable{
    private final Phaser phaser;
    private String str;
    private final int index;
    private  Storage storage;

    public PrintWord(Phaser phaser, String str, int index, Storage storage) {
        this.phaser = phaser;
        this.str = str;
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
            storage.push(str,index);
            phaser.arriveAndAwaitAdvance();

    }
}
