package threadpool.README.executor_frameworks.demo1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameworkDemo {
    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1;i<10;i++){
            int finalI = i;
            executor.submit(()->{
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("Total Time : " + (System.currentTimeMillis()-startTime));
    }

    private static long factorial(int n){
        try{
            Thread.sleep(1000);                      // we though factorial computation taking 1 sec
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
        long result=1;
        for(int i=1;i<=n;i++){
            result *= i;
        }
        return result;
    }
}

