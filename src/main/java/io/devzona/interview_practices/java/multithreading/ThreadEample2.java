package io.devzona.interview_practices.java.multithreading;

public class ThreadEample2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread2);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread is running and its name " + Thread.currentThread().getName() + " : " + i);
        }
    }
}
