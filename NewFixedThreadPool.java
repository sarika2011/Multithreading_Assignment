package Question_2;
/*2) Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.*/
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class NewFixedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        //Using new Fixed Thread pool.
        ExecutorService ex = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> callables = new ArrayList<>();

        Callable<Integer> callable = () -> {
            Thread.sleep(300);
            return 5;
        };

        callables.add(callable);
        callables.add(callable);
        callables.add(callable);
        callables.add(callable);
        callables.add(callable);
        callables.add(callable);

        List<Future<Integer>> futures = ex.invokeAll(callables);
        System.out.println(Thread.activeCount());
        futures.forEach(res -> {
            try {
                System.out.println("Result :: " + res.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        ex.shutdown();
    }
}
