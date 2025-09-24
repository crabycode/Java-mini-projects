//final != abstract.
public abstract class Character {
    private int health;
    private int damage;
    private double attackSpeed;
    private String race;
    private String name;

    public Character(int health, int damage, double attackSpeed, String race, String name) {
        this.health = health;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.race = race;
        this.name = name;
    }
    public double getAttackSpeed()
    {
        return this.attackSpeed;
    }

    public void introduce() {
        System.out.printf("\nMy name is %s and my race is %s", race, name);
    }

    public void attack(Character defender) {
        defender.defend(this.damage);
    }
    public void defend(int damage)
    {
        this.health -= this.damage;
        System.out.printf("You took %s damage");
    }
    public boolean isAlive()
    {
        if (this.health > 0) return true;
        return false;
    }
}
