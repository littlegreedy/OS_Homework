package pers.ap.sample.homework2;

public class AwokeRunThread_WN implements Runnable{

    private Object com;

    public AwokeRunThread_WN(Object com) {

        this.com = com;
    }

    @Override
    public void run() {

        synchronized (com){
            com.notify();
        }

    }
}
