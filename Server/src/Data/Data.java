package Data;

import Data.Balas.Balas;
import Data.Objects.Objetos;
import Data.Players.Player;
import java.util.LinkedList;
import java.util.Objects;

public class Data {

    LinkedList<Player> players;
    LinkedList<Objetos> objects;

    public Data() {
        players = new LinkedList<>();
        objects = new LinkedList<>();
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public void setObjects(LinkedList<Objetos> objects) {
        this.objects = objects;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Objetos> getObjects() {
        return objects;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addObject(Objetos object) {
        objects.add(object);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void removeObject(Objects object) {
        objects.remove(object);
    }

    public void clearPlayers() {
        players.clear();
    }

    public void clearObjects() {
        objects.clear();
    }

    public void clear() {
        clearPlayers();
        clearObjects();
    }

    public void updatePlayers(Player playerListReceived[]){
        for (int i = 0; i < playerListReceived.length; i++) {
            if (playerListReceived[i].getId().equals(players.get(i).getId())) {

                players.get(i).setPosX(playerListReceived[i].getPosX());
                players.get(i).setPosY(playerListReceived[i].getPosY());
                players.get(i).setVelocidad(playerListReceived[i].getVelocidad());
                players.get(i).setVidas(playerListReceived[i].getVidas());
                players.get(i).setPuntos(playerListReceived[i].getPuntos());
                break;
            }
        }
    }

    public void updateObjects(Objetos objectListReceived[]){
        for (int i = 0; i < objectListReceived.length; i++) {
            if (objectListReceived[i].getId().equals(objects.get(i).getId())) {
                objects.get(i).setPosX(objectListReceived[i].getPosX());
                objects.get(i).setPosY(objectListReceived[i].getPosY());
                break;
            }
        }
    }

    public void update(Player playerListReceived[], Objetos objectListReceived[], Balas balaListReceived[]){
        updatePlayers(playerListReceived);
        updateObjects(objectListReceived);
    }
}

