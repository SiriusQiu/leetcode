package com.cqupt.sirius.bishi.day0822.test2;

import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] vs = new int[n];
        int[] ws = new int[n];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i< n; i++){
            vs[i] = scanner.nextInt();
            ws[i] = scanner.nextInt();
            list.add(new int[]{vs[i] + ws[i]*2, i});
        }
        list.sort((i1,i2)->i2[0]-i1[0]);
        int value = list.get(m-1)[0];
        List<int[]> results = new ArrayList<>();
        int[] result = new int[m];
        for (int i = 0; i < m-1; i++){
            result[i] = list.get(i)[1];
        }
        Arrays.sort(result);
        int k = m-1;
        while (k < n&&list.get(k)[0]==value){
            int[] arr = Arrays.copyOf(result,m);
            arr[0] = list.get(k++)[1];
            results.add(arr);
        }
        results.sort((i1,i2)->i1[0]-i2[0]);
        results.forEach(Main::print);
    }
    public static void print(int[] arr){
        for (int num : arr){
            System.out.print((num+1) + " ");
        }
        System.out.println();
    }
}
