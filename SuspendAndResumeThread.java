public class SuspendAndResumeThread {
    public static void main(String[] args){
        NewSuspendedThread ob1 = new NewSuspendedThread("Один");
        NewSuspendedThread ob2 = new NewSuspendedThread("Два");

        try{
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостановка потока один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока один");
            ob2.mysuspend();
            System.out.println("Приостановка потока два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока два");
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }

        try {
            System.out.println("Ожидание выполнения потоков...");
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершён.");
    }
}

class NewSuspendedThread implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;

    NewSuspendedThread(String threadname){
        name = threadname;
        suspendFlag = false;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        try{
            for (int i = 15; i > 0; i--){
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершён");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}
