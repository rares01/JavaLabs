import java.sql.SQLException;
import java.util.List;

public interface movieDao {
    void createMovie(Movies mv) throws SQLException;
    Movies getIdMovie(int id) throws  SQLException;
    Movies  getNameMovie(String name) throws  SQLException;
    public List<Movies> selectAllMovies() throws SQLException;
    public List<Movies> toolMovies(String fileName1);
}
