package com.cqupt.sirius.leetcode.day0901;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return PredictTheWinner(nums, 0, nums.length - 1, 0, 0);
    }
    public boolean PredictTheWinner(int[] nums, int begin, int end, int a, int b) {
        if (begin==end) return a+nums[begin]>=b;
        if (begin+1==end) {
            a += Math.max(nums[begin],nums[begin+1]);
            b += b + Math.min(nums[begin],nums[begin+1]);
            return a >= b;
        }
        return (PredictTheWinner(nums, begin+2,end, a+nums[begin], b+nums[begin+1])
                && PredictTheWinner(nums, begin+1,end-1, a+nums[begin], b+nums[end]))
                || (PredictTheWinner(nums, begin+1,end-1, a+nums[end], b+nums[begin])
                && PredictTheWinner(nums, begin, end-2, a+nums[end], b+nums[end-1]));
    }

}
