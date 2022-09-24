public class MoreThreads {
    public static void main(String[] args){
        new AnotherThread("Первый поток");
        new AnotherThread("Второй поток");
        new AnotherThread("Третий поток");

        Thread current_thread = Thread.currentThread();
        System.out.println("Создан главный поток: " + current_thread);
        try{
            Thread.sleep(8000);
            System.out.println("Главный поток завершён.");
        }catch (InterruptedException thread_exception){
            System.out.println("Главный исполняемый поток прерван.");
        }
    }
}

class AnotherThread implements Runnable{
    Thread t;
    String thread_name;
    AnotherThread(String name){
        thread_name = name;
        t = new Thread(this, thread_name);
        System.out.println("Создан новый поток: " + t);
        t.start();
    }

    public void run(){
        try{
            for (int i = 5; i > 0; i--){
                System.out.println(thread_name + " " + i);
                Thread.sleep(1000);
            }
            System.out.println(thread_name + " завершён.");
        }catch (InterruptedException thread_exception){
            System.out.println(thread_name + " прерван.");
        }
    }
}
