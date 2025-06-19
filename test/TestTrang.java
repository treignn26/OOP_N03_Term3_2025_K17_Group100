import java.time.LocalDate;
import java.util.ArrayList;

import main.java.review.AppointmentList;
import main.java.review.Pet;
import main.java.review.PetList;

public class TestTrang {
    public static void main(String[] args) {
        Pet pet1 = new Pet(1, "Buddy", "Cho", "Nguyen Van A");
        Pet pet2 = new Pet(2, "Whiskers", "Meo", "Tran Thi B");
        PetList petList = new PetList();
        petList.addPet(pet1);
        petList.addPet(pet2);

        Appointment app1 = new Appointment(101, 1, LocalDate.now(), "Kiem tra tong quat");
        Appointment app2 = new Appointment(102, 2, LocalDate.now(), "Tiem phong dai");
        Appointment app3 = new Appointment(103, 1, LocalDate.now().plusDays(1), "Tai kham");

        AppointmentList appList = new AppointmentList(); 
        appList.addAppointment(app1);
        appList.addAppointment(app2);
        appList.addAppointment(app3);

        LocalDate today = appList.getTodayDate();
        System.out.println("Ngay hien tai: " + today);

        ArrayList<Appointment> todayAppointments = appList.filterAppointmentsByDate(today, appList.getAllAppointments());

        System.out.println("\n--- Lich hen da loc trong ngay " + today + " ---");
        if (todayAppointments.isEmpty()) {
            System.out.println("Khong co lich hen trong ngay hom nay.");
        } else {
            for (Appointment app : todayAppointments) {
                Pet pet = petList.getPetDetails(app.getPetId()); 
                if (pet != null) {
                    System.out.println("ID Lich Hen: " + app.getAppointmentId() +
                                       " | Pet: " + pet.getName() +
                                       " | Loai: " + pet.getSpecies() +
                                       " | Chu: " + pet.getOwnerName() +
                                       " | Ly do: " + app.getReason());
                } else {
                    System.out.println("Loi: Không tim thay thong tin thu cung (ID: " + app.getPetId() + ") cho lich hen ID: " + app.getAppointmentId());
                }
            }
        }
        System.out.println("-----------------------------------------");
    }
}