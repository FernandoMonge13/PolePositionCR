package Json;


import Data.Data;
import Data.Players.Player;
import com.google.gson.Gson;

import java.text.ParseException;

public class JsonAnalizador {
    public JsonAnalizador() {

    }

    public Player JsonReading(String json) {
        Gson gson = new Gson();

        Player player = (Player)gson.fromJson(JsonParser(json), Player.class);
        return player;
    }


    public String JsonWritting (Object object) throws ParseException {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

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