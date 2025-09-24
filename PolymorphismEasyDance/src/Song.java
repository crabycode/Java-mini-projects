public class Song extends Performance{
    String name;

    public Song(String name){
        this.name = name;
    }
    public void sing(){
        System.out.println("Singing " + this.name);
    }
}
