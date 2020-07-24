package com.cqupt.sirius.leetcode.day0723;

import javax.swing.tree.TreeNode;

public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode head = null;
    public BSTIterator(TreeNode root) {
        head = root;
    }




    /** @return the next smallest number */
    public int next() {
        int result = 0;
        if (head.left == null){
            result = head.val;
            head = head.right;
            return result;
        }
        TreeNode treeNode = head;
        while (treeNode.left.left!=null){
            treeNode = treeNode.left;
        }
        result = treeNode.left.val;
        treeNode.left = treeNode.left.right;
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return head!=null;
    }
}
