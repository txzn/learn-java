package com.java.tessThread;

/**
 * 设置程序优先级
 */
public class TestPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());


        TestPriority testPriority = new TestPriority();

        Thread thread1 = new Thread(testPriority, "1");
        Thread thread2 = new Thread(testPriority, "2");
        Thread thread3 = new Thread(testPriority, "3");
        Thread thread4 = new Thread(testPriority, "4");
        Thread thread5 = new Thread(testPriority, "5");
        Thread thread6 = new Thread(testPriority, "6");
        Thread thread7 = new Thread(testPriority, "7");


        thread1.start();

        thread2.setPriority(10);
        thread2.start();

        thread3.setPriority(9);
        thread3.start();

        thread4.setPriority(8);
        thread4.start();

        thread5.setPriority(7);
        thread5.start();

        thread6.setPriority(6);
        thread6.start();

        thread7.setPriority(5);
        thread7.start();

    }
}
