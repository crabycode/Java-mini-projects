public class Bank implements User, Admin{
    private double amount;
    public Bank(double amount)
    {
        this.amount = amount;
    }
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount += amount;
    }
}
