import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassActorsDao implements  actorsDao{

    @Override
    public void createActors(Actors act) throws SQLException {
        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into actors(movieId, name) VALUES(?,?)");
        pstmt.setString(1,String.valueOf(act.getMovieId()));
        pstmt.setString(2,act.getName());
        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public Actors getIdActors(int id) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from actors where movieId= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Actors act = new Actors();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            act.setMovieId(rs.getInt("movieId")); //rs.getInt(1)
            act.setName(rs.getString("name"));
        }
        if (check == true) {
            return act;
        }
        else
            return null;
    }

    @Override
    public Actors getNameActors(String name) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from actors where name= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        Actors act = new Actors();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            act.setMovieId(rs.getInt("movieId")); //rs.getInt(1)
            act.setName(rs.getString("name"));
        }
        if (check == true) {
            return act;
        }
        else
            return null;
    }

    @Override
    public List<Actors> selectAllActors() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from actors");
        List<Actors> actors = new ArrayList<>();
        while (rs.next()) {
            Actors act =new Actors();
            act.setMovieId(rs.getInt("movieId")); //rs.getInt(1)
            act.setName(rs.getString("name"));
            actors.add(act);
        }
        return actors;
    }

    @Override
    public List<Actors> toolActors(String fileName) {

        List<Actors> actors = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
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
                String name = attributes[12];
                Actors act = new Actors(id,name);
                // adding Actors into ArrayList
                actors.add(act);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe)
        { ioe.printStackTrace(); }

        return actors;
    }
}
