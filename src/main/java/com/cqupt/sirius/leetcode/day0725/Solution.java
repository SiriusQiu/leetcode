package com.cqupt.sirius.leetcode.day0725;

public class Solution {


    public static void main(String[] args) throws InterruptedException {
        ReorderExample reorderExample = new ReorderExample();
        Thread thread1 = new Thread(reorderExample::write);
        Thread thread2 = new Thread(reorderExample::reader);
        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();
    }

}
class ReorderExample{
    int a = 0;
    boolean flag = false;
    public void write(){
         a = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;

    }
    public void reader(){
        if (flag) {
            int i = a * a;
            System.out.println("i is " + i);
        }

    }
}