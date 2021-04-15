import java.sql.*;

public class Genres implements Dao{

    private int id;
    private String name;

    public Genres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void create() throws SQLException {
        Connection con= Singleton.getCon();
        PreparedStatement pstmt = con.prepareStatement("insert into genres(id,name) VALUES(?,?)");
        pstmt.setString(1,String.valueOf(getId()));

        pstmt.setString(2,getName());
        pstmt.executeUpdate();
        con.commit();
    }

    @Override
    public void select() throws SQLException {
        Connection con= Singleton.getCon();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from genres");
        while (rs.next()) {
            int id= rs.getInt("id");
            String name=rs.getString("name");
            System.out.println(id + ", " + name);
        }
    }
}
