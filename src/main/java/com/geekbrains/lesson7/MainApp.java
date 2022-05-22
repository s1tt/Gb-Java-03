package com.geekbrains.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class classForTests = ClassForTests.class;
        start(classForTests);
    }

    public static boolean start(Class clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method beforeAll = null;
        Method afterAll = null;
        Map<Integer, List<Method>> tests = new HashMap<>();
        for (Method method : clazz.getDeclaredMethods()) {
            BeforeSuite beforeSuite = method.getAnnotation(BeforeSuite.class);
            AfterSuite afterSuite = method.getAnnotation(AfterSuite.class);
            Test test = method.getAnnotation(Test.class);
            if (afterSuite != null) {
                if (afterAll != null) {
                    throw new RuntimeException("There can be only 1 @AfterSuite method");
                } else {
                    afterAll = method;
                }
            }
            if (beforeSuite != null) {
                if (beforeAll != null) {
                    throw new RuntimeException("There can be only 1 @BeforeSuite method");
                } else {
                    beforeAll = method;
                }
            }
            if (test != null) {
                int intPriority = test.priority();
                if (intPriority > 10 || intPriority < 1) {
                    throw new RuntimeException("Method priority must be between 1 and 10");
                }
                List<Method> methods = tests.get(intPriority);
                if (methods == null) {
                    methods = new ArrayList<>();
                }
                methods.add(method);
                tests.put(intPriority, methods);
            }
        }
        Object obj = clazz.getDeclaredConstructor().newInstance();
        if (beforeAll != null) {
            beforeAll.setAccessible(true);
            beforeAll.invoke(obj);
        }

        for (int i = 10; i > 0; i--) {
            List<Method> methods = tests.get(i);
            if (methods != null) {
                for (Method method : methods) {
                    method.setAccessible(true);
                    method.invoke(obj);
                }
            }
        }
        if (afterAll != null) {
            afterAll.setAccessible(true);
            afterAll.invoke(obj);
        }
        return true;
    }

    public static boolean start(String clazz) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        Class cl = Class.forName(clazz);
        return start(cl);
    }
}
