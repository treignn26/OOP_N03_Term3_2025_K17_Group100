package review;

public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private Owner owner;

    public Pet(int id, String name, String species, int age, Owner owner) {
        try {
            this.id = id;
            this.name = name;
            this.species = species;
            this.age = age;
            this.owner = owner;
        } catch (Exception e) {
            System.err.println("Lỗi khi khởi tạo Pet: " + e.getMessage());
        }
    }

    public int getId() {
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
        return (owner != null) ? owner.getName() : "Không có chủ";
    }

    public void updateInfo(String name, String species, int age) {
        try {
            this.name = name;
            this.species = species;
            this.age = age;
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật thông tin thú cưng: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        try {
            return "Pet{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", species='" + species + '\'' +
                    ", age=" + age +
                    ", owner=" + getOwnerName() +
                    '}';
        } catch (Exception e) {
            System.err.println("Lỗi khi chuyển Pet sang chuỗi: " + e.getMessage());
            return "Thông tin thú cưng lỗi";
        }
    }
}
