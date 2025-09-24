public class SimpleCar extends Vehichle implements Refuelable{
    public int fuel;

    public SimpleCar(int speed, int fuel) {
        super(speed);
        this.fuel = fuel;
    }

    @Override
    public void accelerate()
    {
        if(fuel == 1)
        {
            System.out.println("Out of fuel!");
            return;
        }
        if(this.speed + 10 <= MAX_SPEED)
        {
            this.speed += 10;
            this.fuel--;
        }
        else
        {
            this.speed = MAX_SPEED;
        }

        System.out.println("Speed after accelerate: " + this.speed+", Fuel left: "+this.fuel);
    }

    @Override
    public void brake()
    {
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
    public void refuel()
    {
        this.fuel+=10;
        System.out.println("Car refueled, Fuel left: "+this.fuel);
    }
}
