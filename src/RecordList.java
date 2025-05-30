import java.util.ArrayList;

public class RecordList {
    ArrayList<Record> records = new ArrayList<>();

    public ArrayList<Record> addRecord(Record record) {
        records.add(record);
        return records;
    }

    public ArrayList<Record> editRecord(int recordId, String visitDate, String treatment, String notes, int petId) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).recordId == recordId) {
                records.get(i).visitDate = visitDate;
                records.get(i).treatment = treatment;
                records.get(i).notes = notes;
                records.get(i).petId = petId;
                System.out.println("Cập nhật thông tin thành công cho hồ sơ ID: " + recordId);
            }
        }
        return records;
    }

    public ArrayList<Record> deleteRecord(int recordId) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).recordId == recordId) {
                records.remove(i);
                System.out.println("Đã xóa hồ sơ với ID: " + recordId);
            }
        }
        return records;
    }

    public void printRecordList() {
        if (records.isEmpty()) {
            System.out.println("Danh sách hồ sơ trống.");
        } else {
            for (Record record : records) {
                System.out.println("Record ID: " + record.recordId +
                                   ", Visit Date: " + record.visitDate +
                                   ", Treatment: " + record.treatment +
                                   ", Notes: " + record.notes +
                                   ", Pet ID: " + record.petId);
            }
        }
    }
}
}
