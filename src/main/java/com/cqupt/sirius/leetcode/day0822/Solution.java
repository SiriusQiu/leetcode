package com.cqupt.sirius.leetcode.day0822;

import java.util.*;

public class Solution {
    public boolean judgePoint24(int[] nums) {
        return false;

    }
    public String thousandSeparator(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (n > 0){
            stringBuilder.append(n%10);
            n/=10;
            count++;
            if (count == 3) {
                stringBuilder.append('.');
                count = 0;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = stringBuilder.length(); i>=0 ; i--){
            result.append(stringBuilder.charAt(i));
        }
        return result.toString();
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (List<Integer> edge : edges){
            set1.add(edge.get(0));
            set2.add(edge.get(1));
        }
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()){
            set1.remove(iterator.next());
        }
        iterator = set1.iterator();
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()){
            result.add(iterator.next());
        }
        return result;
    }
    public int minOperations(int[] nums) {
        int result = 0;
        int max = 0;
        for (int num : nums){
            result += count(num);
            int cur = max(num);
            max = cur > max? cur:max;
        }
        return result+max;
    }
    public int max(int num){
        if (num==1) return 0;
        int result = 0;
        while (num>0){
            num /=2;
            result++;
        }
        return result-1;
    }
    public int count(int num){
        int result = 0;
        while (num > 0){
            num -= num&(-num);
            result ++;
        }
        return result;
    }
    public static void main(String[] args) {
        int A = 'A';
        int Z = 'Z';
        int i0 = '0';
        int i9 = '9';
        int a = 'a';
        int z = 'z';
        System.out.println(A);
        System.out.println(Z);
        System.out.println(i0);
        System.out.println(i9);
        System.out.println(a);
        System.out.println(z);
    }
}
