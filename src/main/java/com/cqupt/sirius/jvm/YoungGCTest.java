package com.cqupt.sirius.jvm;

import java.util.Scanner;

public class YoungGCTest {

    public static void main(String[] args) throws Exception {
        Thread.sleep(30000);
        while (true){
            loadData();
        }
    }

    private static void loadData() throws Exception{
        byte[] data = null;
        for (int i = 0; i < 50 ;i++){
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }

}
