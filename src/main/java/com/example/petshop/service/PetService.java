package com.example.petshop.service;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.petshop.model.Pet;
import com.example.petshop.repository.PetRepository;

@Service @RequiredArgsConstructor
public class PetService {

    private final PetRepository repo;//loi o day

    public List<Pet> all()        { return repo.findAll(); }
    public Pet save(Pet p)        { return repo.save(p);   }
    public void delete(String c)  { repo.deleteByCode(c);  }
    public Pet rename(String c, String newName) {
        Pet p = repo.findByCode(c);
        if (p == null) return null;
        p.setName(newName);//va day
        return repo.save(p);
    }
}