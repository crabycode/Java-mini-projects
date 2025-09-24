public abstract class Monster implements IAttackable {
    private String name;
    private int health;
    private int power;
    private String race;

    public Monster(String name, int health, int power, String race)
    {
        this.name = name;
        this.health = health;
        this.power = power;
        this.race = race;
    }

    public abstract void attack(Character target);

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
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }
}
