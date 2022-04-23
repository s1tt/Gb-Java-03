package com.geekbrains.lesson1;

public class Task1 {
    private Object[] obj;
    private int dest;
    private int first;

    public Task1(Object[] obj, int dest, int first) {
        this.obj = obj;
        this.dest = dest;
        this.first = first;
    }

    public static<T> void swapElements(T[] obj, int firstIndex, int secondIndex) {
        T tmp = obj[firstIndex];
        obj[firstIndex] = obj[secondIndex];
        obj[secondIndex] = tmp;
    }
}
