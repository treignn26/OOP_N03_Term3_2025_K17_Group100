package review;

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

    public int getRecordId() {
        return recordID;
    }

    public String getVisitDate() {
        return date;
    }

    public String getTreatment() {
        return vaccineName;
    }

    public String getNotes() {
        return doctor;
    }

    public int getPetId() {
        return petID;
    }

    public void setVisitDate(String date) {
        this.date = date;
    }

    public void setTreatment(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public void setNotes(String doctor) {
        this.doctor = doctor;
    }

    public void setPetId(int petID) {
        this.petID = petID;
    }

    @Override
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
