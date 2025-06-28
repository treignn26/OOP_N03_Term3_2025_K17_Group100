package src.main.java.com.group100.petclinic;


import java.util.ArrayList;

public class RecordList {
    ArrayList<Record> records = new ArrayList<>();

    public ArrayList<Record> addRecord(Record record) {
        records.add(record);
        return records;
    }

    public ArrayList<Record> editRecord(int recordId, String visitDate, String treatment, String notes, int petId) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getRecordId() == recordId) {
                records.get(i).setVisitDate(visitDate);
                records.get(i).setTreatment(treatment);
                records.get(i).setNotes(notes);
                records.get(i).setPetId(petId);
                System.out.println("Cap nhap thong tin thanh cong cho ho so ID: " + recordId);
            }
        }
        return records;
    }

    public ArrayList<Record> deleteRecord(int recordId) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getRecordId() == recordId) {
                records.remove(i);
                System.out.println("Da xoa ho so voi ID: " + recordId);
                break;
            }
        }
        return records;
    }

    public void printRecordList() {
        if (records.isEmpty()) {
            System.out.println("Danh sach ho so trong.");
        } else {
            for (Record record : records) {
                System.out.println("Record ID: " + record.getRecordId() +
                                   ", Visit Date: " + record.getVisitDate() +
                                   ", Treatment: " + record.getTreatment() +
                                   ", Notes: " + record.getNotes() +
                                   ", Pet ID: " + record.getPetId());
            }
        }
    }
}
