public class DanceMove extends Performance implements Danceable{
    String name;
    int duration;
    public DanceMove(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    public void perform(){
        System.out.println("Performing "+this.name+" for "+this.duration);
    }
    @Override
    public void dance(){
        System.out.println("Dancing " + this.name);
    }
}
