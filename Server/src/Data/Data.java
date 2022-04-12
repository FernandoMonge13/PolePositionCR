package Data;

import Data.Objects.Objetos;
import Data.Players.Player;
//import LinkedList.LinkedList;
import java.util.LinkedList;

import java.util.Objects;

public class Data {
    LinkedList<Player> players;
    LinkedList<Objetos> objects;

    /**
     * Contructor de la clase Data
     */
    public Data() {
        players = new LinkedList<Player>();
        objects = new LinkedList<Objetos>();
    }

    /**
     * Permite definir una lista de jugadores
     * @param players
     */
    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    /**
     * Permite definir una lista de objetos
     * @param objects
     */
    public void setObjects(LinkedList<Objetos> objects) {
        this.objects = objects;
    }

    /**
     * Permite obtener la lista de jugadores
     * @return
     */
    public LinkedList<Player> getPlayers() {
        return players;
    }

    /**
     * Permite obtener la lista de objetos
     * @return
     */
    public LinkedList<Objetos> getObjects() {
        return objects;
    }

    /**
     * Permite agregar un jugador a la lista de jugadores
     * @param player
     */
    public void addPlayer(Player player) {

        players.add(player);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setId(i+1);
        }

    }

    /**
     * Permite agregar un objeto a la lista de objetos
     * @param object
     */
    public void addObject(Objetos object) {
        objects.add(object);
    }

    /**
     * Permite eliminar un jugador de la lista de jugadores
     * @param player
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * Permite eliminar un objeto de la lista de objetos
     * @param object
     */
    public void removeObject(Objects object) {
        objects.remove(object);
    }

    /**
     * Permite limpiar la lista de jugadores
     */
    public void clearPlayers() {
        players.clear();
    }

    /**
     * Permite limpiar la lista de objetos
     */
    public void clearObjects() {
        objects.clear();
    }

    /**
     * Permite limpiar las listas de jugadores y objetos
     */
    public void clear() {
        clearPlayers();
        clearObjects();
    }

    /**
     * Permite actualizar la información almacenada de un jugador
     * @param playerReceived
     */
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

    /**
     * Intenta actualizar la información del carro que posee un jugador de acuerdo a su id y el carro que se recibe, en caso de no estar disponible, le asigna uno nuevo
     * @param id
     * @param carId
     */
    public void tryToSetCarById(Integer id, Integer carId){
        LinkedList<Integer> cars = new LinkedList<Integer>();
        LinkedList<Integer> carsNo = new LinkedList<Integer>();

        for (int i = 0; i < players.size(); i++) {
            cars.add(players.get(i).getCarro());
        }

        for (int i = 1; i < 5; i++) {
            if(!cars.contains(i)){
                carsNo.add(i);
            }
        }


        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                if (players.get(i).getCarro()==0 && !cars.contains(carId)) {
                    players.get(i).setCarro(carId);
                } else if(players.get(i).getCarro()==0 && cars.contains(carId) && (carsNo.size() != 0)){
                        players.get(i).setCarro(carsNo.get(0));
                        carsNo.remove(0);
                }else{
                    System.out.println("No se pueden agregar más jugadores Man");
                }
            }
        }
    }

    /**
     * Indica en la lista de jugadores que el jugador está listo para iniciar
     * @param id
     */
    public void tryToStartById(Integer id){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                players.get(i).setStartGame(true);
            }
        }
    }

    /**
     * Retorna la cantidad de jugadores que se encuentran listos para iniciar el juego
     * @return count
     */
    public Integer startedGame(){

        int count = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isStartGame()) {
                count++;
            }
        }

        return count;
    }

    /**
     * Retorna el jugaddor que posee el id que se recibe
     * @param id
     * @return player.get(i) si existe, null si no existe
     */
    public Player getPlayerById(Integer id){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                return players.get(i);
            }
        }
        return null;
    }

    /**
     * Actualiza la lista de objetos con los objetos que se reciben
     * @param objectListReceived
     */
    public void updateObjects(Objetos objectListReceived[]){
        for (int i = 0; i < objectListReceived.length; i++) {
            if (objectListReceived[i].getId().equals(objects.get(i).getId())) {
                objects.get(i).setPosX(objectListReceived[i].getPosX());
                objects.get(i).setPosY(objectListReceived[i].getPosY());
                break;
            }
        }
    }

    /**
     * Actualiza la lista de objetos y de jugadores con los objetos y jugadores que se reciben que se reciben
     * @param playerReceived
     * @param objectListReceived
     */
    public void update(Player playerReceived, Objetos objectListReceived[]){
        updatePlayers(playerReceived);
        updateObjects(objectListReceived);
    }
}


