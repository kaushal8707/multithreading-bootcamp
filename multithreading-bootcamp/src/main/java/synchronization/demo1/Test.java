package synchronization.demo1;

public class Test {
    public static void main(String[] args) {

        /** scenario 1 when only 1 instance is shared among both thread */
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

        System.out.println(counter.getCount());
        System.out.println("-------------------------");

        /** scenario 2 when we have 2 different instance and both thread access independently */
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        MyThreadD t3 = new MyThreadD(counter1);
        MyThreadD t4 = new MyThreadD(counter2);
        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());


        /** Note -  when we have not used synchronized then unpredictable result was coming
         *  because outcome was depends on thread relative timings bcz threads was running concurrently
         *  then result would be unpredictable this condition while no synchronize called "RACE_CONDITION"
         *  we can solve race condition problem by using synchronize \
         *  At a same time only one thread can access critical section that is called "MUTUAL_EXCLUSION"
         *  MUTUAL_EXCLUSION assures that multiple thread should not access critical section simultaniously
         *  mutual - RELATIONSHIP BETWEEN MULTIPLE THREADS WHICH WANT TO ACCESS SAME SHARED RESOURCES
         *  EXCLUSION - STOPPING OR PREVENT
         *
         */

    }
}
