package Task1;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

//First realization
public class Game {

    private static final Object object = new Object();
    private static volatile int temp = 0;

    private void show() throws InterruptedException {
        System.out.println("Task1.Game ping pong");
        Thread thread1 = new Thread(() -> {
            synchronized (object) {
                while (temp <= 10) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ping");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("    .");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("     .");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("      .");
                    temp++;
                    object.notify();
                }

            }

        }, "ping");

        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                while (temp <= 10) {
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("        pong");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("      .");

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("     .");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("    .");
                    temp++;
                }
            }
        }, "pong");



        System.out.println("before start 1");
        thread1.start();
        System.out.println("before start 2");
        thread2.start();

//        System.out.println("before join 1");
//        thread1.join();
//        System.out.println("before join 2");
//        thread2.join();



    }

    public static void main(String[] args) throws InterruptedException {
        new Game().show();




    }

}