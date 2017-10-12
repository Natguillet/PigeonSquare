import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Square extends JFrame implements ActionListener, MouseListener {
    private ArrayList<Food> foodList = new ArrayList<Food>();
    private ArrayList<Pigeon> pigeonList;

    public Square(ArrayList<Pigeon> pigeonList){
        this.setTitle("Pigeon Square");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addMouseListener(this);
        this.pigeonList = pigeonList;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < foodList.size() && !foodList.isEmpty(); i++)
        {
            foodList.get(i).paintComponent(g);
        }
        for(int i = 0; i < pigeonList.size() && !pigeonList.isEmpty(); i++)
        {
            pigeonList.get(i).paintComponent(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Création food");
        Food food = new Food(e.getX(), e.getY());
        foodList.add(food);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}