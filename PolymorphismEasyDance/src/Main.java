import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
    public static void main(String[] args) {
        DanceMove dance1 = new DanceMove("DanceMove", 5);
        BreakDanceMove break1 = new BreakDanceMove("BreakDanceMove", 8, 3);
        Song song1 = new Song("Umoreni Krila");
        dance1.dance();
        dance1.perform();
        break1.dance();
        break1.perform();
        song1.sing();
    }
}