package Data.Balas;

public class Balas {
    private Integer posX, posY;
    private Integer velocidad;



    private Integer id;

    public Balas(Integer posX, Integer posY, Integer velocidad) {
        this.posX = posX;
        this.posY = posY;
        this.velocidad = velocidad;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
