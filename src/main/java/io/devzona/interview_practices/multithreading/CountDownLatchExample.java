package io.devzona.interview_practices.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.submit(new DependentService(countDownLatch, "Thread-0"));
        executorService.submit(new DependentService(countDownLatch, "Thread-1"));
        executorService.submit(new DependentService(countDownLatch, "Thread-2"));
        countDownLatch.await();
        System.out.println("Waiting completed");
    }
}

class DependentService implements Runnable {

    private CountDownLatch countDownLatch;
    private String threadName;

    public DependentService(CountDownLatch countDownLatch, String threadName) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Task Started...." + threadName);
        countDownLatch.countDown();
        System.out.println("Task Completed...." + threadName);
    }
}
