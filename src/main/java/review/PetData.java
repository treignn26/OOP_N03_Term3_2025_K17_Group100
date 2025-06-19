package main.java.review;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class PetData {
    public static void retrievePetData(Connection conn, LocalDate date) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT name, type, exam_time FROM pets WHERE exam_date = '" + date + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println("Danh sach thu cung duoc hen kham hom nay:");
            while (rs.next()) {
                System.out.println("Ten: " + rs.getString("name") + 
                                   ", Loai: " + rs.getString("type") + 
                                   ", Gio kham: " + rs.getString("exam_time"));
            }
        } catch (Exception e) {
            System.err.println("Loi khi truy van du lieu thu cung: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                // Khong dong conn o day vi co the dung tiep
            } catch (Exception e) {
                System.err.println("Loi khi dong tai nguyen: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
        /*    conn = DatabaseUtils.connectToDatabase();
            if (conn != null) {
                retrievePetData(conn, LocalDate.now());
            } else {
                System.err.println("Khong the ket noi toi co so du lieu.");
            }*/
        } catch (Exception e) {
            System.err.println("Loi trong ham main: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println("Loi khi dong ket noi: " + e.getMessage());
            }
        }
    }
}
