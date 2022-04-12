package Data.Objects;

public class Objetos {

    private Integer posX, posY;
    private String tipo;
    private Integer id;

    /**
     * Constructor de la clase Objetos
     * @param posX
     * @param posY
     * @param tipo
     */
    public Objetos(Integer posX, Integer posY, String tipo) {
        this.posX = posX;
        this.posY = posY;
        this.tipo = tipo;
    }

    /**
     * Metodo que devuelve la posicion en X del objeto
     * @return posX
     */
    public Integer getPosX() {
        return posX;
    }

    /**
     * Metodo que permite modificar la posicion en X del objeto
     * @param posX
     */
    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    /**
     * Metodo que devuelve la posicion en Y del objeto
     * @return posY
     */
    public Integer getPosY() {
        return posY;
    }

    /**
     * Metodo que permite modificar la posicion en Y del objeto
     * @param posY
     */
    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    /**
     * Metodo que devuelve el id del objeto
     * @return tipo
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo que permite modificar el id del objeto
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que devuelve el tipo del objeto
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que permite modificar el tipo del objeto
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
