import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class PetData {
    public static void retrievePetData(Connection conn, LocalDate date) {
        try {
            String query = "SELECT name, type, exam_time FROM pets WHERE exam_date = '" + date + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("Pets scheduled for today:");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + 
                                   ", Type: " + rs.getString("type") + 
                                   ", Exam Time: " + rs.getString("exam_time"));
            }
        } catch (Exception e) {
            System.err.println("Error retrieving pet data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = DatabaseUtils.connectToDatabase();
        if (conn != null) {
            retrievePetData(conn, LocalDate.now());
        }
    }
}

