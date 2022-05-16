package com.geekbrains.lesson1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Task1
        Object[] test = {1, "ABC", new Main()};
        Task1.swapElements(test, 0, 1);

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

        //Task2
        ArrayList<Object> newArr = Task2.swapToArrayList(test);
        System.out.println(newArr.get(0));


    }
}
