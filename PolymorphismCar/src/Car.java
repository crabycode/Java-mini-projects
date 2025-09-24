public class Car {
    String brand;
    int speed;
    int fuel;
    int mileage;
    public Car(String brand, int speed, int fuel, int mileage) {
        this.brand = brand;
        this.speed = speed;
        this.fuel = fuel;
        this.mileage = mileage;
    }
    public int accelerate(){
        return speed+20;
    }
    public int refuel(int newFuel){
        this.fuel+=newFuel;
        return fuel;
    }
    public void drive(int distance){
        mileage += distance;
        fuel -= (distance/100)*5;
    }
}
