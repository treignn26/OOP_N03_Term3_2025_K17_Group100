package review;
import review.Appointment;
import java.util.ArrayList;
import java.time.LocalDate;


public class AppointmentList {
    private ArrayList<Appointment> appointments; 


    public AppointmentList() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment app) {
        appointments.add(app);
    }

    public ArrayList<Appointment> getAllAppointments() {
        return new ArrayList<>(this.appointments); 
    }

    public LocalDate getTodayDate() {
        return LocalDate.now();
    }

    
    public ArrayList<Appointment> filterAppointmentsByDate(LocalDate date, ArrayList<Appointment> allAppointments) {
        ArrayList<Appointment> filteredAppointments = new ArrayList<>();
        for (Appointment app : allAppointments) {
            if (app.getAppointmentDate().isEqual(date)) {
                filteredAppointments.add(app);
            }
        }
        return filteredAppointments;
    }
}
