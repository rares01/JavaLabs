import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassMovieDao implements movieDao{

    @Override
    public void createMovie(Movies mv) throws SQLException {

        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into movies(id, title, release_date, duration, score) VALUES(?,?,?,?,?)");
        pstmt.setString(1,String.valueOf(mv.getId()));
        pstmt.setString(2,mv.getTitle());
        pstmt.setString(3,mv.getRelease_date());
        pstmt.setString(4,String.valueOf(mv.getDuration()));
        pstmt.setString(5,String.valueOf(mv.getScore()));
        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public List<Movies> selectAllMovies() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from movies");
        List<Movies> movies = new ArrayList<>();
        while (rs.next()) {
            Movies mv =new Movies();
            mv.setId(rs.getInt("id")); //rs.getInt(1)
            mv.setTitle(rs.getString("title"));
            mv.setRelease_date(rs.getString("release_date"));
            mv.setDuration(rs.getInt("duration"));
            mv.setScore(rs.getInt("score"));

            movies.add(mv);
        }
        return movies;
    }



    @Override
    public Movies getIdMovie(int id) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from movies where id= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Movies mv = new Movies();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            mv.setId(rs.getInt("id")); //rs.getInt(1)
            mv.setTitle(rs.getString("title"));
            mv.setRelease_date(rs.getString("release_date"));
            mv.setDuration(rs.getInt("duration"));
            mv.setScore(rs.getInt("score"));

        }
        if (check == true) {
            return mv;
        }
        else
            return null;

    }

    @Override
    public Movies getNameMovie(String name) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from movies where title= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,name);
        Movies mv = new Movies();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            mv.setId(rs.getInt("id")); //rs.getInt(1)
            mv.setTitle(rs.getString("title"));
            mv.setRelease_date(rs.getString("release_date"));
            mv.setDuration(rs.getInt("duration"));
            mv.setScore(rs.getInt("score"));

        }
        if (check == true) {
            return mv;
        }
        else
            return null;
    }

    @Override
    public List<Movies> toolMovies(String fileName1)  {
        List<Movies> movies = new ArrayList<>();
        Path pathToFile = Paths.get(fileName1);
         try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
             // read the first line from the text file
              String line = br.readLine();
              // loop until all lines are read
             while (line != null) {
                 // use string.split to load a string array with the values from
                 // each line of
                 // the file, using a comma as the delimiter
                 String[] attributes = line.split(",");
                 String copie = attributes[0];
                 String numele= copie.substring(2);
                 int id= Integer.parseInt(numele);
                 String title = attributes[1];
                 String release_date= attributes[4];
                 int duration= Integer.parseInt(attributes[6]);
                 int score = Integer.parseInt(attributes[15]);// mean votes
                 Movies mv = new Movies(id,title,release_date,duration,score);
                 // adding Movie into ArrayList
                  movies.add(mv);
                 // read next line before looping
                 // if end of file reached, line would be null
                 line = br.readLine();
             }

         } catch (IOException ioe)
         { ioe.printStackTrace(); }

         return movies;


    }


}
