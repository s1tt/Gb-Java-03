package com.geekbrains.lesson4;

public class Main {
    private static final Object mon = new Object();
    private static char aChar = 'A';

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (aChar != 'A'){
                            mon.wait();
                        }
                        System.out.print("A");
                        aChar = 'B';
                        mon.notifyAll();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (aChar != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        aChar = 'C';
                        mon.notifyAll();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (aChar != 'C') {
                            mon.wait();
                        }
                        System.out.print("C");
                        aChar = 'A';
                        mon.notifyAll();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
