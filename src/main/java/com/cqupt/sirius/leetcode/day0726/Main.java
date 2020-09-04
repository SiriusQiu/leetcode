package com.cqupt.sirius.leetcode.day0726;

public class Main {
    public static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i=0;i<threads.length;i++){
            threads[i]=new Thread(()->{
                synchronized (Main.class){
                    for (int j = 0;j<100;j++) m++;
                }
            });
        }
        for (Thread t:threads) t.start();
        for (Thread t: threads) t.join();
        System.out.println(m);
    }
}
