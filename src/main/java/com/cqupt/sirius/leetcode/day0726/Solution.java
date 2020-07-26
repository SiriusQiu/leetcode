package com.cqupt.sirius.leetcode.day0726;

public class Solution {
    public static void main(String[] args)   {
        Thread thread1 = new Thread(new RunnableA());
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        thread1.interrupt();
        System.out.println("thread has been interrupted? "+ thread1.isInterrupted());
        System.out.println("thread has been interrupted? "+ thread1.isInterrupted());

    }

    static class RunnableA implements Runnable{


        @Override
        public void run()  {
            while (true);
        }
    }
    static class RunnableB implements Runnable{



        @Override
        public void run()  {

        }
    }
}
