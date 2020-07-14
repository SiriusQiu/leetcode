package com.cqupt.sirius.leetcode.day0710;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        String[] strs = new String[nums.length];
        return findTargetSumWays(nums, S, 0, 0);
    }
    public int findTargetSumWays(int[] nums, int S, int offset, int acc){
        if (offset==nums.length-1){
            int result = acc + nums[offset] == S? 1:0;
            result = acc - nums[offset] == S? result+1:result;
            return result;
        }
        int result = findTargetSumWays(nums, S, offset+1, acc + nums[offset]);
        result += findTargetSumWays(nums, S, offset + 1, acc - nums[offset]);
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if (treeNode.right!=null){
                TreeNode rightNode = treeNode.right;
                treeNode.right = null;
                stack.push(rightNode);
            }
            if (treeNode.left == null){
                list.add(treeNode.val);
            }else {
                TreeNode leftNode = treeNode.left;
                treeNode.left = null;
                stack.push(treeNode);
                stack.push(leftNode);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;
        System.out.println(solution.inorderTraversal(treeNode3));
    }
}
