public class SynchronizedProducerAndConsumer {
    public static void main(String[] args){
        Queue q = new Queue();
        new Producer(q);
        new Consumer(q);
        System.out.println("Для остановки нажмите 'Cntrl-C' ");
    }
}

class Queue{
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while (!valueSet){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("Исключение типа 'InterruptedException' перехвачено.");
            }
        }
        System.out.println("Получено: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while (valueSet){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Исключение типа 'InterruptedException' перехвачено.");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено: " + n);
        notify();
    }
}

class Producer implements Runnable{
    Queue q;
    Producer(Queue q){
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Queue q;
    Consumer(Queue q){
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
