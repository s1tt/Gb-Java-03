package com.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    private Object[] arr;

    public Task2(Object[] arr) {
        this.arr = arr;
    }

    public static<T> ArrayList<T> swapToArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
