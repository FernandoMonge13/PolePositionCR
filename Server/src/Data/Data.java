package Data;

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
        if (players.size()==0){
            addPlayer(playerReceived);
        }

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

    public void tryToSetCarById(Integer id, Integer carId){
        LinkedList<Integer> cars = new LinkedList<>();

        for (int i = 0; i < players.size(); i++) {
            cars.add(players.get(i).getCarro());
        }


        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                if (players.get(i).getCarro()==0 && !cars.contains(carId)) {
                    players.get(i).setCarro(carId);
                }
            }
        }
    }

    public void tryToStartById(Integer id){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                players.get(i).setStartGame(true);
            }
        }
    }

    public Player getPlayerById(Integer id){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                return players.get(i);
            }
        }
        return null;
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

    public void update(Player playerReceived, Objetos objectListReceived[]){
        updatePlayers(playerReceived);
        updateObjects(objectListReceived);
    }
}

