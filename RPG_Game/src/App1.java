public class App1 {
    public static void main(String[] args) {
        Game game = new Game();
        game.createHero("Arthur", "Paladin");

        Monster monster1 = new FallenShaman("Stavri", 80, 10, "Troll", 5);
        Monster monster2 = new Skeleton("Bones", 90, 12, "Undead");
        Monster monster3 = game.createRandomMonster();

        game.addMonster(monster1);
        game.addMonster(monster2);
        game.addMonster(monster3);
        try {
            game.startGame();
        } catch (InterruptedException e) {
            System.out.println("Играта беше прекъсната: " + e.getMessage());
        }
    }
}
