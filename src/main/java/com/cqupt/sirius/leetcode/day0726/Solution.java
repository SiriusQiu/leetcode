package com.cqupt.sirius.leetcode.day0726;

import sun.misc.Unsafe;

public class Solution {
    static final Unsafe unsafe= Unsafe.getUnsafe ();
    public static void main(String[] args)   {
        unsafe.allocateMemory(100);

    }

    static class RunnableA implements Runnable{


        @Override
        public void run()  {
            while (true);
        }
    }
    static class RunnableB implements Runnable{



        @Override
        public void run()  {

        }
    }
}
