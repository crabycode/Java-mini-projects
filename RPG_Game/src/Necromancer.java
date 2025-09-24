public class Necromancer extends Character{
    public Necromancer(String name, int health, int power, String race)
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
        setHealth(getHealth() - attackPower);
    }

    public void increasePower(int increasePower)
    {
        setPower(getPower() + increasePower);
    }
}
