package Servidor;

import Data.Balas.Balas;
import Data.Data;
import Data.Objects.Hueco;
import Data.Objects.Turbo;
import Data.Objects.Vida;
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
        int a;
        while ((a=inputStream.read())!= 125){
            inputString +=(char) a;
        }
        inputString+="}";

        System.out.println(inputString);
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

//                System.out.println(this.getString(inputStream));





                String inputString = this.getString(inputStream);

                if(inputString.equals("{nuevo Jugador}")){
                    data.addPlayer(new Player());
                    outputStream.println((data.getPlayers().getLast().getId()));

                } else {

                    System.out.println("GG");

                    Player player = new Player();
                    player.setPosX(1);
                    player.setPosY(2);
                    player.setBalas(new Balas(1,1,3));

                    Player player2 = new Player();
                    player2.setPosX(3);
                    player2.setPosY(4);
                    player2.setBalas(new Balas(2,2,6));

                    data.addPlayer(player);
                    data.addPlayer(player2);

                    data.addObject(new Hueco(1,1));
                    data.addObject(new Turbo(2,2));
                    data.addObject(new Vida(3,3));

//                    json.JsonParser(inputString);
//

//
//                    Player playerReceived = json.JsonReading(this.getString(inputStream));
//                    data.updatePlayers(playerReceived);
                    outputStream.println(json.JsonWritting(data));
                    System.out.println(json.JsonWritting(data));
                }



                //System.out.println("Información enviada:\n" + json.JsonWritting(data));

//                Player player = new Player();
//                player.setPosX(1);
//                player.setPosY(2);
//                data.addPlayer(player);
//                json.JsonWritting(data);

//                System.out.println(json.JsonWritting(data));

//                outputStream.writeUTF("Hola cliente " + nombreCliente + "!\n");
//                ServerThread hilo = new ServerThread(inputStream, outputStream, nombreCliente);
//                hilo.start();
//
//                System.out.println("Cliente conectado: " + nombreCliente);


            }

        } catch (IOException e) {
            e.printStackTrace();} catch (ParseException e) {
            e.printStackTrace();
        }
//         catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

}
