import javax.swing.*;
import java.awt.*;

public class Pigeon extends JPanel implements Runnable{
    private int posX = 50;
    private int posY = 100;

    public void move(Food food) {
        if(posX < food.getPosX()) {
            posX--;
        } else if (posX > food.getPosX()){
            posX++;
        }
        if(posY < food.getPosY()) {
            posY--;
        } else if (posY > food.getPosY()){
            posY++;
        }
        if(posX == food.getPosX() && posY == food.getPosY() && food.getFresh()) {
            System.out.println("le pigeon mange la nourriture");
        }
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(posX, posY, 20, 20);
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

    @Override
    public void run() {
        /*if(areFood) {
            move;
        } else {
            sleep;
        }*/
    }
}