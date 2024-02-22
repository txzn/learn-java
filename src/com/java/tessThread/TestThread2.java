package com.java.tessThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 使用线程实现快速下载
 */
public class TestThread2 extends Thread {

    private String url;
    private String name;

    TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {

        TestThread2 testThread1 = new TestThread2("https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2023/11/12/kuangstudye6945907-1a50-46d3-a03d-a23444a78b0b.png", "1.png");
        TestThread2 testThread2 = new TestThread2("https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2023/11/12/kuangstudye6945907-1a50-46d3-a03d-a23444a78b0b.png", "2.png");
        TestThread2 testThread3 = new TestThread2("https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2023/11/12/kuangstudye6945907-1a50-46d3-a03d-a23444a78b0b.png", "3.png");

        // 开启多个线程执行下载
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader 方法出现问题");
        }
    }
}
