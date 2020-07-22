package com.cqupt.sirius.leetcode.day0717;

public class Solution {
    public  int strStr(String str, String pattern){
        if (pattern==null||pattern.length()==0) {
            return 0;
        };
        char[] strChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int[] next = new int[patternChars.length];
        for (int i = 1, j = 0; i<pattern.length()-1;i++){
            while (j>0&&patternChars[i]!=patternChars[j]) j = next[j];
            if (patternChars[i] == patternChars[j]) j++;
            next[i+1] = j;
        }
        for (int num : next){
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 0, j = 0; i<str.length();i++){
            while (j>0&&strChars[i]!=patternChars[j]) j = next[j];
            if (strChars[i] == patternChars[j]) {
                if (j == patternChars.length-1) {
                    return i-j;
                }else j++;
            };

        }
        return -1;
    }

    public void reverseString(char[] s) {
        if (s.length == 0|| s.length==1) return;
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    public int arrayPairSum(int[] nums) {
        if (nums.length==0) return 0;
        arrayPairSum(nums, 0, nums.length-1);
        int result = 0;
        for (int i = 0; i < nums.length; i+=2){
            result+=nums[i];
        }
        return result;
    }
    public int arrayPairSum(int[] nums, int left, int right){
        if (left>=right) return 0;
        int i = left - 1;
        int j = right + 1;
        int x = nums[left];
        while (i < j){
            while (nums[++i]<x);
            while (nums[--j]>x);
            if (i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        arrayPairSum(nums,left,j);
        arrayPairSum(nums,j+1,right);
        return 0;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left< right){
            if (numbers[left]+numbers[right]==target){
                return new int[]{left, right};
            }else if (numbers[left]+numbers[right]<target){
                left++;
            }else {
                right--;
            }
        }
        throw new IllegalArgumentException();
    }
    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = nums.length - 1;
        int result = 0;
        while (left>=0){
            if (nums[left]==val){
                result++;
                int i = left;
                while (i<right){
                    nums[i] = nums[i+1];
                    i++;
                }
                right--;
            }
            left--;
        }
        return nums.length-result;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i< nums.length;i++){
            while (i< nums.length&&nums[i]!=1) i++;
            int count = 0;
            while (i< nums.length&&nums[i]==1){
                count++;
                i++;
            }
            if (max < count) max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{0,1,2,2,3,0,4,2};
        int result = solution.removeElement(input, 2);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
