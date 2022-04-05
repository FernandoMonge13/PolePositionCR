package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket;

            System.out.print("Servidor iniciado...\n");

            while (true) {
                socket = serverSocket.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                outputStream.writeUTF("Indica tu nombre: ");
                String nombreCliente = inputStream.readUTF();

                ServerThread hilo = new ServerThread(inputStream, outputStream, nombreCliente);
                hilo.start();

                System.out.println("Cliente conectado: " + nombreCliente);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
