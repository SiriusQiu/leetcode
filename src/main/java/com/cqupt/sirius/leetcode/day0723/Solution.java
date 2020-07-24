package com.cqupt.sirius.leetcode.day0723;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (root.val==val) return root;
        else if (root.val < val) return searchBST(root.right, val);
        else  return searchBST(root.left,val);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBST(root,val,root);
    }
    public TreeNode insertIntoBST(TreeNode root, int val,TreeNode head) {
        if (root==null) return head;
        if (root.val==val) return head;
        else if (root.val<val){
            if (root.right==null){
                TreeNode newNode = new TreeNode(val);
                root.right = newNode;
                return head;
            }else {
                return insertIntoBST(root.right,val);
            }
        }else {
            if (root.left==null){
                TreeNode newNode = new TreeNode(val);
                root.left = newNode;
                return head;
            }else {
                return insertIntoBST(root.left, val);
            }
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root ==null) return root;
        if (root.val==key){
            if (root.left == null&&root.right==null) return null;
            else if (root.left==null) return root.right;
            else if (root.right==null) return root.left;
            else {
                int val = deleteRightMin(root);
                TreeNode newTreeNode = new TreeNode(val);
                newTreeNode.left = root.left;
                newTreeNode.right = root.right;
                return newTreeNode;
            }
        }
        return deleteNode(root, key, root);
    }
    public TreeNode deleteNode(TreeNode root, int key, TreeNode head) {
        if (root == null) return head;
        if (root.left!=null&&root.left.val==key){
            TreeNode treeNode = root.left;
            if (treeNode.left==null&&treeNode.right==null)root.left=null;
            else if (treeNode.left==null) root.left = treeNode.right;
            else if (treeNode.right==null) root.left = treeNode.left;
            else {
                int val = deleteRightMin(treeNode);
                TreeNode newTreeNode = new TreeNode(val);
                newTreeNode.left = treeNode.left;
                newTreeNode.right = treeNode.right;
                root.left = newTreeNode;
            }
        }else if (root.right!=null&&root.right.val==key){
            TreeNode treeNode = root.right;
            if (treeNode.left==null&&treeNode.right==null)root.right=null;
            else if (treeNode.left==null) root.left = treeNode.right;
            else if (treeNode.right==null) root.left = treeNode.left;
            else {
                int val = deleteRightMin(treeNode);
                TreeNode newTreeNode = new TreeNode(val);
                newTreeNode.left = treeNode.left;
                newTreeNode.right = treeNode.right;
                root.right = newTreeNode;
            }
        }else if (root.val < key) return deleteNode(root.right, key,head);
        else return deleteNode(root.left, key,head);
        return head;
    }
    public int deleteRightMin(TreeNode root){
        if (root.right.left==null){
            int result = root.right.val;
            root.right = root.right.right;
            return result;
        }
        TreeNode treeNode = root.right;
        while (treeNode.left.left!=null){
            treeNode = treeNode.left;
        }
        int result = treeNode.left.val;
        treeNode.left = treeNode.left.right;
        return result;
    }
}
