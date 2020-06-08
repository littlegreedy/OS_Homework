package pers.ap.sample.homework;

import java.util.concurrent.Phaser;

public class PhaserProcess {
    public static void main(String[] args){

    }
    public static void ph(){
        int cnt=3;
        Storage storage=new Storage();
        Phaser phaser=new Phaser(cnt);

        new Thread(new PrintWord(phaser,"nihao",storage)).start();
        new Thread(new PrintWord(phaser,"buhao",storage)).start();
        new Thread(new PrintWord(phaser,"keyi",storage)).start();
    }

}

class PrintWord implements Runnable{
    private final Phaser phaser;
    private  Storage storage;
    private String str;

    public PrintWord(Phaser phaser, String str,Storage storage) {
        this.phaser = phaser;
        this.str=str;
        this.storage = storage;
    }

    @Override
    public void run() {

            storage.push(str);
            phaser.arriveAndAwaitAdvance();

    }
}
