package connsumer_producer;

public class Server extends Thread {
    private Bucket bucket;

    public Server(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                bucket.setNumber(i);                System.out.println("server:" + i);
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
