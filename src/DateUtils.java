import java.time.LocalDate;

public class DateUtils {
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
    public static void main(String[] args) {
        System.out.println("Today's date: " + getCurrentDate());
    }
}

