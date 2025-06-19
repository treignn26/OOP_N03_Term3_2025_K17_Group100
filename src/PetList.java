import java.util.ArrayList;

class Pet {
    public int petId;
    public String petFullname;
}

public class PetList {
    ArrayList<Pet> pets = new ArrayList<Pet>();

    public ArrayList<Pet> addPet(Pet pet) {
        try {
            pets.add(pet);
        } catch (Exception e) {
            System.err.println("Loi khi them thu cung: " + e.getMessage());
        } finally {
        }
        return pets;
    }

    public ArrayList<Pet> getEditPet(String petFullname, int petID) {
        try {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).petId == petID) {
                    System.out.print("true");
                    pets.get(i).petFullname = petFullname;
                }
            }
        } catch (Exception e) {
            System.err.println("Loi khi sua thu cung: " + e.getMessage());
        } finally {
        }
        return pets;
    }

    public ArrayList<Pet> getDeletePet(int petID) {
        try {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).petId == petID) {
                    pets.remove(i);
                    break; 
                }
            }
        } catch (Exception e) {
            System.err.println("Loi khi xoa thu cung: " + e.getMessage());
        } finally {
        }
        return pets;
    }

    public void printPetList() {
        try {
            int len = pets.size();
            for (int i = 0; i < len; i++) {
                System.out.println("Pet ID: " + pets.get(i).petId + " Pet Fullname: " + pets.get(i).petFullname);
            }
        } catch (Exception e) {
            System.err.println("Loi khi in danh sach thu cung: " + e.getMessage());
        } finally {
        }
    }
}
