import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassAsstabDao implements asstabDao{

    @Override
    public void createAssTab(Asstab asstab) throws SQLException {
        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into asstab(movieId,genreId) VALUES(?,?)");
        pstmt.setString(2,String.valueOf(asstab.getGenreID()));
        pstmt.setString(1,String.valueOf(asstab.getMovieID()));

        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public Asstab getIdAssTabMovie(int id) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from asstab where movieId= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Asstab asstab = new Asstab();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            asstab.setMovieID(rs.getInt("movieId")); //rs.getInt(1)
            asstab.setGenreID(rs.getInt("genreId"));

        }
        if (check == true) {
            return asstab;
        }
        else
            return null;
    }

    @Override
    public Asstab getIdAssTabGenres(int id) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from asstab where genreId= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Asstab asstab = new Asstab();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            asstab.setMovieID(rs.getInt("movieId")); //rs.getInt(1)
            asstab.setGenreID(rs.getInt("genreId"));

        }
        if (check == true) {
            return asstab;
        }
        else
            return null;
    }

    @Override
    public List<Asstab> selectAllAssTab() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from asstab");
        while (rs.next()) {
             rs.getInt("movieId");
            rs.getInt("genreId");

        }
        List<Asstab> asstabs = new ArrayList<>();
        while (rs.next()) {
          Asstab asstab =new Asstab();
            asstab.setMovieID(rs.getInt("movieId")); //rs.getInt(1)
            asstab.setGenreID(rs.getInt("genreId"));
           asstabs.add(asstab);
        }
        return asstabs;
    }


}
