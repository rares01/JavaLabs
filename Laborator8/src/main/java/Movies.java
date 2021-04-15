import java.sql.*;

public class Movies implements Dao{

    private int id;
    private String title;
    private String release_date;
    private int duration;
    private int score;


    public Movies(int id, String title, String release_date, int duration, int score) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Movies() {
        super();
    }

    @Override
    public void create() throws SQLException {

        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into movies(id, title, release_date, duration, score) VALUES(?,?,?,?,?)");
        pstmt.setString(1,String.valueOf(getId()));
        pstmt.setString(2,getTitle());
        pstmt.setString(3,getRelease_date());
        pstmt.setString(4,String.valueOf(getDuration()));
        pstmt.setString(5,String.valueOf(getScore()));
        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public void select() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from movies");
        while (rs.next()) {
            int id= rs.getInt("id"); //rs.getInt(1)
            String title=rs.getString("title");
            String release_date=rs.getString("release_date");
            int duration=rs.getInt("duration");
            int score=rs.getInt("score");

            System.out.println(id + ", " + title + ", " + release_date + ", " + duration + ", " + score);
        }

    }
}
