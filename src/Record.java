package models;

public class Record {
    private int recordID;
    private int petID;
    private String vaccineName;
    private String date;
    private String doctor;
    private String nextDoseDate;

public Record(int recordID, int petID, String vaccineName, String date, String doctor, String nextDoseDate) {
        this.recordID = recordID;
        this.petID = petID;
        this.vaccineName = vaccineName;
        this.date = date;
        this.doctor = doctor;
        this.nextDoseDate = nextDoseDate;
    }
public String toString() {
        return "Record{" +
                "recordID=" + recordID +
                ", petID=" + petID +
                ", vaccineName='" + vaccineName + '\'' +
                ", date='" + date + '\'' +
                ", doctor='" + doctor + '\'' +
                ", nextDoseDate='" + nextDoseDate + '\'' +
                '}';
    }
}
