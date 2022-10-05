package Question_4;

/*4) WAP to show usage of Callable and demonstrate how it is different from Runnable*/
import java.util.concurrent.*;

class Call implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello From callable :: " + Thread.currentThread().getName();
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Call call = new Call();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(call);

        System.out.println(future.get());
        executor.shutdown();
    }
}
