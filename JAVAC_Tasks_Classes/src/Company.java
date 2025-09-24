public class Company {
    private String name;
    private String date;
    private String bullstat;

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return this.date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }

    public String getBullstat()
    {
        return this.bullstat;
    }
    public void setBullstat(String bullstat)
    {
        if(bullstat.length()==10)
        {
            this.bullstat = bullstat;
        }
    }
}