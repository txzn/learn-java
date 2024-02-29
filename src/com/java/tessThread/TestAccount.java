package com.java.tessThread;

/**
 * synchronized 可以用在方法，和同步块中
 * 用在方法上锁的是当前的对象，及 this 对象。
 * 如下代码，将 synchronized 加在方法体上你会发现是没用的，需要使用同步块。
 */
public class TestAccount {
    public static void main(String[] args) {
        AccCount accCount = new AccCount("AAAA", 100);

        new ATM("小明", accCount, 50).start();
        new ATM("小红", accCount, 100).start();

    }
}


class AccCount {
    private String name;
    private Integer balance;

    public AccCount(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}

class ATM extends Thread {
    private final AccCount accCount;
    private Integer take;

    public ATM(String name, AccCount accCount, Integer take) {
        super(name);
        this.accCount = accCount;
        this.take = take;
    }


    @Override
    public void run() {
        try {
            toTake();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void toTake() throws InterruptedException {
        Thread.sleep(1000);
        // 传入需要锁定的共享资源
        synchronized (accCount) {
            if (accCount.getBalance() < this.take) {
                System.out.println(this.getName() + ",当前余额不足，当前余额为：" + accCount.getBalance());
                return;
            }

            Integer i = accCount.getBalance() - this.take;
            accCount.setBalance(i);
            System.out.println(this.getName() + "取走了 " + this.take + " 剩余" + accCount.getBalance());
        }
    }

}
