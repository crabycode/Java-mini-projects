public class Training {
    private int id;
    private String type;
    private String coachName;
    private String time;
    private int availableSpots;
    public Training(int id, String type, String coachName, String time, int availableSpots){
        this.id = id;
        this.type = type;
        this.coachName = coachName;
        this.time = time;
        this.availableSpots = availableSpots;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }
}
