package models;

public class Pet{
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

    public void updateInfo(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", owner=" + (owner != null ? owner.getName() : "No owner") +
                '}';
    }
}
