public class App1 {
    public static void main(String[] args) {
        var orc = new Orc("Ivan");
        var human = new Human("Petar");
        orc.introduce();

        battle(orc, human);
    }
    public static void battle(Character char1, Character char2) {
        while(char1.isAlive() && char2.isAlive()) {
            char1.attack(char2);
            if(char2.isAlive())
            {
                char2.attack(char1);
            }
        }
        if(char1.isAlive()) System.out.println("Char1 is alive");
        else {
            System.out.println("Char2 is alive");
        }
    }
}