public class SynchThreads {
    public static void main(String[] args){
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизованный");
        Caller ob3 = new Caller(target, "мир!");

        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("Поток Caller прерван.");
        }
        System.out.println("Главный поток завершён.");
    }
}

class Callme{
    synchronized void call(String message){
        System.out.println("[" + message);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Поток callme прерван.");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String message;
    Callme target;
    Thread t;

    Caller(Callme trg, String msg){
        target = trg;
        message = msg;
        t = new Thread(this);
        t.start();
    }

    public void run(){
        target.call(message);
    }
}

