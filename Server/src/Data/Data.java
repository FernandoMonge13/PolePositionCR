package Data;

import Data.Balas.Balas;
import Data.Players.Player;
import java.util.LinkedList;
import java.util.Objects;

public class Data {

    LinkedList<Player> players;
    LinkedList<Objects> objects;
    LinkedList<Balas> balas;

    public Data() {
        players = new LinkedList<>();
        objects = new LinkedList<>();
        balas = new LinkedList<>();
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public void setObjects(LinkedList<Objects> objects) {
        this.objects = objects;
    }

    public void setBalas(LinkedList<Balas> balas) {
        this.balas = balas;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Objects> getObjects() {
        return objects;
    }

    public LinkedList<Balas> getBalas() {
        return balas;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addObject(Objects object) {
        objects.add(object);
    }

    public void addMessage(Balas bala) {
        balas.add(bala);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void removeObject(Objects object) {
        objects.remove(object);
    }

    public void removeMessage(Balas bala) {
        balas.remove(bala);
    }

    public void clearPlayers() {
        players.clear();
    }

    public void clearObjects() {
        objects.clear();
    }

    public void clearBalas() {
        balas.clear();
    }

    public void clear() {
        clearPlayers();
        clearObjects();
        clearBalas();
    }
}
