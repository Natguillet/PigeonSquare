import javax.swing.*;
import java.awt.*;

public class Pigeon extends JPanel implements Runnable{
    private int posX = 50;
    private int posY = 100;

    public Pigeon(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void move(Food food) {
        if(posX < food.getPosX()) {
            posX++;
        } else if (posX > food.getPosX()){
            posX--;
        }
        if(posY < food.getPosY()) {
            posY++;
        } else if (posY > food.getPosY()){
            posY--;
        }
        if(posX == food.getPosX() && posY == food.getPosY() && food.getFresh()) {
            Main.foodList.remove(food);
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
       if(Main.foodList.size() > 0) {
           //trouver la plus proche
            move(Main.foodList.get(nearestFood()));
        }
    }

    private int nearestFood(){
        int nearestfood_number = 0;
        double first_distance = 10000;
        for (int i =0; i < Main.foodList.size(); i++){
            //System.out.println(Main.foodList.get(i).getFresh());
            if (Main.foodList.get(i).getFresh()) {
                double distance = Distance(posX,posY,Main.foodList.get(i).getPosX(),Main.foodList.get(i).getPosY());
                //System.out.println(Main.foodList.get(i).getPosX());
                if(first_distance > distance ){
                    first_distance = distance;
                    nearestfood_number = i;
                }
            }
        }
        return nearestfood_number;
    }

    private double Distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((y2 - y1),2) + Math.pow((x2 - x1),2));
    }
}