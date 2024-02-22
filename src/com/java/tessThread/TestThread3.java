package com.java.tessThread;

/**
 * 实现并发方式2 实现 Runnable 接口
 * Runnable 翻译成任务，可以理解成实现了 Runnable后这个类就是一个任务类
 * 然后要将这个任务类丢入到 Tread 线程中.
 */
public class TestThread3 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这里是 run 方法：" + i);
        }
    }

    public static void main(String[] args) {

        TestThread3 thread3 = new TestThread3();

        // 开一个线程，将任务类放入线程中
        Thread thread = new Thread(thread3);

        // 启动线程
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("这里是 main：" + i);
        }

    }

}
