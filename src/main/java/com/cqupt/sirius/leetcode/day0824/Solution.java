package com.cqupt.sirius.leetcode.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void crteateBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }, "testBusyThread");
        thread.start();
    }
    public static void createLockThread(final Object object){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try{
                        object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        crteateBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
