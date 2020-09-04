package com.cqupt.sirius.leetcode.day0823;

import java.util.*;

public class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int begin = rounds[0];
        int end = rounds[rounds.length-1];
        List<Integer> result = new ArrayList<>();
        if (end >begin){
            for (int i = begin; i <= end; i++){
                result.add(i);
            }
        }else if (end == begin){
            result.add(end);
        }else {
            for (int i = 1; i <= end; i++){
                result.add(i);
            }
            for (int i = begin; i <= n; i++){
                result.add(i);
            }
        }
        return result;
    }
    public int maxCoins(int[] piles) {
        if (piles==null||piles.length == 0) return 0;
        Arrays.sort(piles);
        int result = 0;
        for (int i = piles.length/3; i < piles.length; i+=2){
            result += piles[i];
        }
        return result;
    }
    public int findLatestStep(int[] arr, int m) {
        boolean[] booleans = new boolean[arr.length];
        int result = -1;
        //计数
        Map<Integer, Integer> map1 = new HashMap<>();
        //映射
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int num = arr[i];
            boolean hasLeft = false;
            boolean hasRight = false;
            int curruntCount = 1;
            if (map1.containsKey(num-1)){
                int leftCount = map1.get(num-1);
                curruntCount += leftCount;
                if (leftCount==m) result = i;
                hasLeft = true;
            }
            if (map1.containsKey(num+1)){
                int rightCount = map1.get(num+1);
                curruntCount += rightCount;
                if (rightCount==m)result=i;
                hasRight = true;
            }
            if (curruntCount==m) result = i+1;
            if (hasLeft&&hasRight){
                int leftIndex = map2.get(num-1);
                int rightIndex = map2.get(num+1);
                if (leftIndex!=num-1) {
                    map1.remove(num-1);
                    map2.remove(num-1);
                }
                if (rightIndex!=num+1){
                    map1.remove(num+1);
                    map2.remove(num+1);
                }
                map1.put(leftIndex, curruntCount);
                map1.put(rightIndex, curruntCount);
                map2.put(leftIndex, rightIndex);
                map2.put(rightIndex, leftIndex);
            }else if (hasLeft){
                int leftIndex = map2.get(num-1);
                if (leftIndex!=num-1) {
                    map1.remove(num-1);
                    map2.remove(num-1);
                }
                map1.put(leftIndex, curruntCount);
                map1.put(num, curruntCount);
                map2.put(leftIndex, num);
                map2.put(num,leftIndex);
            }else if (hasRight){
                int rightIndex = map2.get(num+1);
                if (rightIndex!=num+1) {
                    map1.remove(num+1);
                    map2.remove(num+1);
                }
                map1.put(rightIndex, curruntCount);
                map1.put(num, curruntCount);
                map2.put(num, rightIndex);
                map2.put(rightIndex, num);
            }else{
                map1.put(num, curruntCount);
                map2.put(num, num);
            }
        }
        return result;
    }
    public int rangeBitwiseAnd(int m, int n) {
        int dis = n - m;
        dis |= dis>>1;
        dis |= dis>>2;
        dis |= dis>>4;
        dis |= dis>>8;
        dis |= dis>>16;
        dis =~dis;
        n = dis&n;

        return m&n;
    }

}
