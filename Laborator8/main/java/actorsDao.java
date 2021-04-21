import java.sql.SQLException;
import java.util.List;

public interface actorsDao {
    void createActors(Actors act) throws SQLException;
    Actors getIdActors(int id) throws  SQLException;
    Actors getNameActors(String name) throws  SQLException;
    List<Actors> selectAllActors() throws SQLException;
    public List<Actors> toolActors(String fileName);
}
