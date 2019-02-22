package Task7;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream  input  = new PipedInputStream(output);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start pipe1");
                    output.write("Message to pipe!".getBytes());
                    output.close();
                } catch (IOException e) {
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start pipe2");
                    int data = input.read();
                    while(data != -1){
                        System.out.print((char) data);
                        data = input.read();
                    }
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}