import java.sql.SQLException;
import java.util.List;

public interface genresDao {
    void createGenres(Genres gen) throws SQLException;
    Genres getIdGenres(int id) throws  SQLException;
    Genres getNameGenres(String name) throws  SQLException;
    List<Genres> selectAllGenres() throws SQLException;
    public List<Genres> toolGenres(String fileName);
}
