import java.awt.*;
import java.util.Random;

public class Rock {

    private Boolean exist = false;
    private int timeLife = 10;
    private int time = 0;
    private int posX;
    private int posY;

    public Rock() {
        Random randomizer = new Random();
        this.posX = randomizer.nextInt(500);
        this.posY = randomizer.nextInt(500);
    }

    public void paintComponent(Graphics g){
        if(exist) {
            g.setColor(Color.BLUE);
            g.fillRect(this.posX, this.posY, 10, 10);
        }
    }

    public Boolean getExist() {
        return exist;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void update() {
        if(!exist){
            Random ramdomizer = new Random();
            int probability = ramdomizer.nextInt(11);
            if(ramdomizer.nextInt(11) < probability) {
                exist = true;
                this.posX = ramdomizer.nextInt(500);
                this.posY = ramdomizer.nextInt(500);
            }
            time = 0;
        } else {
            time++;
            if(time > timeLife){
                exist = false;
            }
        }
    }

}
