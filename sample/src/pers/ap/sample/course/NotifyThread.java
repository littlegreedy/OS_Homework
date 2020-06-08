package pers.ap.sample.course;

public class NotifyThread extends Thread{
    private Object obj;
    public NotifyThread(String name, Object obj){
        super(name);
        this.obj = obj;
    }
    @Override
    public void run() {
        System.out.println(this.getName()+" start up run ");
        System.out.println(this.getName()+" start up notify ");

        synchronized (obj) {
            obj.notifyAll();
        }
//        System.out.println(this.getName()+" start up awoke ");
    }
}
