public class FallenShaman extends Monster implements IHealable{
    private int healing;
    public FallenShaman(String name, int health, int power, String race, int healing)
    {
        super(name, health, power, race);
        this.healing = healing;
    }
    @Override
    public void attack(Character target)
    {
        target.setHealth(target.getHealth() - this.getPower());
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
