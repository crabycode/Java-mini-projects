public class Barbarian extends Character{
    public Barbarian(String name, int health, int power, String race)
    {
        super(name, health, power, race);
    }
    @Override
    public void attack(IAttackable target)
    {
        target.takeDamage(this.getPower());
    }
    @Override
    public void defend(int attackPower)
    {
        setHealth((int) (getHealth() - (0.2*attackPower)));
    }
}
