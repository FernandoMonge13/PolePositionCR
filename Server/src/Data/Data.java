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
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setId(i+1);
        }


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

    public void updatePlayers(Player playerReceived){
        for (int i = 0; i < players.size(); i++) {
            if (playerReceived.getId().equals(players.get(i).getId())) {

                players.get(i).setPosX(playerReceived.getPosX());
                players.get(i).setPosY(playerReceived.getPosY());
                players.get(i).setVidas(playerReceived.getVidas());
                players.get(i).setPuntos(playerReceived.getPuntos());
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

    public void update(Player playerReceived, Objetos objectListReceived[], Balas balaListReceived[]){
        updatePlayers(playerReceived);
        updateObjects(objectListReceived);
    }
}

