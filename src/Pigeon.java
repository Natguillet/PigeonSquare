import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pigeon extends Thread{
    private int posX = 50;
    private int posY = 100;

    public Pigeon(){
        Random randomizer = new Random();
        this.posX = randomizer.nextInt(500);
        this.posY = randomizer.nextInt(500);
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
        while (true) {
            if(Main.rock.getExist()){
                disperse(Main.rock.getPosX(), Main.rock.getPosY());
            } else if(Main.foodList.size() > 0) {
                move(Main.foodList.get(nearestFood()));
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }

    private void disperse(int x, int y) {
        if(posX < x) {
            posX--;
        } else if (posX > x){
            posX++;
        }
        if(posY < y) {
            posY--;
        } else if (posY > y){
            posY++;
        }
    }

    private int nearestFood(){
        int nearestfood_number = 0;
        double first_distance = 10000;
        for (int i =0; i < Main.foodList.size(); i++){
            if (Main.foodList.get(i).getFresh()) {
                double distance = Distance(posX,posY,Main.foodList.get(i).getPosX(),Main.foodList.get(i).getPosY());
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