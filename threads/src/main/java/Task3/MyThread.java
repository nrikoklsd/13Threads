package Task3;

public class MyThread implements Runnable{
    private final int threadPosition;
    private static volatile int count;

    @Override
    public void run() {
        synchronized (MyThread.class) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //count = count + 1;
            count++;
            System.out.println("count is : "+count+"fibonacci"+makeFibonacci(count));
            System.out.println(Thread.currentThread().toString());
        }
    }
    public int getCount() {
        return count;
    }

    public MyThread(int threadPosition) {
        super();
        this.threadPosition = threadPosition;
    }

//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().toString());
//    }
    public  int makeFibonacci(int count){
        int n = count, t1 = 0, t2 = 1;
        System.out.print("Element " + n + " = ");
        for (int i = 1; i <= n; ++i)
        {
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        System.out.print(t1 +" :");
        return t1;
    }
}