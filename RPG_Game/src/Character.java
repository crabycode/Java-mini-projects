public abstract class Character implements IDefendable{
    private String name;
    private int health;
    private int power;
    private String race;

    public Character(String name, int health, int power, String race)
    {
        this.name = name;
        this.health = health;
        this.power = power;
        this.race = race;
    }

    public abstract void attack(IAttackable target);

    public String getName()
    {
        return name;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = Math.max(0, health);
    }
    public int getPower()
    {
        return power;
    }
    public void setPower(int power)
    {
        this.power = Math.max(0, power);
    }
    public String getRace()
    {
        return race;
    }
    public void setRace(String newRace)
    {
        this.race = newRace;
    }

    @Override
    public void defend(int attackPower) {
        setHealth((int) (getHealth() - (0.5 * attackPower)));
        System.out.println("MQY");
    }
}
