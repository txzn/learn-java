package com.java.tessThread;

/**
 * 多个线程同时操作一个对象
 *
 * 这里有一个问题, 多个线程可能会获取到同一张票
 */
public class TestThread4 implements Runnable {

    private int ticketNum = 10;

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                break;
            }

            // 让当前线程睡眠 100 毫秒，防止太快执行，没有效果。
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " --> 拿到了第" + ticketNum-- + "张票");
        }
    }

    public static void main(String[] args) {

        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4, "小明").start();
        new Thread(testThread4, "小刚").start();
        new Thread(testThread4, "小红").start();
    }
}
