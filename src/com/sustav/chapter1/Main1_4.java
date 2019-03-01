package com.sustav.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1_4 {
    public static void main(String[] args) {
//        System.out.println(anagram("лунь", "нуль"));
        System.out.println(anagram("rrabcd", "dcbarr"));
//        System.out.println(anagramArray("abcd", "dcba"));
        System.out.println("sfdsfdf".getClass().toString());
    }

    private static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] letters = new int[256];
        int num_unique_chars = 0;
        int num_completed_t = 0;
        char[] s_array = str1.toCharArray();
        for (char c : s_array) {
            if (letters[c] == 0) ++num_unique_chars;
            ++letters[c];
        }
        for (int i = 0; i < str2.length(); i++) {
            int c = str2.charAt(i);
            if (letters[c] == 0) return false;
            --letters[c];
            if (letters[c] == 0) {
                ++num_completed_t;
                if (num_completed_t == num_unique_chars) {
                    return i == str2.length() - 1;
                }
            }

        }

        return false;
    }

    private static boolean anagramArray(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        ArrayList<Integer> letters = new ArrayList<>(256);
        System.out.println(Arrays.toString(letters.toArray()));
        letters.add(2, 56);
        letters.trimToSize();
        System.out.println(Arrays.toString(letters.toArray()));

        return true;
    }
}
