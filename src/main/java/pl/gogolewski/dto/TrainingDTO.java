package pl.gogolewski.dto;


public class TrainingDTO {

    public Long Id;
    public String activityName;
    public int duration;
    public Long userId;
    public String date;

    public Long getId() {return Id;}

    public void setId(Long id) {Id = id;}

    public String getActivityName() {return activityName;}

    public void setActivityName(String activityName) {this.activityName = activityName;}

    public int getDuration() {return duration;}

    public void setDuration(int duration) {this.duration = duration;}

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}
}
