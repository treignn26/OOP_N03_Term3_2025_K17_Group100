package src.main.java.com.group100.petclinic;

import java.time.LocalDate;

public class Appointment {
    private int appointmentId;
    private int petId;
    private LocalDate appointmentDate;
    private String reason;

    public Appointment(int appointmentId, int petId, LocalDate appointmentDate, String reason) {
        this.appointmentId = appointmentId;
        this.petId = petId;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
    }

    public int getAppointmentId() { return appointmentId; }
    public int getPetId() { return petId; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public String getReason() { return reason; }
}
