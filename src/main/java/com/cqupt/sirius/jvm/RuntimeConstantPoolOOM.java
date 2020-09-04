package com.cqupt.sirius.jvm;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder().append("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}
