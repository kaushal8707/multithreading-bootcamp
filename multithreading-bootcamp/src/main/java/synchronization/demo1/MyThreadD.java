package synchronization.demo1;

public class MyThreadD extends Thread{

    private Counter counter;

    public MyThreadD(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++){
            counter.increment();
        }
    }
}
