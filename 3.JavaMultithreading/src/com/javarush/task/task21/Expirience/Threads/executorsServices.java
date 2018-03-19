package com.javarush.task.task21.Expirience.Threads;

import java.util.concurrent.*;

/**
 * Created by amalakhov on 11.05.2017.
 */
public class executorsServices {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };
        Future<Integer> future = executorService.submit(task);

        System.out.println("Future done? "+future.isDone());
        Integer result = future.get();

        System.out.println("Future done? "+future.isDone());
        System.out.print("result "+result);

        executorService.shutdown();


// => Hello pool-1-thread-1
    }
}
