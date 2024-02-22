package com.java.tessThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程执行的第三种方式 实现 Callable
 */
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TestCallable testCallable1 = new TestCallable("https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2023/11/12/kuangstudye6945907-1a50-46d3-a03d-a23444a78b0b.png", "1.png");
        TestCallable testCallable2 = new TestCallable("https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2023/11/12/kuangstudye6945907-1a50-46d3-a03d-a23444a78b0b.png", "2.png");
        TestCallable testCallable3 = new TestCallable("https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2023/11/12/kuangstudye6945907-1a50-46d3-a03d-a23444a78b0b.png", "3.png");

        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = executorService.submit(testCallable1);
        Future<Boolean> r2 = executorService.submit(testCallable2);
        Future<Boolean> r3 = executorService.submit(testCallable3);

        // 获取执行结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        // 关闭服务
        executorService.shutdownNow();
    }
}
