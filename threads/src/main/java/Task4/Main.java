package Task4;

import Task3.Fibonacci;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);


    public static void main(String args[]){
        Fibonacci fibonacci = new Fibonacci();
        List<MyThread> list =new LinkedList<>();
        for (int i=1; i<11; i++) {
            list.add(new MyThread(i));
        }

        try {
            Main.fixedExecutorService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Main.fixedExecutorService.shutdown();




    }
}
