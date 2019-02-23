package Task3;

import Task2.ThreeThreadsOrderedLockLess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fibonacci {

    private ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);


    public static void main(String args[]){
        Fibonacci fibonacci = new Fibonacci();
        for (int i=1; i<11; i++) {
            fibonacci.fixedExecutorService.submit(new MyThread(i));
        }

        fibonacci.fixedExecutorService.shutdown();




    }

}
