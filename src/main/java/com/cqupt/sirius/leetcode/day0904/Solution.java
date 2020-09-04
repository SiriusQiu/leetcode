package com.cqupt.sirius.leetcode.day0904;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int state = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (index < result.length){
            result[index++] = matrix[i][j];
            flag[i][j] = true;
            if (state==0){
                if (j<matrix[0].length-1&&!flag[i][j+1]) j++;
                else {
                    i++;
                    state = 1;
                }
            }else if (state == 1){
                if (i < matrix.length - 1&&!flag[i+1][j]) i++;
                else {
                    j--;
                    state = 2;
                }
            }else if (state == 2){
                if (j >0&&!flag[i][j-1]) j--;
                else {
                    i--;
                    state = 3;
                }
            }else {
                if (!flag[i-1][j]) i--;
                else {
                    j++;
                    state = 0;
                }
            }
        }
        return result;
    }
    public int translateNum(int num) {
        int[] ints = i2char(num);
        return translateNum(ints, 0);
    }
    public int translateNum(int[] ints, int begin){
        if (begin>=ints.length) return 0;
        int result = 0;
        if (begin==ints.length-1) return 1;
        if (begin==ints.length-2){
            if (ints[begin]*10 + ints[begin+1]<26&&ints[begin]!=0) return 2;
            else return 1;
        }
        else {
            result+=result += translateNum(ints, begin+1);
            if (ints[begin]*10 + ints[begin+1] < 26&&ints[begin]!=0){
                result += translateNum(ints, begin+2);
            }
        }
        return result;
    }
    public int[] i2char(int num){
        List<Integer> list = new ArrayList<>();
        if (num==0) {
            list.add(0);
        }else {
            while (num>0){
                list.add(num%10);
                num/=10;
            }
        }
        final int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(list.size() - 1 -i);
        }
        return result;
    }
    public int movingCount(int m, int n, int k) {
        int result = 0;
        int left = 0;
        int right = n - 1;
        int mark = 0;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (check(0, mid, k)){
                mark = mid;
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        System.out.println(mark);
        int index = 0;
        while (index < m&&mark>=0){
            result += mark+1;
            if (!check(++index, mark, k)) mark--;
        }
        return result;
    }
    public boolean check(int i, int j, int k){
        if (j<0) return false;
        int count = 0;
        while (i >0){
            count += i%10;
            i/=10;
        }
        while (j>0){
            count += j%10;
            j/=10;
        }
        return count<=k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(20,23,8));
    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            sum+=num;
            if (sum<0) sum = num;
            if (sum > max) max = sum;
        }
        return max;
    }
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode next = null;
        while(l1!=null||l2!=null){
            ListNode node = null;
            if(l1!=null&&l2!=null) {
                node = l1.val<l2.val?l1:l2;
                if(l1.val<l2.val) l1 = l1.next;
                else l2 = l2.next;
            }else if(l1!=null){
                node = l1;
                l1 = l1.next;
            }else{
                node = l2;
                l2 = l2.next;
            }
            if(head == null){
                head = node;
            }else {
                next.next = node;
            }
            next = node;
        }
        return head;
    }
}
