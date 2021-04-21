import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassGenresDao implements genresDao{

    @Override
    public void createGenres(Genres gen) throws SQLException {
        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into genres(id,name) VALUES(?,?)");
        pstmt.setString(1,String.valueOf(gen.getId()));

        pstmt.setString(2,gen.getName());
        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public List<Genres> selectAllGenres() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from genres");
        List<Genres> genres = new ArrayList<>();
        while (rs.next()) {
            Genres gen =new Genres();
            gen.setId(rs.getInt("id"));
           gen.setName(rs.getString("name"));
            genres.add(gen);
        }
        return genres;

    }

    @Override
    public Genres getIdGenres(int id) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from genres where id= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Genres gen = new Genres();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            gen.setId(rs.getInt("id")); //rs.getInt(1)
            gen.setName(rs.getString("name"));
        }
        if (check == true) {
            return gen;
        }
        else
            return null;
    }

    @Override
    public Genres getNameGenres(String name) throws SQLException {
        Connection con= Singleton.getCon();
        String query = "select * from genres where name= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        Genres gen = new Genres();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            gen.setId(rs.getInt("id")); //rs.getInt(1)
            gen.setName(rs.getString("name"));
        }
        if (check == true) {
            return gen;
        }
        else
            return null;
    }

    @Override
    public List<Genres> toolGenres(String fileName) {
        List<Genres> genres = new ArrayList<>();
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
                String name = attributes[5];
                Genres gen = new Genres(id,name);
                // adding Genres into ArrayList
                genres.add(gen);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe)
        { ioe.printStackTrace(); }

        return genres;
    }
}
