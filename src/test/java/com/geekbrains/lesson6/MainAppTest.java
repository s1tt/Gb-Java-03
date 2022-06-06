package com.geekbrains.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainAppTest {
    private MainApp app = new MainApp();

    @ParameterizedTest
    @MethodSource("testTask1")
    public void methodTask1(int[] beforeArr, int[] afterArr) {
        Assertions.assertArrayEquals(afterArr, app.task1(beforeArr, 4));
    }

    public static Stream<Arguments> testTask1() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{}));
        out.add(Arguments.arguments(new int[]{4, 3, 2, 1, 0, -1}, new int[]{3, 2, 1, 0, -1}));
        out.add(Arguments.arguments(new int[]{1, 22, 3, 22, 33, 22, 3, 5, 4, 3, 3, 23, 44}, new int[]{3, 3, 23, 44}));
        return out.stream();
    }

    @Test
    public void methodTask1Exception() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            app.task1(new int[]{1, 55, 3, 444}, 4);
        });
    }

    @ParameterizedTest
    @MethodSource("testTask2")
    public void methodTask2(int[] arr, boolean result) {
        Assertions.assertEquals(result, app.task2(arr, 1, 4));
    }

    public static Stream<Arguments> testTask2() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{1, 22, 3, 22, 33, 22, 3, 5, 4, 3, 3, 23, 44}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 4, 4, 4, 4}, true));
        return out.stream();
    }
}