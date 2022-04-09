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
        Player player = gson.fromJson(json, Player.class);
        return player;
    }


    public String JsonWritting (Object object) throws ParseException {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }
}