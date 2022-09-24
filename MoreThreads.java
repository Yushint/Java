public class MoreThreads {
    public static void main(String[] args){
        AnotherThread first_thread = new AnotherThread("Первый поток");
        AnotherThread second_thread = new AnotherThread("Второй поток");
        AnotherThread third_thread = new AnotherThread("Третий поток");
        Thread current_thread = Thread.currentThread();
        System.out.println("Создан главный поток: " + current_thread);

        System.out.println("Первый поток запущен: " + first_thread.t.isAlive());
        System.out.println("Второй поток запущен: " + second_thread.t.isAlive());
        System.out.println("Третий поток запущен: " + third_thread.t.isAlive());

        try{
            first_thread.t.join();
            second_thread.t.join();
            third_thread.t.join();
        }catch (InterruptedException thread_exception){
            System.out.println("Главный исполняемый поток прерван.");
        }
        System.out.println("Первый поток запущен: " + first_thread.t.isAlive());
        System.out.println("Второй поток запущен: " + second_thread.t.isAlive());
        System.out.println("Третий поток запущен: " + third_thread.t.isAlive());
        System.out.println("Главный поток запущен: " + current_thread.isAlive());
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
