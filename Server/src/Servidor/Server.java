package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private String getString(DataInputStream inputStream) throws IOException {
        Character aux;
        String inputString = "";
        do{
            aux = (char)inputStream.read();
            inputString += aux;

        }while(aux!=' ');

        return inputString;
    }

    public  void Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket;

            System.out.print("Servidor iniciado...\n");

            while (true) {
                socket = serverSocket.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                PrintStream outputStream = new PrintStream(socket.getOutputStream());



//                char res;
//                String finalString = "";
//                do{
//                    res = (char)inputStream.read();
//                    finalString += res;
//
//                }while(res!='p');

                System.out.println(this.getString(inputStream));
                outputStream.println("Holaj");
                System.out.println("Paso");

//                outputStream.writeUTF("Hola cliente " + nombreCliente + "!\n");
//                ServerThread hilo = new ServerThread(inputStream, outputStream, nombreCliente);
//                hilo.start();
//
//                System.out.println("Cliente conectado: " + nombreCliente);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
