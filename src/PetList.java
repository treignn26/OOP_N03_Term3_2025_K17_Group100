import java.util.ArrayList;


class Pet {
  
    public int petId;
  
    public String petFullname; 

public class PetList { 
    ArrayList<Pet> pets = new ArrayList<Pet>(); 

    public ArrayList<Pet> addPet(Pet pet) { 
        pets.add(pet);
        return pets;
    }

    public ArrayList<Pet> getEditPet(String petFullname, int petID) { 
        for (int i = 0; i < pets.size(); i++) { 
            if (pets.get(i).petId == petID) { 
                System.out.print("true");
                pets.get(i).petFullname = petFullname; 
            }
        }
        return pets;
    }

    public ArrayList<Pet> getDeletePet(int petID) { 
        for (int i = 0; i < pets.size(); i++) { 
            if (pets.get(i).petId == petID) { 
                pets.remove(i); 
            }
        }
        return pets;
    }

    public void printPetList() { 
        int len = pets.size(); 
        for (int i = 0; i < len; i++) {
            System.out.println("Pet ID: " + pets.get(i).petId + " Pet Fullname: " + pets.get(i).petFullname); 
        }
    }
}