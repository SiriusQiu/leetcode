package com.cqupt.sirius.leetcode.day0611;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    /**
     *  基本思路：以陆地为源，一级一级往外扩散，什么时候截止呢，1、没有陆地，2、没有海洋
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){ return  -1;};
        boolean hasLand = false;
        int hasOcean = 0;
        int result = -1;
        for (int[] nums : grid){
            for (int num : nums){
                if(num == 0){
                    hasOcean ++;
                }
                if (num==1) {
                    hasLand = true;
                }
            }
        }
        if (hasOcean==0||!hasLand) return -1;
        int time = 0;
        while (hasLand&&hasOcean>0){
            time++;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == time){
                        if (i > 0 && grid[i-1][j]==0){
                            grid[i-1][j] = time+1;
                            hasOcean --;
                        }
                        if (j > 0 && grid[i][j-1]==0) {
                            grid[i][j-1] = time+1;
                            hasOcean --;
                        }
                        if (i < grid.length-1 && grid[i+1][j]==0) {
                            grid[i+1][j] = time+1;
                            hasOcean --;
                        }
                        if (j < grid[0].length-1 && grid[i][j+1]==0) {
                            grid[i][j+1] = time+1;
                            hasOcean --;
                        }
                    }
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxDistance(new int[][]{{0,0,1,1,1},{0,1,1,0,0},{0,0,1,1,0},{1,0,0,0,0},{1,1,0,0,1}});
    }
}
