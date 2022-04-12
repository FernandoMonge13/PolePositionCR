package Data.Players;

public class Player {
    public Integer id = 0;
    public Integer puntos;
    public Integer vidas;
    public Integer posX, posY;
    public Integer posBalaX=-300, posBalaY=0;
    public boolean startGame = false;
    public Integer carro = 0;

    /**
     * Constructor de la clase Player
     */
    public Player() {
        this.vidas = 3;
        this.puntos = 0;
    }

    /**
     * Constructor de la clase Player que recibe un parametro de tipo Integer
     * @param id id del jugador
     */
    public Player(Integer id) {
        this.id = id;
        this.vidas = 3;
        this.puntos = 0;
    }

    /**
     * Metodo que retorna el id del jugador
     * @return id del jugador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo que modifica el id del jugador
     * @param id id del jugador
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que retorna los puntos del jugador
     * @return puntos del jugador
     */
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * Metodo que modifica los puntos del jugador
     * @param puntos puntos del jugador
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Metodo que retorna las vidas del jugador
     * @return vidas del jugador
     */
    public Integer getVidas() {
        return vidas;
    }

    /**
     * Metodo que modifica las vidas del jugador
     * @param vidas vidas del jugador
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * Metodo que retorna la posicion en x del jugador
     * @return posicion en x del jugador
     */
    public Integer getPosX() {
        return posX;
    }

    /**
     * Metodo que modifica la posicion en x del jugador
     * @param posX posicion en x del jugador
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Metodo que retorna la posicion en y del jugador
     * @return posicion en y del jugador
     */
    public Integer getPosY() {
        return posY;
    }

    /**
     * Metodo que modifica la posicion en y del jugador
     * @param posY posicion en y del jugador
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Metodo que retorna la posicion en x de la bala del jugador
     * @return posicion en x de la bala del jugador
     */
    public Integer getPosBalaX() {
        return posBalaX;
    }

    /**
     * Metodo que modifica la posicion en x de la bala del jugador
     * @param posBalaX posicion en x de la bala del jugador
     */
    public void setPosBalaX(Integer posBalaX) {
        this.posBalaX = posBalaX;
    }

    /**
     * Metodo que retorna la posicion en y de la bala del jugador
     * @return posicion en y de la bala del jugador
     */
    public Integer getPosBalaY() {
        return posBalaY;
    }

    /**
     * Metodo que modifica la posicion en y de la bala del jugador
     * @param posBalaY posicion en y de la bala del jugador
     */
    public void setPosBalaY(Integer posBalaY) {
        this.posBalaY = posBalaY;
    }

    /**
     * Metodo que si el jugador esta en el juego
     * @return carro del jugador
     */
    public boolean isStartGame() {
        return startGame;
    }

    /**
     * Metodo que modifica si el jugador esta en el juego
     * @param startGame carro del jugador
     */
    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }


    /**
     * Metodo que retorna el carro del jugador
     * @return carro del jugador
     */
    public Integer getCarro() {
        return carro;
    }

    /**
     * Metodo que modifica el carro del jugador
     * @param carro carro del jugador
     */
    public void setCarro(Integer carro) {
        this.carro = carro;

        switch (carro) {
            case 1:
                this.posX = 150;
                this.posY = 400;
                break;

            case 2:
                this.posX = 250;
                this.posY = 400;
                break;

            case 3:
                this.posX = 400;
                this.posY = 400;
                break;

            case 4:
                this.posX = 500;
                this.posY = 400;
                break;

        }
    }
}


