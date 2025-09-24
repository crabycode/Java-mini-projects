public class Skeleton extends Monster{
    public Skeleton(String name, int health, int power, String race)
    {
        super(name, health, power, race);
    }
    @Override
    public void attack(Character target)
    {
        target.setHealth(target.getHealth() - this.getPower());
    }
}
