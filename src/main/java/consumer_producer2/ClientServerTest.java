package consumer_producer2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ClientServerTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> bucket  =new ArrayBlockingQueue<Integer>(10);
        Client client = new Client(bucket);
        Server server = new Server(bucket);
        client.start();
        server.start();

    }
}
