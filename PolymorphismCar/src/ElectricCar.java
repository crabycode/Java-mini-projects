public class ElectricCar extends Car{
    int batteryLevel;
    int efficiency;
    public ElectricCar(String brand, int speed, int fuel, int mileage, int batteryLevel, int efficiency){
        super(brand, speed, fuel, mileage);
        this.batteryLevel = batteryLevel;
        this.efficiency = efficiency;
    }
    public int charge(int charged){
        batteryLevel += charged;
        return batteryLevel;
    }
    public void driveElectric(int distance){
        mileage += distance;
        batteryLevel -= (distance/100)*efficiency;
    }
}
