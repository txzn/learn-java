package com.java.tessThread;

/**
 * Thread 类的使用
 * 查看 Java JDK 文档，文档中有例子
 * 继承 Thread 重写 run 方法 （run 方法相当于程序执行的入口，与 main 方法类似）
 * 调用就 new 子类对象，然后抵用 start 方法 即可开启一个线程
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这里是 run 方法: " + i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        // 开启线程
        testThread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("这里是 main 方法：" + i);
        }

    }

}
