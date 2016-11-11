package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1CustomSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {

            Socket clientSocket = serverSocket.accept();
            ConnectFromClient connectFromClient = new ConnectFromClient(clientSocket);
            connectFromClient.start();
            //Scanner scanner = new Scanner(System.in);
        }
    }
}

class ConnectFromClient extends Thread {
    Socket clientSocket;
    int i = 0;

    public ConnectFromClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.println("hello from server");
        printWriter.flush();
        String msqFromClient;
        try {
            while (!"stop".equals(msqFromClient = reader.readLine())) {
                System.out.println("msq from client= " + msqFromClient);
                String serverMsq = String.valueOf(i++);
                printWriter.println(serverMsq);
                printWriter.flush();
                sleep(100);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}