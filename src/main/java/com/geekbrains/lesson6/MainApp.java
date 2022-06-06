package com.geekbrains.lesson6;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(task1(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, 4)));
        System.out.println(task2(new int[]{1, 4, 1, 1, 4}, 1, 4));
    }

    public static int[] task1(int[] arr, int elementToSearch) {
        int indexToSearch = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == elementToSearch) {
                indexToSearch = i;
                break;
            }
        }
        if (indexToSearch == -1) {
            throw new RuntimeException("Элемент: " + elementToSearch + " не найден в массиве!");
        } else {
            int[] newArr = new int[(arr.length - 1) - indexToSearch];
            System.arraycopy(arr, (indexToSearch + 1), newArr, 0, ((arr.length - 1) - indexToSearch));
            return newArr;
        }
    }

    public static boolean task2(int[] arr, int one, int four) {
        boolean res1 = false;
        boolean res2 = false;

        for (int value : arr) {
            if (value == one)
                res1 = true;
            else if (value == four)
                res2 = true;
            else
                return false;
        }
        return res1 && res2;
    }
}
