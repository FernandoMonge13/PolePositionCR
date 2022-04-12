package Servidor;

import Data.Data;
import Data.Objects.Hueco;
import Data.Objects.Turbo;
import Data.Objects.Vida;
import Data.Players.Player;
import Json.JsonAnalizador;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Objects;

public class Server {

    private Data data = new Data();
    private JsonAnalizador json = new JsonAnalizador();

    private String getString(DataInputStream inputStream) throws IOException {
        String inputString = "";
        int a;
        while ((a=inputStream.read())!= 125){
            inputString +=(char) a;
        }
        inputString+="}";

        System.out.println(inputString);
        return inputString;
    }

    public  void Server(Integer cantidadJugadores) {

        if (cantidadJugadores > 4) {
            cantidadJugadores = 4;
        } else if (cantidadJugadores < 2)
            cantidadJugadores = 2;

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket;

            System.out.print("Servidor iniciado...\n");

//            data.addPlayer(new Player());;




            while (true) {
                socket = serverSocket.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                PrintStream outputStream = new PrintStream(socket.getOutputStream());

                String inputString = this.getString(inputStream);

                if(inputString.contains("nuevo Jugador")){
                    data.addPlayer(new Player());
                    outputStream.println((data.getPlayers().getLast().getId()));

                } else if(inputString.contains("PeticionCarro")){
                    char aux = inputString.charAt(15);
                    int id = (int)aux;
                    id -= 96;

//                    Integer id = Integer.parseInt(aux);

                    System.out.println(id);


                    String aux2 = String.valueOf(inputString.charAt(17));
                    Integer car = Integer.parseInt(aux2);

                    data.tryToSetCarById(id, car);

                    System.out.println(data.getPlayerById(id).getCarro());
                    outputStream.println(data.getPlayerById(id).getCarro());
                }

                else if(inputString.contains("Iniciar")){
//                    System.out.println(inputString);
                    Integer id = (Integer.parseInt(String.valueOf(inputString.charAt(8))));
                    data.tryToStartById(id);

                    if(Objects.equals(data.startedGame(), cantidadJugadores)){
                        outputStream.println("1");
                    } else {
                        outputStream.println("0");
                    }


//                    System.out.println(getParsedJsonToSend(json.JsonWritting(data)));

                }else {
                    System.out.println("GG");

//                    Player player = new Player();
//                    player.setPosX(1);
//                    player.setPosY(2);
//
//                    Player player2 = new Player();
//                    player2.setPosX(3);
//                    player2.setPosY(4);
//
//                    data.addPlayer(player);
//                    data.addPlayer(player2);
//
//                    data.addObject(new Hueco(1,1));
//                    data.addObject(new Turbo(2,2));
//                    data.addObject(new Vida(3,3));

//                    json.JsonParser(inputString);
//

//                    System.out.println(json.JsonParser(inputString));
                    Player playerReceived = json.JsonReading(inputString);
                    System.out.println(playerReceived.getId());
                    data.updatePlayers(playerReceived);

                    outputStream.println(getParsedJsonToSend(json.JsonWritting(data)));
                    System.out.println(getParsedJsonToSend(json.JsonWritting(data)));
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
            e.printStackTrace();
        }
         catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getParsedJsonToSend(String jsonToSend){

        String newInfo = jsonToSend.replaceAll("\\{\"id\"", "\"PlayerZ\":{\"id\"");
        newInfo = newInfo.replaceAll("\\{\"posX\"", "\"ObjetoQ\":{\"posX\"");
//        System.out.println(newInfo);

        Integer count = 1, count2 = 1;
        for (int i = 0; i < newInfo.length(); i++) {
            if (newInfo.charAt(i) == 'Z') {
                StringBuilder sb = new StringBuilder(newInfo);
                sb.setCharAt(i, count.toString().charAt(0));
                newInfo = sb.toString();
                count++;
            } else if (newInfo.charAt(i) == 'Q') {
                StringBuilder sb = new StringBuilder(newInfo);
                sb.setCharAt(i, count2.toString().charAt(0)); //Esto indica que la cantidad de objetos puede ser de 1 a 9
                newInfo = sb.toString();
                count2++;
            }
        }
        return newInfo;
    }

}

