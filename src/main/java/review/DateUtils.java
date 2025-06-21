package review;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Today's date: " + getCurrentDate());
        } catch (Exception e) {
            System.err.println("Da xay ra loi khi lay nay hien tai");
            e.printStackTrace();
        } finally {
            System.out.println("Ket thuc chương trinh");
        }
    }
}
