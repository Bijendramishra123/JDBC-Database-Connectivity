import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc {
    public static void main(String[] args) {
        // MySQL connection details
        String url = "jdbc:mysql://localhost:3306/test";   // Ensure database 'test' exists
        String username = "root";      // change if different
        String password = "Mahi@123";  // replace with your MySQL password

        // SQL INSERT query
        String sql = "INSERT INTO Employee(emp_id) VALUES (?)";

        try {
            // 1. Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // 3. Create PreparedStatement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);  // Inserting emp_id as 1
            
            // 4. Execute the query
            int rowsInserted = stmt.executeUpdate();

            // 5. Confirm insertion
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

            // 6. Close connection
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred.");
            e.printStackTrace();
        }
    }
}
