import java.time.LocalDate;

public class DateUtils {
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Today's date: " + getCurrentDate());
        } catch (Exception e) {
            System.err.println("Da xay ra loi khi lay ngay hien tai: " + e.getMessage());
            e.printStackTrace(); // Optional: hiển thị chi tiết lỗi
        } finally {
            System.out.println("Ket thuc chuong trinh.");
        }
    }
}
