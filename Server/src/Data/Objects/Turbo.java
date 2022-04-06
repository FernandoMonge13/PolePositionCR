package Data.Objects;

public class Turbo extends Objects {
    private Integer speed;

    public Turbo(Integer posX, Integer posY, Integer speed) {
        super(posX, posY);
        this.speed = speed;

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
