package com.cqupt.sirius.leetcode.day0724;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divisorGame(3));
    }

    public boolean divisorGame(int N) {
        int[] dp = new int[N+1];
        List<Integer>[] lists = new List[N+1];
        return divisorGame(N, dp, lists);
    }
    public boolean divisorGame(int N, int[] dp, List<Integer>[] lists) {
        if (dp[N]!=0) return dp[N]==1;
        if (N==2) return true;
        List<Integer> list = lists[N];
        if (list==null){
            list = new ArrayList<>();
            for (int i = 1; i <= N/i;i++){
                if (N%i==0) {
                    list.add(i);
                    if (i!=N/i&&N/i!=N) list.add(N/i);
                }
            }
            list.sort((o1,o2)->o1-o2);
            lists[N] = list;
        }
        boolean result = false;
        for (int i = 0; i < list.size();i++){
            if (!divisorGame(N-list.get(i),dp,lists)){
                result = true;
                break;
            }
        }
        dp[N] = result?1:-1;
        return result;
    }
}
