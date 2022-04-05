package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");

            Socket socket = null;

            socket = new Socket("127.0.0.1", 5000);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String mensagem = inputStream.readUTF();
            System.out.println(mensagem);

            String name = scanner.next();
            outputStream.writeUTF(name);


            ClientThread hilo = new ClientThread(inputStream, outputStream);
            hilo.start();
            hilo.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }



    }

}
