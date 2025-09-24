public class Main {
    public static void main(String[] args) {
        SimpleCar car1 = new SimpleCar();
        car1.speed = 120;
        car1.accelerate(20);
        car1.honk();
        System.out.println(car1.speed);
        FamilyCar car2 = new FamilyCar();
        car2.speed = 90;
        car2.seats = 5;
        car2.addSeat(1);
        car2.accelerate(20);
        car2.honk();
        System.out.println(car2.speed);
        System.out.println(car2.seats);
    }
}