public class ElectricCar extends Vechicle implements Refuelable {
    private int battery;
    public ElectricCar(int speed, int battery){
        super(speed);
        this.battery = battery;
    }
    @Override
    public void accelerate()
    {
        if(battery == 0)
        {
            System.out.println("Battery empty!");
            return;
        }
        if(this.speed + 10 <= MAX_SPEED)
        {
            this.speed += 10;
            this.battery -= 1;
        }
        else
        {
            this.speed = MAX_SPEED;
        }
        System.out.println("Speed after accelerate: " + this.speed + ", Fuel left: "+ this.battery +"kW");
    }

    @Override
    public void brake(){
        if (this.speed - 20 >= MIN_SPEED)
        {
            this.speed -= 20;
        }
        else
        {
            this.speed = MIN_SPEED;
        }
        System.out.println("Speed after brake: " + this.speed);
    }

    @Override
    public void refuel() {
        this.battery += 20;
        System.out.println("Car refueled. Battery left: " + this.battery + "kW");
    }
}
