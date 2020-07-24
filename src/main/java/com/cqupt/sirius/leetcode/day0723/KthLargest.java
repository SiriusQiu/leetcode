package com.cqupt.sirius.leetcode.day0723;

import java.util.Arrays;

public class KthLargest {

    private  int[] nums;
    private int capacity = 16;
    private int size = 0;
    public KthLargest(int k, int[] nums) {
        this.size = nums.length;
        while (capacity>size){
            capacity<<=1;
        }
        this.nums = Arrays.copyOf(nums, capacity);
    }
    private void resize(){
        capacity<<=1;
        this.nums = Arrays.copyOf(nums, capacity);
    }

}
