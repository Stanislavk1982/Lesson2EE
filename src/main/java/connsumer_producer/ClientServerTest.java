package connsumer_producer;

public class ClientServerTest {
    public static void main(String[] args) {
        Bucket bucket  =new Bucket();
        Client client = new Client(bucket);
        Server server = new Server(bucket);
        client.start();
        server.start();

    }
}
