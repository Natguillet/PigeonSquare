import java.util.ArrayList;

public class Main {
    public static Integer NB_PIGEON = 5;
    public static ArrayList<Food> foodList = new ArrayList<Food>();
    public static Integer time = 0;
    public static Rock rock = new Rock();

    public static void main(String[] args) {
        ArrayList<Pigeon> pigeonList = new ArrayList<Pigeon>();
        for (int i = 0; i < NB_PIGEON; i++) {
            Pigeon pigeon = new Pigeon();
            pigeonList.add(pigeon);
            pigeon.start();
        }
        Square window = new Square(pigeonList);

        while (true){
            System.out.println(rock.getExist());
            window.repaint();
            /* The dangerous rock pop too ofen because the probability change very turn */
            //rock.update();
            time++;
            System.out.println(time);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }
}
