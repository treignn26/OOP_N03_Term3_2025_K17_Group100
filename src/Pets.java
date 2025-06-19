package models;
    
public class Pets{
    private int id;
    private String name;
    private String species;
    private int age;
    private Owner owner;

    public Pets(int id, String name, String species, int age, Owner owner) {
       try {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.owner = owner;
       } catch(Exception e) {
            System.err.println("Loi khi khoi tao Pet: " + e.getMessage());
        } finally {
        }
    }

    public void updateInfo(String name, String species, int age) {
        try {
        this.name = name;
        this.species = species;
        this.age = age;
                } catch (Exception e) {
            System.err.println("Loi khi cap nhat thong tin thu cung: " + e.getMessage());
        } finally {
        }
    }

    
    public String toString() {
        try {
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", owner=" + (owner != null ? owner.getName() : "No owner") +
                '}';
                        } catch (Exception e) {
            System.err.println("Loi khi chuyen Pet sang chuoi: " + e.getMessage());
            return "Thong tin thu cung loi";
        } finally {
        }
    }
}
