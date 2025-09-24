public class Company {
    private String companyName;
    private String dateOfFounding;
    private String bulstat;

    public Company(String companyName, String dateOfFounding, String bulstat){
        this.companyName = companyName;
        this.dateOfFounding = dateOfFounding;
        setBulstat(bulstat);
    }

    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName= companyName;
    }
    public String getDateOfFounding(){
        return dateOfFounding;
    }
    public void setDateOfFounding(String dateOfFounding){
        this.dateOfFounding = dateOfFounding;
    }
    public String getBulstat(){
        return bulstat;
    }
    public void setBulstat(String bulstat){
        if(bulstat.length() == 10){
            this.bulstat = bulstat;
        }
    }
}
