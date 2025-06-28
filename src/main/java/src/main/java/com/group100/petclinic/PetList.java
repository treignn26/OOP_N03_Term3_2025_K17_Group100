package src.main.java.com.group100.petclinic;


import java.util.ArrayList;

public class PetList {
    ArrayList<Pet> pets = new ArrayList<Pet>();

    public ArrayList<Pet> addPet(Pet pet) {
        pets.add(pet);
        return pets;
    }

    public ArrayList<Pet> getEditPet(String petFullname, int petID) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == petID) {
                Pet p = pets.get(i);
                p.updateInfo(petFullname, p.getSpecies(), p.getAge());
            }
        }
        return pets;
    }

    public ArrayList<Pet> getDeletePet(int petID) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == petID) {
                pets.remove(i);
                break;
            }
        }
        return pets;
    }

    public void printPetList() {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println("Pet ID: " + pets.get(i).getId() + " Pet Fullname: " + pets.get(i).getName());
        }
    }
}
