package com.cqupt.sirius.leetcode.day0821;

import java.io.BufferedInputStream;
import java.lang.reflect.Array;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (j == i) continue;
                for (int k = 0; k < 10; k++){
                    if (k==i||k==j) continue;
                    int num = i*200+j*10+k*12;
                    if (map.containsKey(num)){
                        List<int[]> list = map.get(num);
                        list.add(new int[]{i*100 + j *10 + k, i*100 + k*12});
                        list.sort((i1, i2)->i1[0]-i2[0]);
                    }else {
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{i*100 + j *10 + k, i*100 + k*12});
                        map.put(num, list);
                    }
                }
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            List<int[]> value = map.get(n);
            solution(n, value);
        }
    }
    public static void solution(int n, List<int[]> value) {
        int a = n/200;
        int remain = n - a * 200;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            int b = remain - i*12;
            if (b%10!=0) continue;
            b/=10;
            if (b < 10&&b >= 0&&b!=i&&b!=a&&i!=a){
                list.add(new int[]{a*100+b*10+i,a*100+i*11});
            }
        }
        list.sort((i1, i2)->i1[0]-i2[0]);
        if (list.size()!=value.size()) {
            System.out.println(n + "  size is wrong");
            System.out.println("my size is " + list.size());
            System.out.println("value size is " + value.size());
            list.forEach(Main::print);
            value.forEach(Main::print);
            System.out.println("===========");
        }
        for (int i = 0; i < list.size(); i++){
            int[] row1=list.get(i);
            int[] row2=list.get(i);
            if (row1[0]!=row2[0]||row1[1]!=row2[1]) System.out.println(n + " is wrong");
        }
    }
    public static void print(int[] arr){
        System.out.println(arr[0] + " " + arr[1]);
    }

}
