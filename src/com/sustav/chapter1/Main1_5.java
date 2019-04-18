package com.sustav.chapter1;

public class Main1_5 {

    public static void main(String[] args) {
        String str = "String and String";
//        String string = replaceSpace(str);
//        System.out.println(string);
        System.out.println(replaceFun(str.toCharArray(), str.length()));
//        System.out.println(str);
    }

    private static String replaceSpace(String string) {

        StringBuilder stringBuffer = new StringBuilder();

        for (char currentChar : string.toCharArray()) {
            if (currentChar == 32) {
                stringBuffer.append((char)37);
                stringBuffer.append((char)50);
                stringBuffer.append((char)48);
            }else {
                stringBuffer.append(currentChar);
            }
        }

        return stringBuffer.toString();
    }

    public static char[] replaceFun(char[] str, int length) {
        int spaceCount = 0, newLength, i = 0;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + spaceCount * 2;
        char[] newStr = new char[newLength];
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                newStr[newLength - 1] = '0';
                newStr[newLength - 2] = '2';
                newStr[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                newStr[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }

        return newStr;
    }


}
