package com.sustav.chapter1;

public class Main1_1 {
    public static void main(String[] args) {
        System.out.println(isUnique("asdfghjkk"));
    }

    private static boolean isUnique(String str) {
        boolean[] buffer = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int i1 = str.codePointAt(i);
            System.out.println("Code point of " + str.charAt(i) + ", code point = " + i1);
            if (buffer[i1]) return false;
            buffer[i1] = true;
        }
        return true;
    }
}
