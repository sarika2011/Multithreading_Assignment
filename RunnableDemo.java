package Question_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread :: " + Thread.currentThread().getName());
    }
}

public class RunnableDemo {

    public static void main(String[] args) {

        // Creating and running runnable task using Thread class
        RunDemo runDemo = new RunDemo();
        Thread thread = new Thread(runDemo);
        thread.start();

        //Creating and running runnable task using Executor Service.
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(runDemo);
        executor.shutdown();


    }
}
