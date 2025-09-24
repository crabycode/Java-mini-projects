public class CompanyET extends Company{
    private String ownerName;
    private double initialCapital;
    private double currentCapital;

    public CompanyET(String companyName, String dateOfFounding, String bulstat, String ownerName,
                     double initialCapital, double currentCapital) {
        super(companyName, dateOfFounding, bulstat);
        this.ownerName = ownerName;
        this.initialCapital = initialCapital;
        this.currentCapital = currentCapital;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public double getInitialCapital() {
        return initialCapital;
    }
    public void setInitialCapital(double initialCapital) {
        this.initialCapital = initialCapital;
    }
    public double getCurrentCapital() {
        return currentCapital;
    }
    public void setCurrentCapital(double currentCapital) {
        this.currentCapital = currentCapital;
    }
    public double calculateProfit(){
        return this.currentCapital-this.initialCapital;
    }
}
