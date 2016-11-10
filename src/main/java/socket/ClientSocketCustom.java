package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketCustom {
    public static void main(String[] args) throws IOException {
        Socket clienScocket = new Socket("192.168.1.129", 9999);

        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clienScocket.getInputStream()));

        PrintWriter printWriter = new PrintWriter(clienScocket.getOutputStream());

        String msqFromServer;
        while (!"stop".equals(msqFromServer = reader.readLine())) {
            System.out.println("msq from server= " + msqFromServer);
            String serverMsq = scanner.nextLine();
            printWriter.println(serverMsq);
            printWriter.flush();
        }
    }

}

