public class Main {
    public static void main(String[] args) {
        String type = args[0];
        int speedNum = Integer.parseInt(args[1]);
        int fuelNum = Integer.parseInt(args[2]);

        if(type.equals("SimpleCar"))
        {
            SimpleCar car = new SimpleCar(speedNum, fuelNum);
            System.out.println("This is a "+type);
            car.refuel();
        }
        else if(type.equals("ElectricCar"))
        {
            ElectricCar car = new ElectricCar(speedNum, fuelNum);
            System.out.println("This is an "+type);
            car.refuel();
        }
        else
        {
            System.out.println("There is no such type");
        }
    }
}