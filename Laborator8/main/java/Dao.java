import java.sql.SQLException;

public interface Dao {

    void create() throws SQLException;
    void select() throws SQLException;

}
