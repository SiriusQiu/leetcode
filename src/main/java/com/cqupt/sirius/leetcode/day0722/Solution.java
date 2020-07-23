package com.cqupt.sirius.leetcode.day0722;

import java.util.*;

public class Solution {
    static class Ele{
        int value;
        int abs;
        static int x;
        Ele(int value){
            this.value = value;
            this.abs = Math.abs(value - x);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Ele.x = x;
        Ele[] eles = new Ele[arr.length];
        Ele[] temp = new Ele[arr.length];
        for (int i = 0; i < arr.length; i++){
            eles[i] = new Ele(arr[i]);
        }
        mergeSort(eles, 0, arr.length-1, temp);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++){
            result.add(eles[i].value);
        }
        result.sort((o1,o2)->o1-o2);
        return result;
    }

    public void mergeSort(Ele[] eles, int left, int right, Ele[] temp){
        if(left >= right) return;
        int mid = left + (right - left)/2;
        mergeSort(eles, left, mid, temp);
        mergeSort(eles, mid+1, right, temp);
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i<=mid&&j<=right){
            temp[index++] = eles[i].abs<=eles[j].abs?eles[i++]:eles[j++];
        }
        while (i<=mid) temp[index++] = eles[i++];
        while (j<=right) temp[index++] = eles[j++];
        for (int k = left; k <= right; k++){
            eles[k] = temp[k];
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8},18));
    }
  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public int closestValue(TreeNode root, double target) {
        if (((double) root.val)==target) return root.val;
        else if (root.left!=null&&(double)root.left.val>=target) return closestValue(root.left, target);
        else if (root.right!=null&&(double)root.right.val<=target) return closestValue(root.right, target);
        else {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            if (root.left!=null&&(double)root.val>target) return closestValue(root.left, target, list);
            else if (root.right!=null&&(double)root.val<=target) return closestValue(root.right, target,list);
            else return root.val;
        }
    }
    public int closestValue(TreeNode root, double target, List<TreeNode> list) {
        if (((double) root.val)==target) return root.val;
        list.add(root);
        if (root.left!=null&&(double)root.val>target) return closestValue(root.left, target, list);
        else if (root.right!=null&&(double)root.val<=target) return closestValue(root.right, target,list);
        else{
            list.sort((o1,o2)->{
                double result = Math.abs(((double)o1.val)-target) - Math.abs(((double)o1.val)-target);
                if (result>0) return 1;
                else if (result<0) return -1;
                else return 0;
            });
            return list.get(0).val;
        }

    }
    public double myPow(double x, int n) {
        if (n==0) return 1;
        else if (n==1)return x;
        else if (n==-1) return 1/x;
        else {
            int length = n>0?n:-n;
            double result = 1;
            while (length>0){
                double temp = x;
                int i = 1;
                for (; ;){
                    if (i*2 <= length){
                        temp*=temp;
                        if (temp==0) return 0;
                        i+=i;
                    }else break;
                }
                result*=temp;
                length -=i;
            }
            return n>0?result:1/result;
        }
    }
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        else if (num==0) return true;
        int left = 1;
        int right = 46340;
        while (left < right){
            int mid = left + (right - left) /2;
            int square = mid * mid;
            if (square==num) return true;
            else if (square < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[letters.length-1]<=target) return letters[0];
        int left = 0;
        int right = letters.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (letters[mid]==target) return letters[mid+1];
            else if (letters[mid] < target){
                if (letters[mid + 1] > target) return letters[mid+1];
                else left=mid+1;
            }
            else right = mid - 1;
        }
        return letters[left+1];
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) /2;
            int count = 0;
            for (int i =0; i < nums.length; i++){
                if (nums[i]<=mid) count++;
            }
            if (count<=mid) left = mid+1;
            else right = mid;
        }
        return nums[right];
    }
    static class Node{
        int value;
        Node prev;
        Node next;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Node head = null;
        Node tail = null;
        int size = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                Node newNode = new Node();
                newNode.value = abs;
                if (tail == null) {
                    head = newNode;
                    tail = newNode;
                    size++;
                } else {
                    if (size < k || tail.value > abs) {
                        Node current = tail;
                        while (current != null && current.value > abs) current = current.prev;
                        if (current == null) {
                            newNode.next = head;
                            head.prev = newNode;
                            head = newNode;
                        } else {
                            newNode.prev = current;
                            newNode.next = current.next;
                            if (current.next != null) current.next.prev = newNode;
                            current.next = newNode;
                            if (tail.value < newNode.value) tail = newNode;
                        }
                        size++;
                        if (size > k) {
                            tail = tail.prev;
                            size--;
                        }
                    }
                }
            }
        }
        return tail.value;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right!=null) stack.push(treeNode.right);
            if (treeNode.left!=null) stack.push(treeNode.left);
        }
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode treeNode = stack.pop();
            if (treeNode.left!=null){
                TreeNode left = treeNode.left;
                treeNode.left = null;
                stack.push(treeNode);
                stack.push(left);
                continue;
            }
            result.add(treeNode.val);
            if (treeNode.right!=null){
                TreeNode right = treeNode.right;
                stack.push(right);
            }
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode treeNode = stack.pop();
            if (treeNode.left!=null){
                TreeNode left = treeNode.left;
                treeNode.left = null;
                stack.push(treeNode);
                stack.push(left);
                continue;
            }
            if (treeNode.right!=null){
                TreeNode right = treeNode.right;
                treeNode.right = null;
                stack.push(treeNode);
                stack.push(right);
            }
            result.add(treeNode.val);
        }
        return result;
    }
}
