package models;

public class Record {
    private int recordID;
    private int petID;
    private String vaccineName;
    private String date;
    private String doctor;
    private String nextDoseDate;

    public Record(int recordID, int petID, String vaccineName, String date, String doctor, String nextDoseDate) {
        try {
            this.recordID = recordID;
            this.petID = petID;
            this.vaccineName = vaccineName;
            this.date = date;
            this.doctor = doctor;
            this.nextDoseDate = nextDoseDate;
        } catch (Exception e) {
            System.err.println("Loi khi khoi tao Record: " + e.getMessage());
        } finally {
        }
    }

    public String toString() {
        try {
            return "Record{" +
                    "recordID=" + recordID +
                    ", petID=" + petID +
                    ", vaccineName='" + vaccineName + '\'' +
                    ", date='" + date + '\'' +
                    ", doctor='" + doctor + '\'' +
                    ", nextDoseDate='" + nextDoseDate + '\'' +
                    '}';
        } catch (Exception e) {
            System.err.println("Loi khi chuyen Record sang chuoi: " + e.getMessage());
            return "Record loi";
        } finally {
        }
    }
}
