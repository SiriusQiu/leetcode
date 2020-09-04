package com.cqupt.sirius.leetcode.day0821;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        int result = 1;
        while (!queue1.isEmpty()){
            TreeNode treeNode = queue1.poll();
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (left==null&&right==null) return result;
            if (left!=null) queue2.add(left);
            if (right!=null) queue2.add(right);
            if (queue1.isEmpty()){
                result++;
                Queue<TreeNode> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
        }
        return result;
    }

}
