package synchronization.base;

public class Test {
    public static void main(String[] args) {

        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);        //both threads shared a common resources
        MyThread t2 = new MyThread(counter);        //both threads shared a common resources
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());      // it should come 2000, but coming 1743 or 1861
                                                     // because both threads running simultaneously just assume now count = 101 then
                                                     // both thread read 101 and increment to 102  which mean at same time both thread run counter.increment()
                                                     // it is happening because we are sharing one resource with multiple thread
                                                     // if we want to make sure at a same time only one thread should access it if one thread access another should wait
                                                     // so let's add synchronized keyword in method
    }
}
