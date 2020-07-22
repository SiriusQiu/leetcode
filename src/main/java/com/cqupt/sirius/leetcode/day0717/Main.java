package com.cqupt.sirius.leetcode.day0717;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 给定一个模式串S，以及一个模板串P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
 *
 * 模板串P在模式串S中多次作为子串出现。
 *
 * 求出模板串P在模式串S中所有出现的位置的起始下标。
 *
 * 输入格式
 * 第一行输入整数N，表示字符串P的长度。
 *
 * 第二行输入字符串P。
 *
 * 第三行输入整数M，表示字符串S的长度。
 *
 * 第四行输入字符串S。
 *
 * 输出格式
 * 共一行，输出所有出现位置的起始下标（下标从0开始计数），整数之间用空格隔开。
 *
 * 数据范围
 * 1≤N≤105
 * 1≤M≤106
 * 输入样例：
 * 3
 * aba
 * 5
 * ababa
 * 输出样例：
 * 0 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int a = in.nextInt();
        String pattern = in.next();
        int b = in.nextInt();
        String str = in.next();
        indexOf(str, pattern);
    }
    public static void indexOf(String str, String pattern){
        if (pattern==null||pattern.length()==0) {
            System.out.println(-1);
            return;
        };
        char[] strChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int[] next = new int[patternChars.length];
        for (int i = 1, j = 0; i<pattern.length()-1;i++){
            while (j>0&&patternChars[i]!=patternChars[j]) j = next[j];
            if (patternChars[i] == patternChars[j]) j++;
            next[i+1] = j;
        }
        for (int i = 0, j = 0; i<str.length()-1;i++){
            while (j>0&&strChars[i]!=patternChars[j]) j = next[j];
            if (j == patternChars.length-1) {
                System.out.println(i);
                j = next[j];
            };
            if (strChars[i] == patternChars[j]) j++;

        }
    }
}
