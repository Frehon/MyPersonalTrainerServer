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

    private Long userId;

    public Training(String activityName , int duration , Long userId){
        this.activityName = activityName;
        this.duration = duration;
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

    public Long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }
}


