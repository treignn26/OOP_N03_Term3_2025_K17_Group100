package src.main.java.com.group100.petclinic;


import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String ownerId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<Pet> pets;

    public Owner(String ownerId, String name, String address, String phone, String email) {
        this.ownerId = ownerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.pets = new ArrayList<>();
    }

    public String getOwnerId() {
    return ownerId;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(int petId) {
        pets.removeIf(pet -> pet.getId() == petId);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", pets=" + pets +
                '}';
    }
}
