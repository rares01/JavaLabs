import java.sql.SQLException;
import java.util.List;

public interface asstabDao {

    void createAssTab(Asstab asstab) throws SQLException;
    Asstab getIdAssTabMovie(int id) throws  SQLException;
    Asstab getIdAssTabGenres(int id) throws  SQLException;
    List<Asstab> selectAllAssTab() throws SQLException;
}
