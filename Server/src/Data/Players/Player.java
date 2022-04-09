package Data.Players;

import Data.Balas.Balas;

public class Player {
    private Integer id = 0;
    private Integer puntos;
    private Integer vidas;
    private Integer posX, posY;

    private Balas balas;

    public Player() {
        this.vidas = 3;
        this.puntos = 0;
    }

    public Player(Integer id) {
        this.id = id;
        this.vidas = 3;
        this.puntos = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Integer getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Balas getBalas() {
        return balas;
    }

    public void setBalas(Balas balas) {
        this.balas = balas;
    }
}


