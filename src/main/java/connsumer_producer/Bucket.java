package connsumer_producer;

public class Bucket {
    private int number;
    private boolean isAvailable;

    synchronized public int getNumber() throws InterruptedException {
        if (!isAvailable) {
            wait();
        }
        isAvailable = false;
        notifyAll();
        return number;
    }

    synchronized public void setNumber(int number) throws InterruptedException {
        if (isAvailable) {
            wait();
        }
        this.number = number;
        isAvailable=true;
        notifyAll();
    }
}
