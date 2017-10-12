import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pigeon pigeon1 = new Pigeon();
        ArrayList<Pigeon> pigeonList = new ArrayList<Pigeon>();
        pigeonList.add(pigeon1);
        Square window = new Square(pigeonList);
        while(true) {

        }
    }
}
