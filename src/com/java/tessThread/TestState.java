package com.java.tessThread;

/**
 * 测试线程的状态
 */
public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // 线程执行结束
            System.out.println("//////");
        });

        // 线程未开始是 NEW
        Thread.State state = thread.getState();
        System.out.println(state);

        // 线程开始 RUNNABLE
        thread.start();
        state = thread.getState();
        System.out.println(state);

        // 线程不终止就继续执行
        while (thread.getState() != Thread.State.TERMINATED) {
            state = thread.getState();
            System.out.println(state);
        }

        // 线程终止
        state = thread.getState();
        System.out.println(state);
    }
}
