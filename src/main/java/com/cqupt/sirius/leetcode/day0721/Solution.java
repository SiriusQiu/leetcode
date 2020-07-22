package com.cqupt.sirius.leetcode.day0721;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.groupAnagrams(new String[]{"ape","pep"});
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, false);
        List<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < n; i++){
            TreeNode head = new TreeNode(i+1);
            flags[i] = true;
            generateTrees(n,flags,head,head, 1, result);
            flags[i] = false;
        }
        return null;
    }
    public List<TreeNode> generateTrees(int n, boolean[] flags, TreeNode head, TreeNode current, int count, List<TreeNode> rsult){

        return null;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, false);
            }else map.put(num, true);
        }
        Iterator<Integer> integerIterator = map.keySet().iterator();
        while (integerIterator.hasNext()){
            int key = integerIterator.next();
            if (map.get(key)) return key;
        }
        return -1;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n = happyNext(n);
        }
        if (n==1) return true;
        else return false;
    }

    public int happyNext(int n){
        int result = 0;
        while (n > 0){
            int num = n % 10;
            n /=10;
            result+=num*num;
        }
        return result;
    }
    public int[] twoSum(int[] nums, int target) {
        if (nums.length==0) return nums;
        int[] copy = Arrays.copyOf(nums, nums.length);
        quickSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length-1;i++){
            if (nums[i] == target) return new int[]{nums[i]};
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right){
                int mid = (left + right)/2;
                int sum = nums[i] + nums[mid];
                if(sum  == target) {
                    int index = 0;
                    int[] result = new int[2];
                    for (int k = 0; k < copy.length; k++){
                        if (nums[i]==copy[k]){
                            result[index++] = k;
                        }else if (nums[mid]==copy[k]){
                            result[index++] = k;
                        }
                    }
                    return result;
                }
                else if (sum < target) left = mid + 1;
                else right = mid -1;
            }
        }

        throw new IllegalArgumentException();
    }
    private void quickSort(int nums[], int left, int right){
        if (left >=  right) return;
        int i = left - 1;
        int j = right + 1;
        int x = nums[left];
        while(i < j){
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length==0||list2.length==0) return new String[]{};
        Set<String> result = null;
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++){
            map1.putIfAbsent(list1[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++){
            if (map1.containsKey(list2[i])){
                int sum = map1.get(list2[i])+i;
                if (sum==minIndex){
                    result.add(list2[i]);
                }else if (sum < minIndex){
                    result = new HashSet<>();
                    result.add(list2[i]);
                    minIndex = sum;
                }
            }
        }
        if (result!=null){
            String[] resultArr = new String[result.size()];
            int i = 0;
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()){
                resultArr[i++] = iterator.next();
            }
            return  resultArr;
        }else return new String[]{};
    }


    public boolean isIsomorphic(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        if (sChar.length!=tChar.length) return false;
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < sChar.length; i++){
            char sc = sChar[i];
            char tc = tChar[i];
            if(s2t.containsKey(sc)&&s2t.get(sc)==tc){
                if (t2s.containsKey(tc)&&t2s.get(tc)==sc) continue;
                else return false;
            }else if (!s2t.containsKey(sc)&&!t2s.containsKey(tc)){
                s2t.put(sc, tc);
                t2s.put(tc, sc);
            }else return false;
        }
        return true;
    }
    public int firstUniqChar(String s) {
        if (s.length()==0) return -1;
        if (s.length()==1) return s.charAt(0);
        int[] arr = new int[26];
        char first = s.charAt(0);
        for (int i = 1 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (c==first||arr[c-'a']>0||arr[c-'a']==-1) {
                arr[c-'a'] = -1;
            }else {
                arr[c-'a'] = i;
            }
        }
        if (arr[first-'a']==0) return 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr){
            if (num!=0&&num!=-1&&num < min){
                min = num;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        int[] zhishu = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            int[] count = new int[26];
            for (char c : chars){
                count[c-'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < 26; k++){
                if (count[k]>0) stringBuilder.append((char)( k+'a')).append(count[k]);
            }
            String key = stringBuilder.toString();
            System.out.println("key is " + key);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            result.add(map.get(iterator.next()));
        }
        return result;
    }
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings){
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = str.toCharArray();
            int juli = chars[0] - 'a';
            System.out.println(juli);
            for (char c : chars){
                stringBuilder.append((char)((c-'a'-juli+26)%26 + 'a'));
            }
            String key = stringBuilder.toString();
            System.out.println("key is " + key);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            result.add(map.get(iterator.next()));
        }
        return result;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j++){
                char a = board[i][j];
                if (a=='.') continue;
                else if (map.containsKey(a)){
                    List<int[]> list = map.get(a);
                    for (int[] ints : list){
                        if (ints[0]==i) return false;
                        if (ints[1]==j) return false;
                        if (ints[0]/3==i/3&&ints[1]/3==j/3)return false;
                    }
                    list.add(new int[]{i,j});
                }else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    map.put(a, list);
                }
            }
        }
        return true;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        return findDuplicateSubtrees(root, result, set, queue);
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root, List<TreeNode> result, Set<String> set, Queue<TreeNode> queue){
        TreeNode node = root;
        queue.add(node);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current.val==-1){}
            stringBuilder.append(current.val).append("|");

        }
        return null;
    }


}
