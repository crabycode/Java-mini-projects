public class Paladin extends Character implements IHealable{
    private int healing;
    public Paladin(String name, int health, int power, String race, int healing)
    {
        super(name, health, power, race);
        this.healing = healing;
    }

    @Override
    public void attack(IAttackable target)
    {
        target.takeDamage(this.getPower());
    }

    @Override
    public void heal(Character char1, int healing) {
        char1.setHealth(getHealth() + healing);
    }

    public void setHealing(int healing)
    {
        this.healing = healing;
    }
    public int getHealing()
    {
        return this.healing;
    }
}
