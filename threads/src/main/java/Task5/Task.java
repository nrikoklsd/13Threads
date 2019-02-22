package Task5;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Task implements Runnable{

    private long pause;

    public Task(long pause) {
        this.pause = pause;
    }

    @Override
    public void run() {
        System.out.println(pause+" "+ LocalTime.now()+Thread.currentThread().getName());



    }
}
