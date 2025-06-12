package threadpool.README.executor_frameworks.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFrameworkExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> System.out.println("Hello"));
        future.get();
        executorService.shutdown();

        Future<?> submit = executorService.submit(() -> System.out.println("Hello"), "success");


    }
}
