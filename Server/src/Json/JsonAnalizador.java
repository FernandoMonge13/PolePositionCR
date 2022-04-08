package Json;


import Data.Data;
import com.google.gson.Gson;

import java.text.ParseException;

public class JsonAnalizador {
    public JsonAnalizador() {

    }

    public String JsonReading(String json) {



        return json;
    }


    public String JsonWritting (Object object) throws ParseException {

        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }
}