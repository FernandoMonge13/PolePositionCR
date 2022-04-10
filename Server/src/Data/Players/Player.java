package Data.Players;

public class Player {
    public Integer id = 0;
    public Integer puntos;
    public Integer vidas;
    public Integer posX, posY;
    public Integer posBalaX, posBalaY;

    public boolean startGame = false;

    public Integer carro = 0;

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

    public Integer getPosBalaX() {
        return posBalaX;
    }

    public void setPosBalaX(Integer posBalaX) {
        this.posBalaX = posBalaX;
    }

    public Integer getPosBalaY() {
        return posBalaY;
    }

    public void setPosBalaY(Integer posBalaY) {
        this.posBalaY = posBalaY;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public Integer getCarro() {
        return carro;
    }

    public void setCarro(Integer carro) {
        this.carro = carro;
    }
}


