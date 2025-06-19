package main.java.review;

import review.Appointment;
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

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1, "Buddy", "Cho", "Nguyen Van A"));
        pets.add(new Pet(2, "Mimi", "Meo", "Le Thi B"));

        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(101, 1, LocalDate.now(), "Kiem tra tong quat"));
        appointments.add(new Appointment(102, 2, LocalDate.now(), "Tiem vac xin"));

        // Tao danh sach hien thi
        List<String> todayList = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(LocalDate.now())) {
                for (Pet p : pets) {
                    if (p.getPetId() == a.getPetId()) {
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

