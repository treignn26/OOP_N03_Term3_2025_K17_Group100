package models;


public class Pets {

public class Pet{

    private int id;
    private String name;
    private String species;
    private int age;
    private Owner owner;

    public Pets(int id, String name, String species, int age, Owner owner) {
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
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", owner=" + (owner != null ? owner.getName() : "No owner") +
                '}';
    }
}
