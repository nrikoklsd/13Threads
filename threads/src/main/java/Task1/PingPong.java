package Task1;

public class PingPong {

    static volatile int  counter = 0;
    int max = 10;

    public static void main(String[] args) {
        PingPong pp = new PingPong();
        start(pp, "Ping");
        start(pp, "\tPong");
    }

    static void start(PingPong pp, String msg) {

            new Thread(() -> {
                synchronized (pp) {
                    while (pp.counter++ < pp.max) {

                        System.out.println(msg + pp.counter);
                        pp.notify();
                        try {
                            if(pp.counter < pp.max)
                            pp.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
//                    System.out.println(msg+"in");

                }


            },"pi").start();
//        System.out.println(msg+"after");
        }
    }
