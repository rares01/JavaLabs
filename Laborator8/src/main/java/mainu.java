import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class mainu {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {


        Connection con = Singleton.createCon();
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("src/script/createTable.sql"));
        //Running the script
        sr.runScript(reader);

        Movies movie= new Movies(5,"titanic","10 august 2000",2,97);
        Genres genres = new Genres(5,"romantic");
        Asstab asstab = new Asstab(5,5);
        movie.create();
        movie.select();

        genres.create();
        genres.select();

        asstab.create();
        asstab.select();
    }

}
