package com.cqupt.sirius.mysql.day0826;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class ConnectorTest {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10) + 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = random.nextInt(20) + 20;
        }
        IntStream.of(arr).forEach(ConnectorTest::print);
        arr = IntStream.of(arr).sorted().toArray();
        IntStream.of(arr).forEach(ConnectorTest::print);
    }
    public static void print(int num){
        System.out.print(num + " ");
    }
}
