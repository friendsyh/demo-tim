package com.tim.common.practice.thread;

/**
 * 多线程的示例，参见文章：http://jameswxx.iteye.com/blog/806968
 * 这个例子每次执行的结果都不一样。线程问题只针对共享变量，比如account对象是线程A和线程B都需要使用的。
 * Created by tim.syh on 2016/7/11.
 */
public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void add(int num) {
        balance = balance + num;
    }

    public void withdraw(int num) {
        balance = balance - num;
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);
        Thread a = new Thread(new AddThread(account, 20), "add");
        Thread b = new Thread(new WithdrawThread(account, 20), "withdraw");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(account.getBalance());
    }

    static class AddThread implements Runnable {
        Account account;
        int amount;

        public AddThread(Account account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 200000; i++) {
                account.add(amount);
            }
        }
    }

    static class WithdrawThread implements Runnable {
        Account account;
        int amount;

        public WithdrawThread(Account account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                account.withdraw(amount);
            }
        }
    }
}
