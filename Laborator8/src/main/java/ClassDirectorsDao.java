import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDirectorsDao implements directorsDao{

    @Override
    public void createDirectors(Directors dirs) throws SQLException {
        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into directors(movieId, name) VALUES(?,?)");
        pstmt.setString(1,String.valueOf(dirs.getMovieId()));
        pstmt.setString(2,dirs.getName());
        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public Directors getIdDirectors(int id) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from directors where movieId= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Directors dirs = new Directors();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            dirs.setMovieId(rs.getInt("movieId")); //rs.getInt(1)
            dirs.setName(rs.getString("name"));
        }
        if (check == true) {
            return dirs;
        }
        else
            return null;
    }

    @Override
    public Directors getNameDirectors(String name) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from directors where name= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        Directors dirs = new Directors();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            dirs.setMovieId(rs.getInt("movieId")); //rs.getInt(1)
            dirs.setName(rs.getString("name"));
        }
        if (check == true) {
            return dirs;
        }
        else
            return null;
    }

    @Override
    public List<Directors> selectAllDirectors() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from directors");
        List<Directors> directors = new ArrayList<>();
        while (rs.next()) {
            Directors dirs =new Directors();
            dirs.setMovieId(rs.getInt("movieId")); //rs.getInt(1)
            dirs.setName(rs.getString("name"));
            directors.add(dirs);
        }
        return directors;
    }

    @Override
    public List<Directors> toolDirectors(String fileName) {
        List<Directors> directors = new ArrayList<>();
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
                int id= Integer.parseInt(attributes[0]);
                String name = attributes[9];
                Directors dir = new Directors(id,name);
                // adding Direcotr into ArrayList
                directors.add(dir);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe)
        { ioe.printStackTrace(); }

        return directors;
    }
}
