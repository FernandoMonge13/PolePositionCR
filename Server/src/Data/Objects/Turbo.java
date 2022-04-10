package Data.Objects;

public class Turbo extends Objetos {
    private Integer speed;

    public Turbo(Integer posX, Integer posY) {
        super(posX, posY,"Turbo");
        this.speed = 20;

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
