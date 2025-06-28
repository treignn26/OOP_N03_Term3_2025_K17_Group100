package src.main.java.com.group100.petclinic;

import java.util.ArrayList;

public class OwnerList {
    ArrayList<Owner> owners = new ArrayList<>();

    public ArrayList<Owner> addOwner(Owner owner) {
        owners.add(owner);
        return owners;
    }

    public ArrayList<Owner> editOwner(String fullname, String phoneNumber, String address, String ownerId) {
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getOwnerId().equals(ownerId)) {
                Owner o = owners.get(i);
                owners.set(i, new Owner(ownerId, fullname, address, phoneNumber, o.getEmail()));
                System.out.println("Cap nhat thanh cong cho chu nuoi co ID: " + ownerId);
            }
        }
        return owners;
    }

    public ArrayList<Owner> deleteOwner(String ownerId) {
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getOwnerId().equals(ownerId)) {
                owners.remove(i);
                System.out.println("Da xoa chu nuoi co ID: " + ownerId);
                break;
            }
        }
        return owners;
    }

    public void printOwnerList() {
        if (owners.isEmpty()) {
            System.out.println("Danh sach chu nuoi trong.");
        } else {
            for (Owner owner : owners) {
                System.out.println("Owner ID: " + owner.getOwnerId() + 
                                   ", Fullname: " + owner.getName() + 
                                   ", Phone Number: " + owner.getPhone() + 
                                   ", Address: " + owner.getAddress());
            }
        }
    }
}
