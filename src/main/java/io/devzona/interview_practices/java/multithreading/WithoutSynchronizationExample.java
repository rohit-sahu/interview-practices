package io.devzona.interview_practices.java.multithreading;

public class WithoutSynchronizationExample {
    public static void main(String[] args) {
        Account account = new Account();
        AccountThread accountThread = new AccountThread(account);
        Thread thread1 = new Thread(accountThread);
        Thread thread2 = new Thread(accountThread);
        thread1.start();
        thread2.start();
    }
}

class AccountThread implements Runnable {
    private Account account;
    public AccountThread(Account account) {
        this.account = account;

    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            account.withdraw(225);
            if (account.getBalance() < 0) {
                System.out.println("Amount is Overdrawn......");
            }
        }
    }
}

class Account {
    private int balance = 1000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to withdraw....." + amount);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " is completed withdraw.. : " + amount);
        } else {
            System.out.println("No Funds for " + Thread.currentThread().getName());
        }
    }

    public int getBalance() {
        return balance;
    }
}
