public class SimpleCar extends Vechicle implements Honkable{
    public int speed;
    public void accelerate(int speed){
        this.speed += speed;
    }
    public void honk(){
        System.out.println("Honk!");
    }

    @Override
    public void move() {
        System.out.println("Vechicle is moving");
    }
}
