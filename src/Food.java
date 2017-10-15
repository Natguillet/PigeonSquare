import javax.swing.*;
import java.awt.*;

public class Food extends JPanel{
    private int posX;
    private int posY;
    private Boolean fresh = true;
    private int time = 0;
    private int timeFresh = 100;
    private int timeDestruction = 300;

    Food(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.fresh = true;
    }

    public void paintComponent(Graphics g){
        if(fresh) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillOval(posX, posY, 10, 10);
    }

    public void update() {
        this.time++;
        if(this.time >= timeFresh && this.time <= timeDestruction){
            fresh = false;
        } else if(this.time >= timeDestruction) {
            Main.foodList.remove(this);
        }
    }

    public Boolean getFresh() {
        return fresh;
    }

    public void setFresh(Boolean fresh) {
        this.fresh = fresh;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
