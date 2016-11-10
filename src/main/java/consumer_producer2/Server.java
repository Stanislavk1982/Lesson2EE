package consumer_producer2;

import java.util.concurrent.BlockingQueue;

public class Server extends Thread {
    private BlockingQueue<Integer> bucket;

    public Server(BlockingQueue<Integer> bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                bucket.put(i);
                System.out.println("server2:" + i);
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
