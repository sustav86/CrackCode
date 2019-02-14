package com.sustav.chapter1;

import java.util.Random;

public class Main1_2 {
    public static void main(String[] args) {
        System.out.println(reverse("abcd "));
        reverse(null);

        boolean choise;
        do {
            choise = checkChoise();
            System.out.println("choise = " + choise);
        }while (choise);
    }

    private static boolean checkChoise() {
        Random random = new Random();
        return random.nextInt(10) != 2;
    }

    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) return stringBuilder.toString();
        for (int i = str.length() - 1; i >= 0; i--) {
//            System.out.println(str.charAt(i));
//            System.out.println(str.codePointAt(i));
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }
}
