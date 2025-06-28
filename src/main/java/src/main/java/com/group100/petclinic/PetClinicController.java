package src.main.java.com.group100.petclinic;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetClinicController {

    @GetMapping("/today-appointments")
    public String showTodayAppointments(Model model) {

        Owner ownerA = new Owner("O001", "Nguyen Van A", "123 Duong ABC, Ha Noi", "0123456789", "a@example.com");
        Owner ownerB = new Owner("O002", "Le Thi B", "456 Duong XYZ, Ha Noi", "0987654321", "b@example.com");

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1, "Buddy", "Cho", 3, ownerA));
        pets.add(new Pet(2, "Mimi", "Meo", 2, ownerB));

        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(101, 1, LocalDate.now(), "Kiem tra tong quat"));
        appointments.add(new Appointment(102, 2, LocalDate.now(), "Tiem vac xin"));

        List<String> todayList = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(LocalDate.now())) {
                for (Pet p : pets) {
                    if (p.getId() == a.getPetId()) {
                        todayList.add("Ten: " + p.getName() + " - Loai: " + p.getSpecies()
                                + " - Chu: " + p.getOwnerName() + " - Ly do: " + a.getReason());
                    }
                }
            }
        }

        model.addAttribute("todayList", todayList);
        return "todayAppointments";
    }
}
