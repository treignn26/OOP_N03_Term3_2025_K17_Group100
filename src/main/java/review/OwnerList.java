package main.java.review;
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
                owners.get(i).name = name;
                owners.get(i).phone = phone;
                owners.get(i).address = address;
                System.out.println("Cap nhap thong tin thanh cong cho chu nuoi ID: " + ownerId);
            }
        }
        return owners;
    }

    public ArrayList<Owner> deleteOwner(int ownerId) {
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).ownerId == ownerId) {
                owners.remove(i);
                System.out.println("Da xoa chu nuoi voi ID: " + ownerId);
            }
        }
        return owners;
    }

    public void printOwnerList() {
        if (owners.isEmpty()) {
            System.out.println("Danh sach chu nuoi trong.");
        } else {
            for (Owner owner : owners) {
                System.out.println("Owner ID: " + owner.ownerId + 
                                   ", Fullname: " + owner.name + 
                                   ", Phone Number: " + owner.phone + 
                                   ", Address: " + owner.address);
            }
        }
    }
}

