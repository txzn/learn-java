package com.java.tessThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 利用睡眠实现时间的打印，
 * 如果没有睡眠会打印得很快而且会出现时间得重复
 *
 */
public class TestSleep implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                // 获取当前系统时间的毫秒数
                long currentTimeMillis = System.currentTimeMillis();
                // 将毫秒数转换为日期时间对象
                Date currentDate = new Date(currentTimeMillis);

                // 使用 SimpleDateFormat 格式化日期时间对象为指定格式的字符串
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedDate = sdf.format(currentDate);
                System.out.println(formattedDate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TestSleep()).start();
    }

}
