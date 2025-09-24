public class Account {
    private double balance;
    private int pin;
    private int accountNumber;
    public Account(double balance, int pin, int accountNumber) {
        this.balance = balance;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void deposit(int amount){
        this.balance += amount;
    }
    public void withdraw(int amount){
        if(amount < 0) throw new IllegalArgumentException("Amount must be positive");
        if(this.balance >= amount){
            this.balance -= amount;
        }
        else throw new IllegalArgumentException("Insufficient balance");
    }
    public boolean checkPin(int pin){
        if(this.pin == pin){
            return true;
        }
        return false;
    }
}
