public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        Car car1 = new Car("Toyota", 120, 60, 120000);
        Car car2 = new Car("Opel", 100, 30, 166600);
        ElectricCar elCar1 = new ElectricCar("Toyota", 90,20, 100000, 5, 1);
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = elCar1;
        for (Car car : cars) {
            if (car instanceof ElectricCar) {
                ((ElectricCar) car).driveElectric(20);
            } else{
                car.drive(30);
            }
        }
    }
}