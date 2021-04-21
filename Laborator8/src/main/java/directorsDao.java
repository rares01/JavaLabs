import java.sql.SQLException;
import java.util.List;

public interface directorsDao {
    void createDirectors(Directors dirs) throws SQLException;
    Directors getIdDirectors(int id) throws  SQLException;
    Directors getNameDirectors(String name) throws  SQLException;
    List<Directors>  selectAllDirectors() throws SQLException;
    public List<Directors> toolDirectors(String fileName);
}
