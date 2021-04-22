import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="movies")
@NamedQueries({
        @NamedQuery(name = "Movies.findByName",
                query = "SELECT a FROM Movies a WHERE a.title = :title"),
        @NamedQuery(name = "Movies.findById",
                query = "SELECT a FROM Movies a WHERE a.id = :id")
})
public class Movies implements Serializable {
    public Movies() {
    }

    @Id
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="release_date")
    private java.sql.Timestamp release_date;

    public Timestamp getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Timestamp release_date) {
        this.release_date = release_date;
    }

    @Column(name="duration")
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name="score")
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_date=" + release_date +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
