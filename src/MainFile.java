import ServicesManagement.CarriageType;
import ServicesManagement.ConcCarTypeCreator;

public class MainFile {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        ConcCarTypeCreator carCreator = new ConcCarTypeCreator();

        CarriageType car1 = carCreator.createCarriage("PASSENGER");

        System.out.println(car1.cleaningRoutine());
    }
}
