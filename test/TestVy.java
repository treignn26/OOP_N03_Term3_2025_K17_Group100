import java.time.LocalDate;

import main.java.review.Pet;
import main.java.review.PetList;

public class TestVy {
    public static void main(String[] args) {
        try {
            Pet pet1 = new Pet(1, "Buddy", "Cho", "Nguyen Van A");
            Appointment app1 = new Appointment(101, pet1.getPetId(), LocalDate.of(2025, 6, 7), "Kiem tra tong quat");
            PetList clinicPets = new PetList();
            clinicPets.addPet(pet1); 

            System.out.println("Kiem tra doi tuong Pet duoc tao:");
            System.out.println("Pet ID: " + pet1.getPetId() + ", Ten: " + pet1.getName() + ", Chu: " + pet1.getOwnerName());

            System.out.println("\nKiem tra doi tuong Appointment duoc tao:");
            System.out.println("Lich hen ID: " + app1.getAppointmentId() + ", Pet ID lien quan: " + app1.getPetId() + ", Ngay: " + app1.getAppointmentDate());
        } catch (Exception e) {
            System.err.println("Da xay ra loi trong qua trinh test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\nKet thuc chuong trinh test.");
        }
    }
}
