package Data;

import Data.Balas.Balas;
import Data.Objects.Objetos;
import Data.Players.Player;
import java.util.LinkedList;
import java.util.Objects;

public class Data {

    LinkedList<Player> players;
    LinkedList<Objetos> objects;
    LinkedList<Balas> balas;

    public Data() {
        players = new LinkedList<>();
        objects = new LinkedList<>();
        balas = new LinkedList<>();
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public void setObjects(LinkedList<Objetos> objects) {
        this.objects = objects;
    }

    public void setBalas(LinkedList<Balas> balas) {
        this.balas = balas;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Objetos> getObjects() {
        return objects;
    }

    public LinkedList<Balas> getBalas() {
        return balas;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addObject(Objetos object) {
        objects.add(object);
    }

    public void addBalas(Balas bala) {
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

    public void updateBalas(Balas balaListReceived[]){
        for (int i = 0; i < balaListReceived.length; i++) {
            if (balaListReceived[i].getId().equals(balas.get(i).getId())) {
                balas.get(i).setPosX(balaListReceived[i].getPosX());
                balas.get(i).setPosY(balaListReceived[i].getPosY());
                balas.get(i).setVelocidad(balaListReceived[i].getVelocidad());

                break;
            }
        }
    }

    public void update(Player playerListReceived[], Objetos objectListReceived[], Balas balaListReceived[]){
        updatePlayers(playerListReceived);
        updateObjects(objectListReceived);
        updateBalas(balaListReceived);
    }
}

