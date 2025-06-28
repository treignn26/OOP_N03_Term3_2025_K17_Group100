package src.main.java.com.group100.petclinic.controller;
import src.main.java.com.group100.petclinic.model.Pet;
import src.main.java.com.group100.petclinic.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;
    private static final Logger logger = LoggerFactory.getLogger(PetController.class);

    public PetController(PetService petService) {
        this.petService = petService;
}
// GET /pets
    @GetMapping
    public String listPets(Model model) {
        try {
            List<Pet> pets = petService.getAllPets();
            model.addAttribute("pets", pets);
            return "pet-list";
        } catch (Exception e) {
            logger.error("Lỗi khi lấy danh sách thú cưng", e);
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        } finally {
            // để trống – placeholder theo yêu cầu
        }
    }

    // POST /pets
    @PostMapping
    public String addPet(@ModelAttribute Pet pet, Model model) {
        try {
            petService.savePet(pet);
            return "redirect:/pets";
        } catch (Exception e) {
            logger.error("Lỗi khi lưu thú cưng", e);
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}