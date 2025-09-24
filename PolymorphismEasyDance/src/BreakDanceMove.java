public class BreakDanceMove extends DanceMove{
    public int complexity;
    public BreakDanceMove(String name, int duration, int complexity){
        super(name, duration);
        this.complexity = complexity;
    }
    public void perform(){
        System.out.println("Performing "+this.name+" with complexity level "+this.complexity);
    }
}
