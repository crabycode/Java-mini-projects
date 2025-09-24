public class CompanyET extends Company{
    public CompanyET(){
        super();
    }
    private String ownerName;
    private double startingCapital;
    private double actualCapital;

    public String getOwnerName()
    {
        return this.ownerName;
    }
    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public double getStartingCapital()
    {
        return this.startingCapital;
    }
    public void setStartingCapital(double startingCapital)
    {
        this.startingCapital = startingCapital;
    }

    public double getActualCapital()
    {
        return this.actualCapital;
    }
    public void setActualCapital(double actualCapital)
    {
        this.actualCapital = actualCapital;
    }
    public double calculateWinning()
    {
        return this.actualCapital - this.startingCapital;
    }
}
