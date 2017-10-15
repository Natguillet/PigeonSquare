import java.util.ArrayList;

public class Main {
    public static ArrayList<Food> foodList = new ArrayList<Food>();
    public static Integer time = 0;

    public static void main(String[] args) {
        ArrayList<Pigeon> pigeonList = new ArrayList<Pigeon>();
        Pigeon pigeon1 = new Pigeon(50,100);
        pigeonList.add(pigeon1);
        Pigeon pigeon2 = new Pigeon(200,30);
        pigeonList.add(pigeon2);
        Square window = new Square(pigeonList);

        while (true){
            window.repaint();
            time++;
            System.out.println(time);
            pigeon1.run();
            pigeon2.run();
            // mise à jour de la peur
            //faire peur si besoin
            //repaint all

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }
}
