package Data.Players;

public class Player {
    private Integer puntos;
    private Integer vidas;
    private Integer posX, posY;
    private Integer velocidad;

    public Player() {
        this.vidas = 3;
        this.puntos = 0;
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
}


