import Data.Data;
import Data.Objects.Hueco;
import Data.Objects.Turbo;
import Data.Objects.Vida;
import Data.Players.Player;
import Json.JsonAnalizador;
import Servidor.Server;
import org.json.simple.parser.ParseException;

public class main {
    public static void main(String[] args) throws ParseException, java.text.ParseException {

//       Server myserver = new Server();
//       myserver.Server(4);



        Data data = new Data();
        JsonAnalizador json = new JsonAnalizador();
        Player player = new Player();
        player.setPosX(1);
        player.setPosY(2);

        Player player2 = new Player();
        player2.setPosX(3);
        player2.setPosY(4);

        data.addObject(new Vida(1,1));
        data.addObject(new Hueco(2,2));
        data.addObject(new Turbo(3,3));

        data.addPlayer(player);
        data.addPlayer(player2);

        System.out.println(json.JsonWritting(data));

    }
}

