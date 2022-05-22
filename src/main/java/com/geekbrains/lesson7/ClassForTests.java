package com.geekbrains.lesson7;

public class ClassForTests {

    @BeforeSuite
    private void BeforeSuite() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    private void AfterSuite() {
        System.out.println("AfterSuite");
    }

    @Test(priority = 1)
    private void Test1() {
        System.out.println("Test1");
    }

    @Test
    private void Test2() {
        System.out.println("Test2");
    }

    @Test
    private void Test3() {
        System.out.println("Test3");
    }

    @Test(priority = 10)
    private void Test4() {
        System.out.println("Test4");
    }
}
