package com.java.tessThread;

/**
 * 1. 线程强制停止建议使用标志位
 * 2. 建议线程自己停下来
 * 3. 不推荐使用JDK提供的 stop 方法，因为已经被标记为不推荐使用了
 */
public class TestStop implements Runnable {

    private Boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("这里是 run 方法：" + i++);
        }
    }


    public void stop() {
        this.flag = false;
        System.out.println("线程被停止============");
    }


    public static void main(String[] args) {

        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            // 停止线程
            if (i == 500) {
                testStop.stop();
            }

            System.out.println("这里是主线程：" + i);
        }

    }
}
