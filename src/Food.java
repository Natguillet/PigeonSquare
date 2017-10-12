import javax.swing.*;
import java.awt.*;

public class Food extends JPanel{
    private int posX;
    private int posY;
    private Boolean fresh = true;
    private int timeFresh = 3000;
    private int timeDestruction = 30000;

    Food(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.fresh = true;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(posX, posY, 10, 10);
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
