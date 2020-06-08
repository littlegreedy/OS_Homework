package pers.ap.sample.course;

public class WaitThread extends Thread {
    private Object obj;

    public WaitThread(String name, Object obj){
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println(this.getName()+" start up run ");
        System.out.println(this.getName()+" start up sleep ");

        try {
            synchronized (obj){
                obj.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName()+" start up awoke ");
    }
}
