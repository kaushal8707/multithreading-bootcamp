package threadpool.README.executor_frameworks.demo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFrameworkExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> submit = executorService.submit(() -> 1 + 2);
        Integer i = submit.get(); // get method will block main thread
        System.out.println("sum is : "+i);
        executorService.shutdown();
        Thread.sleep(100);
        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());
    }
}
