package Task5;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        System.out.println("enter how many threads do you want=");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(/*scanner.nextInt()*/3);

        for (int i =0; i<5; i++){
            long nazar = (long)(1+new Random().nextInt(5));
            scheduledExecutorService.schedule(new Task(nazar),nazar, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();




    }
}
