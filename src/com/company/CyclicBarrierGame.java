package com.company;

import java.util.concurrent.*;

public class CyclicBarrierGame {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> result = service.schedule(() -> System.out.println("Runnable"), 5000, TimeUnit.MILLISECONDS);
        Future<?> res = service.schedule(() -> "Callable", 5000, TimeUnit.MILLISECONDS);

        System.out.println("R result: " + result.getDelay(TimeUnit.SECONDS));
        System.out.println("C result: " + res.get());

        service.shutdown();
    }
}
