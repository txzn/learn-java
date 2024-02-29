package com.java.tessThread;

import java.util.ArrayList;
import java.util.List;

/**
 * 多线程的情况会使得线程出现不安全的情况
 * 如出现 共享资源的争夺
 * 使用 ArrayList 为例子
 * 当多个线程往同一个 ArrayList 添加数据时，可能会出现多个线程同时操作容器的同一个位置
 * 就会将数据覆盖。
 * 测试多线程可以使用 sleep 让线程都起来起来，在进行资源争夺，可以将问题放大。
 */
public class TestThreadInsecurity {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add("a");
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
