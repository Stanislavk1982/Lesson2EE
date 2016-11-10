package connsumer_producer;

public class Client extends Thread {

    private Bucket bucket;

    public Client(Bucket bucket) {
        this.bucket = bucket;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int number = bucket.getNumber();
                System.out.println("client: "+ number);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
