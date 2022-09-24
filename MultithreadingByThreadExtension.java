public class MultithreadingByThreadExtension {
    public static void main(String[] args){
        new NewThread();

        Thread t = Thread.currentThread();
        System.out.println("Главный поток: " + t);
        try{
            for (int i = 10; i > 0; i--){
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
            System.out.println("Главный поток завершён.");
        }catch (InterruptedException ThreadInterruptionExceptionObject){
            System.out.println("Главный поток исполнения прерван.");
        }
    }
}

class NewThread extends Thread{
    NewThread(){
        super("NewThread Thread");
        System.out.println("Создан дочерный поток: " + this);
        start();
    }

    @Override
    public void run(){
        try{
            for (int i = 10; i > 0; i--){
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
            System.out.println("Дочерний поток завершён.");
        }catch (InterruptedException ThreadInterruptionExceptionObject){
            System.out.println("Дочерний поток исполнения прерван.");
        }
    }
}
