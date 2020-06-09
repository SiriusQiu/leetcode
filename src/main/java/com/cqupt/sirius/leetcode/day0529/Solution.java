package com.cqupt.sirius.leetcode.day0529;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Solution {
    Set<State> set = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int z) {
        return canMeasureWater(new State(x,y),z);
    }
    public boolean canMeasureWater(State state, int z){
        if (!set.contains(state)&&state.check(z))return true;
        set.add(state);
        if(state.a!=0){
            State state1 = state.clearX();
            if (!set.contains(state1)&&canMeasureWater(state1,z))return true;
        }
        if(state.b!=0){
            State state2 = state.clearY();
            if (!set.contains(state2)&&canMeasureWater(state2,z))return true;
        }
        if(state.a!=state.x){
            State state3 = state.putX();
            if (!set.contains(state3)&&canMeasureWater(state3,z))return true;
        }
        if(state.b!=state.y){
            State state4 = state.putY();
            if (!set.contains(state4)&&canMeasureWater(state4,z))return true;
        }
        if(state.a!=0&&state.b!=state.y){
            State state5 = state.x2y();
            if (!set.contains(state5)&&canMeasureWater(state5,z))return true;
        }
        if(state.b!=0&&state.a!=state.x){
            State state6 = state.y2x();
            if (!set.contains(state6)&&canMeasureWater(state6,z))return true;
        }
        return false;
    }
    private static class State {
        int x;
        int y;
        int a;
        int b;
        State(int x, int y){
            this.x = x;
            this.y = y;
            this.a = 0;
            this.b = 0;
        }
        State clearX(){
            State result = new State(x,y);
            result.a = 0;
            result.b = b;
            return result;
        }
        State clearY(){
            State result = new State(x,y);
            result.a = a;
            result.b = 0;
            return result;
        }
        State putX(){
            State result = new State(x,y);
            result.a = x;
            result.b = b;
            return  result;
        }
        State putY(){
            State result = new State(x,y);
            result.a = a;
            result.b = y;
            return  result;
        }
        State x2y(){
            State result = new State(x,y);
            int canBePut = y-b;
            if(canBePut>a){
                result.a = 0;
                result.b = b+a;
            }else {
                result.a = a-canBePut;
                result.b = b+canBePut;
            }
            return  result;
        }
        State y2x(){
            State result = new State(x,y);
            int canBePut = x-a;
            if(canBePut>b){
                result.a = a+b;
                result.b = 0;
            }else {
                result.a = a+canBePut;
                result.b = b-canBePut;
            }
            return  result;
        }
        boolean check(int z){
            return a==z||b==z||(a+b)==z;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj==this){
                return true;
            }
            if (obj==null||getClass()!=obj.getClass())
                return false;
            State state = (State) obj;
            return state.a==a && state.b==b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j]==1){
                    int sum = dfsMaxAreaOfIsland(grid, i, j);
                    max = sum>max?sum:max;
                }
            }
        }
        return max;
    }
    public int dfsMaxAreaOfIsland(int[][] grid, int x, int y){
        if (grid[x][y]==0) return 0;
        int sum = 0;
        if (grid[x][y]==1){
            sum++;
            grid[x][y] = 2;
        }
        if (x-1>=0&&grid[x-1][y]!=2) sum+=dfsMaxAreaOfIsland(grid, x-1,y);
        if (y-1>=0&&grid[x][y-1]!=2) sum+=dfsMaxAreaOfIsland(grid, x,y-1);
        if (x+1<grid.length&&grid[x+1][y]!=2) sum+=dfsMaxAreaOfIsland(grid, x+1, y);
        if (y+1<grid[0].length&&grid[x][y+1]!=2) sum+=dfsMaxAreaOfIsland(grid, x, y+1);
        return sum;
    }


    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        retry:
        for (String word : words){
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String string = iterator.next();
                if (word.endsWith(string)){
                    iterator.remove();
                    set.add(word);
                    continue retry;
                }else if (string.endsWith(word)){
                    continue retry;
                }
            }
            set.add(word);
        }
        Iterator<String> iterator = set.iterator();
        int sum = 0;
        while (iterator.hasNext()){
            sum+=iterator.next().length()+1;
        }
        return sum;
    }

    public String gcdOfStrings(String str1, String str2) {
        String temp = str1;
        if (str1.length() < str2.length()){
            str1 = str2;
            str2 = temp;
        }
        if (str1.length()==0||str2.length()==0) return "";
        for (int i = 0; i < str2.length()-1; i++){
            String prefix = str2.substring(0,str2.length()-i);
            if (str2.length()%prefix.length()==0){
                int count = str2.length()/prefix.length();
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < count; j++){
                    stringBuffer.append(prefix);
                }
                if (stringBuffer.toString().equals(str2)){
                    count = str1.length()/prefix.length();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int j = 0; j < count; j++){
                        stringBuffer2.append(prefix);
                    }
                    if (stringBuffer2.toString().equals(str1)) return prefix;
                }
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC","ABC"));
    }
}
