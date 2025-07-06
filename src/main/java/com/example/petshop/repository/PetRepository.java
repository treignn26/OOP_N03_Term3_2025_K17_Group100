package com.example.petshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petshop.model.Pet;
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByCode(String code);
    void deleteByCode(String code);
}
