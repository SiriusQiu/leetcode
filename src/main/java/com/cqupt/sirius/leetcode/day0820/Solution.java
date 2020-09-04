package com.cqupt.sirius.leetcode.day0820;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board==null||board.length == 0 || board[0].length==0) return new char[0][0];
        if (click[0]>=board.length||click[1]>=board[0].length) return board;
        char c = board[click[0]][click[1]];
        if (c=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }else if (c=='E'){
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(click);
            board[click[0]][click[1]]='0';
            while (!queue.isEmpty()){
                int[] current = queue.poll();
                LinkedList<int[]> collection = new LinkedList<>();
                int count = 0;
                //检查上方的元素，i-1
                if (current[0]>0&&check(collection,board[current[0]-1][current[1]], current[0]-1, current[1],board)) count++;
                //检查左边的元素，j-1
                if (current[1]>0&&check(collection,board[current[0]][current[1]-1], current[0], current[1]-1,board)) count++;
                //检查左上方的元素
                if (current[0]>0&&current[1]>0&&check(collection,board[current[0]-1][current[1]-1], current[0]-1, current[1]-1,board)) count++;
                //检查下方的元素
                if (current[0]<board.length-1&&check(collection,board[current[0]+1][current[1]], current[0]+1, current[1],board)) count++;
                //检查右方的元素
                if (current[1]<board[0].length-1&&check(collection,board[current[0]][current[1]+1], current[0], current[1]+1,board)) count++;
                //检查右下方的元素
                if (current[0]<board.length-1&&current[1]<board[0].length-1&&check(collection,board[current[0]+1][current[1]+1], current[0]+1, current[1]+1,board)) count++;
                //检查右上方的元素
                if (current[0]>0&&current[1]<board[0].length-1&&check(collection,board[current[0]-1][current[1]+1], current[0]-1, current[1]+1,board)) count++;
                //检查左下方的元素
                if (current[1]>0&&current[0]<board.length-1&&check(collection,board[current[0]+1][current[1]-1], current[0]+1, current[1]-1,board)) count++;
                board[current[0]][current[1]] = count==0?'B':(char)(count+'0');
                if (count==0){
                    for (int[] index : collection){
                        board[index[0]][index[1]] = '0';
                        queue.add(index);
                    }
                }
            }

        }
        return board;
    }
    public boolean check(LinkedList<int[]> queue, char c, int i, int j,char[][] board){
        if (c=='M') return true;
        if (c=='E') {
            queue.add(new int[]{i,j});
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = new int[]{3,0};
        board = solution.updateBoard(board,click);
        for(char[] row : board){
            for (char c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
