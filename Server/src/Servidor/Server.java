package Servidor;

import Data.Data;
import Data.Players.Player;
import Json.JsonAnalizador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;

public class Server {

    private Data data = new Data();
    private JsonAnalizador json = new JsonAnalizador();

    private String getString(DataInputStream inputStream) throws IOException {
        Character aux;
        String inputString = "";
        do{
            aux = (char)inputStream.read();
            inputString += aux;

        }while(aux!='}');

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

                System.out.println(this.getString(inputStream));
                outputStream.println("Hola desde el Servidor");



//                Player player = new Player();
//                player.setPosX(1);
//                player.setPosY(2);
//                data.addPlayer(player);
//                json.JsonWritting(data);

                System.out.println(json.JsonWritting(data));

//                outputStream.writeUTF("Hola cliente " + nombreCliente + "!\n");
//                ServerThread hilo = new ServerThread(inputStream, outputStream, nombreCliente);
//                hilo.start();
//
//                System.out.println("Cliente conectado: " + nombreCliente);


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
