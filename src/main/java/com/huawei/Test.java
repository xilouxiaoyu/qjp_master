package com.huawei;

import java.util.Scanner;

public class Test {
    public static int getCount(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int[] ints = new int[128];
        for (char c : chars) {
            if (c >= 0 && c <= 127) {
                if (ints[(int) c] == 0) {
                    count ++;
                    ints[(int)c] = c;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(getCount(str));
    }
}
