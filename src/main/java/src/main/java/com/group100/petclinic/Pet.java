package src.main.java.com.group100.petclinic;


public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private Owner owner;

    public Pet(int id, String name, String species, int age, Owner owner) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getOwnerName() {
        return (owner != null) ? owner.getName() : "Khong co chu";
    }

    public void updateInfo(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", owner=" + getOwnerName() +
                '}';
    }
}
