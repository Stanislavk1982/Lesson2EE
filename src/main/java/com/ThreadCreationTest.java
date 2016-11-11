package com;

import java.util.concurrent.*;

public class ThreadCreationTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Thread.currentThread().getName());
        new CustomThread("my custom name").start();
        new Thread(new CustomRunnable()).start();


        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> submit = service.submit(new CustomCallable());
        String s = submit.get();
        System.out.println("submit"+s);
        service.shutdown();


    }
}

class CustomCallable implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello from callable thread type";
    }
}

class CustomRunnable implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class CustomThread extends Thread{

    public CustomThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        }
        }

