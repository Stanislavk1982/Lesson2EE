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
        Socket clientSocket = serverSocket.accept();

        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

        printWriter.println("hello from server");
        printWriter.flush();
        String msqFromClient;
        while (!"stop".equals(msqFromClient = reader.readLine())) {
            System.out.println("msq from client= " + msqFromClient);
            String serverMsq = scanner.nextLine();
            printWriter.println(serverMsq);
            printWriter.flush();
        }
    }
}
