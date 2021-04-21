import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

    private static Singleton single_instance = new Singleton();
    private static Connection con=null;
    private Singleton() {
    }
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }

    public static Singleton getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(Singleton single_instance) {
        Singleton.single_instance = single_instance;
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        Singleton.con = con;
    }
    public static Connection createCon(){
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","student", "STUDENT");
        } catch (
                SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
        return con;
    }

    public static void closeCon(){
        if(con!=null){
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
