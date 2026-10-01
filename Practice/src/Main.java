import java.sql.*;

class DatabaseManager {
    public void getData() {
        
        String user = "root";
       // String pass = "password";

        // try-with-resources = auto close
        try (Connection con = DriverManager.getConnection(user);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new DatabaseManager().getData();
    }
}
