package com.java.tessThread;

/**
 * 测试守护线程
 * 1. 线程包括用户线程和守护线程
 * 2. 虚拟机必须确保用户线程执行完毕，mian 线程
 * 3. 虚拟机不用等待守护线程执行完毕，例如 GC 线程，后台日志监控
 */
public class TestDaemon {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);

        threadA.setDaemon(true); // 设置成守护线程，默认是 false
        threadA.start();

        threadB.start();

    }
}


class A implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("这里是守护线程");
        }

    }
}

class B implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("这里是用户线程");
        }
    }
}

