import java.sql.*;

public class Asstab implements Dao {


    private int genreID;
    private int movieID;

    public Asstab(int genreID, int movieID) {
        this.genreID = genreID;
        this.movieID = movieID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    @Override
    public void create() throws SQLException {
        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into asstab(movieId,genreId) VALUES(?,?)");
        pstmt.setString(2,String.valueOf(getGenreID()));
        pstmt.setString(1,String.valueOf(getMovieID()));

        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public void select() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from asstab");
        while (rs.next()) {
            int id1= rs.getInt("movieId");
            int id2 =rs.getInt("genreId");
            System.out.println(id1 + ", " + id2);
        }
    }

}
