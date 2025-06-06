package locks.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/** here Indefinitely wait is not happening */

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);
        try{
            if(lock.tryLock(1000, TimeUnit.MICROSECONDS)){
                if(balance>=amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdraw ");
                        Thread.sleep(3000);    // simulate time taken to process the withdrawn
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawl. remaining balance: " + balance);
                    }catch (Exception e){

                    } finally {
                        lock.unlock();     // always we release the resources in finally block.
                    }

                } else {
                    System.out.println("insufficient balance "+ balance);
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" couldn't acquired the lock will try again later !!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
