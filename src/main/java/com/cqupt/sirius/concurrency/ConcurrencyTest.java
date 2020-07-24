package com.cqupt.sirius.concurrency;

/**
 * 并发和串行效率测试
 * count = 100001 concurrency : 2ms，serial : 2ms
 * count = 200001 concurrency : 2ms，serial : 2ms
 * count = 400001 concurrency : 3ms，serial : 3ms
 * count = 800001 concurrency : 2ms，serial : 5ms
 * count = 1000001 concurrency : 2ms，serial : 5ms
 * count = 2000001 concurrency : 2ms，serial : 5ms
 */
public class ConcurrencyTest {
    private static final long count = 2000001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i< count; i++){
                    a+=5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++){
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency : " + time + "ms, b=" + b);
    }
    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++){
            a+=5;
        }
        int b = 0;
        for (long i = 0; i < count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial : " + time + "ms, b=" + b);
    }

}
