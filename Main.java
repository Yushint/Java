

public class Main {
    public static void main(String[] args){
        new SecondThread();
        new ThirdThread();

        try{
            for (int n = 10; n > 0; n--){
                System.out.println("Главный поток: " + n);
                Thread.sleep(1000);
            }
            System.out.println("Главный поток завершён.");
        }catch (InterruptedException exception){
            System.out.println("Главный поток завершён.");
        }
    }
}

class SecondThread implements Runnable{
    Thread t;

    SecondThread(){
        t = new Thread(this, "Second Thread");
        System.out.println("Создан второй поток исполнения.");
        t.start();
    }

    public void run(){
        try{
            for (int i = 10; i > 0; i--){
                System.out.println("Второй поток: " + i);
                Thread.sleep(500);
            }
            System.out.println("Второй поток завершён.");
        }catch (InterruptedException exception){
            System.out.println("Второй поток прерван.");
        }
    }
}

class ThirdThread implements Runnable{
    Thread t;
    ThirdThread(){
        t = new Thread(this, "Another Thread");
        System.out.println("Создан третий поток.");
        t.start();
    }

    public void run(){
        try{
            for (int i = 10; i > 0; i--){
                System.out.println("Третий поток: " + i);
                Thread.sleep(200);
            }
            System.out.println("Третий поток завершён.");
        }catch (InterruptedException thread_exception){
            System.out.println("Третий поток прерван.");
        }
    }
}
