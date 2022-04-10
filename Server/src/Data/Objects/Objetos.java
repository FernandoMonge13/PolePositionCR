package Data.Objects;

public class Objetos {

    private Integer posX, posY;
    private String tipo;
    private Integer id;


    public Objetos(Integer posX, Integer posY, String tipo) {
        this.posX = posX;
        this.posY = posY;
        this.tipo = tipo;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
