package Json;


import Data.Data;
import Data.Players.Player;
import com.google.gson.Gson;

import java.text.ParseException;

public class JsonAnalizador {
    /**
     * Constructor de la clase JsonAnalizador
     */
    public JsonAnalizador() {}

    /**
     * Analiza un string en formato JSON y lo convierte en un objeto de tipo Player
     * @param json String en formato JSON
     * @return Objeto de tipo Player
     */
    public Player JsonReading(String json) {
        Gson gson = new Gson();
        Player player = (Player)gson.fromJson(JsonParser(json), Player.class);
        return player;
    }

    /**
     * Crea un json a partir del objeto que se le de al metodo
     * @param object
     * @return json en formato String
     * @throws ParseException
     */
    public String JsonWritting (Object object) throws ParseException {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    /**
     * Recibe un string en formato JSON y le da un formato entendible para Gson
     * @param jsonR
     * @return
     */
    public String JsonParser(String jsonR){
        String aux =jsonR.replaceAll("\"", "");
        aux=aux.replace("id", "\"id\"");
        aux=aux.replace("puntos", "\"puntos\"");
        aux=aux.replace("vidas", "\"vidas\"");
        aux=aux.replace("posX", "\"posX\"");
        aux=aux.replace("posY", "\"posY\"");
        aux=aux.replace("v\"id\"as", "\"vidas\"");
        aux=aux.replace(" ","");
        aux=aux.replace("   ","");
        aux=aux.replace("\n","");


        System.out.println(aux);


        return aux;
    }
}