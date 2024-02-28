package com.java.tessThread;

/**
 * 使用 yield 方法进行线程礼让
 * 让线程进入就绪状态，重新进行 CPU 资源争夺。
 */
public class TestYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止");
    }

    public static void main(String[] args) {
        TestYield testYield = new TestYield();

        new Thread(testYield, "a").start();
        new Thread(testYield, "d").start();
    }
}
