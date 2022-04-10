import Data.Data;
import Data.Players.Player;
import Json.JsonAnalizador;
import Servidor.Server;
import org.json.simple.parser.ParseException;

public class main {
    public static void main(String[] args) throws ParseException, java.text.ParseException {

       Server myserver = new Server();
       myserver.Server();



//        Data data = new Data();
//        JsonAnalizador json = new JsonAnalizador();
//        Player player = new Player();
//        player.setPosX(1);
//        player.setPosY(2);
//        player.setBalas(new Balas(1,1,3));
//
//        Player player2 = new Player();
//        player2.setPosX(3);
//        player2.setPosY(4);
//        player2.setBalas(new Balas(2,2,6));
//
//        data.addPlayer(player);
//        data.addPlayer(player2);
//
//        System.out.println(json.JsonWritting(data));

    }
}

