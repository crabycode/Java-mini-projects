import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class Game {
    Character hero;
    Queue<Monster> monsters = new LinkedList<Monster>();

    public void createHero(String name, String race)
    {
        switch(race.toLowerCase())
        {
            case "paladin":
                this.hero = new Paladin(name, 100, 15, race, 10);
                break;
            case "amazon":
                this.hero = new Amazon(name, 70, 10, race, 5);
                break;
            case "barbarian":
                this.hero = new Barbarian(name, 130, 20, race);
                break;
            case "necromancer":
                this.hero = new Necromancer(name, 90, 30, race);
                break;
            case "witch":
                this.hero = new Witch(name, 70, 20, race, 7);
                break;
            default:
                System.out.println("There is no such class");
                break;
        }
    }
    public void addMonster(Monster monster) {
        monsters.add(monster);
        System.out.println("The monster " + monster.getName() + " was added to the queue");
    }

    public void startGame() throws InterruptedException
    {
        while(!monsters.isEmpty())
        {
            Monster monster = monsters.poll();
            while(hero.getHealth() > 0 && monster.getHealth() > 0)
            {
                hero.attack(monster);
                System.out.printf("You attacked %s for %d health and it now has %d health \n", monster.getName(), hero.getPower(), monster.getHealth());
                if(monster.getHealth() <= 0)
                {
                    System.out.printf("\nMonster %s was defeated!\n", monster.getName());
                    break;
                }
                monster.attack(hero);
                System.out.printf("You were attacked for %d health and it now has %d health \n", monster.getPower(), hero.getHealth());
                if(hero.getHealth() <= 0)
                {
                    System.out.printf("\nYour character %s was defeated", hero.getName());
                    return;
                }
            }
            System.out.println("Waiting for automatic recovery");
            recover();
        }
        System.out.println("All monsters were defeated! Good job!");
    }

    private void recover() throws InterruptedException
    {
        hero.setHealth(hero.getHealth() + 20);
        System.out.println("You are ready to fight again! You have " + hero.getHealth() + " health");
    }

    public Monster createRandomMonster()
    {
        Random rand = new Random();
        String[] monsterTypes = {"Skeleton", "FallenShaman", "Butcher"};
        String type = monsterTypes[rand.nextInt(monsterTypes.length)];
        switch(type)
        {
            case "FallenShaman":
            return new FallenShaman("Fallen Shaman", 80, 15, "Troll", 5);
            case "Skeleton":
                return new Skeleton("Skeleton", 70, 12, "Undead");
            case "Butcher":
                return new Butcher("Zombie", 100, 10, "Undead");
            default:
                return null;
        }
    }
}
