import java.util.ArrayList;

public class OwnerList {
    ArrayList<Owner> owners = new ArrayList<>();

    public ArrayList<Owner> addOwner(Owner owner) {
        owners.add(owner);
        return owners;
    }

    public ArrayList<Owner> editOwner(String fullname, String phoneNumber, String address, int ownerId) {
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).ownerId == ownerId) {
                owners.get(i).fullname = fullname;
                owners.get(i).phoneNumber = phoneNumber;
                owners.get(i).address = address;
                System.out.println("Cập nhật thông tin thành công cho chủ nuôi ID: " + ownerId);
            }
        }
        return owners;
    }

    public ArrayList<Owner> deleteOwner(int ownerId) {
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).ownerId == ownerId) {
                owners.remove(i);
                System.out.println("Đã xóa chủ nuôi với ID: " + ownerId);
            }
        }
        return owners;
    }

    public void printOwnerList() {
        if (owners.isEmpty()) {
            System.out.println("Danh sách chủ nuôi trống.");
        } else {
            for (Owner owner : owners) {
                System.out.println("Owner ID: " + owner.ownerId + 
                                   ", Fullname: " + owner.fullname + 
                                   ", Phone Number: " + owner.phoneNumber + 
                                   ", Address: " + owner.address);
            }
        }
    }
}

