package com.cqupt.sirius.leetcode.day0721;

import java.util.*;

public class TwoSum {
    /** Initialize your data structure here. */
    private int[] arr;
    private int size;
    public TwoSum() {
        this.arr = new int[16];
        size = 0;
    }
    private void resize(){
        int[] oldArr = arr;
        int[] newArr = new int[arr.length << 1];
        for (int i = 0;i < oldArr.length; i++){
            newArr[i] = oldArr[i];
        }
        this.arr = newArr;
    }
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (size + 1 >= arr.length){
            resize();
        }
        int i = size;
        while (i>0&&arr[i-1]>number){
            arr[i] = arr[i-1];
            i--;
        }
        arr[i] = number;
        size++;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < size-1; i++){
            int left = i + 1;
            int right = size - 1;
            while (left <= right){
                int mid = (left + right) >>> 1;
                int sum  = arr[i] + arr[mid];
                if (sum == value) return true;
                else if (sum < value) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Random random = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++){
            int next = random.nextInt(200)-100;
            arr[i] = next;
            twoSum.add(next);
        }
        Arrays.sort(arr);
        for (int i = 0; i < 100; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        twoSum.print();

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                int count = map.get(num);
                count++;
                map.put(num, count);
            }else {
                map.put(num, 1);
            }
        }
        int[][] mark = new int[map.size()][2];
        Iterator<Integer> integerIterator = map.keySet().iterator();
        int i = 0;
        while (integerIterator.hasNext()){
            int key = integerIterator.next();
            int count = map.get(key);
            mark[i++] = new int[]{count, key};
        }
        quickSort(mark, 0, mark.length);
        int[] result = new int[k];
        for (int j = 0; j < k; j++){
            result[j] = mark[j][1];
        }
        return result;
    }
    public void quickSort(int[][] mark, int left, int right){
        if (left>= right) return;
        int i = left - 1;
        int j = right + 1;
        int x = mark[left][0];
        while (i < j){
            while (mark[++i][0] < x);
            while (mark[--j][0] > x);
            if (i < j){
                int[] temp = mark[i];
                mark[i] = mark[j];
                mark[j] = temp;
            }
        }
        quickSort(mark, left, j);
        quickSort(mark, j+1, right);
    }
}
