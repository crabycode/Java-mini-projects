import java.util.Scanner;
public class App1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter car type(SimpleCar/ElectricCar)");
        String carType = sc.nextLine();
        if(carType.equals("SimpleCar"))
        {
            System.out.println("Please enter car speed: ");
            int speed = sc.nextInt();
            System.out.println("Please enter car fuel: ");
            int fuel = sc.nextInt();
            SimpleCar car1 = new SimpleCar(speed, fuel);
            System.out.println("This is a " + carType);
            car1.refuel();
        }
        else if(carType.equals("ElectricCar"))
        {
            System.out.println("Please enter car speed: ");
            int speed = sc.nextInt();
            System.out.println("Please enter car battery: ");
            int battery = sc.nextInt();
            ElectricCar car1 = new ElectricCar(speed, battery);
            System.out.println("This is an " + carType);
            car1.refuel();
        }
        else
        {
            System.out.println("Error. There is no such car type");
        }
    }
}