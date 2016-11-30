package pl.gogolewski.entity;
import javax.persistence.*;


@Entity
@Table(name = "Trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String activityName;
    private int duration;
    private String date;
    private Long userId;

    public Training(String activityName , int duration , String date  , Long userId){
        this.activityName = activityName;
        this.duration = duration;
        this.date = date;
        this.userId = userId;
    }

    public Training (){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public Long getUserId(){return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

}


