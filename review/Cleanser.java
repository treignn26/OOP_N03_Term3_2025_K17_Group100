import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Cleanser {

    private List<Record> danhSachHoSo = new ArrayList<>();

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.fakeData();

        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n=== PHONG KHAM THU CUNG  ===");
            System.out.println("1. Hien thi lich kham hom nay");
            System.out.println("2. Cap nhat tinh trang thu cung");
            System.out.println("3. In hoa don benh nhan");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); 
            try {
                    luaChon = scanner.nextInt();
                    scanner.nextLine(); // bỏ ký tự xuống dòng
                } catch (InputMismatchException e) {
                    System.err.println("Loi: Vui long nhap mot so nguyen cho lua chon cac chuc nang.");
                    scanner.nextLine(); // Xóa input không hợp lệ để tránh vòng lặp vô hạn
                    luaChon = -1; // Đặt giá trị không hợp lệ để lặp lại menu
                    continue; // Quay lại đầu vòng lặp do-while
                }
            switch (luaChon) {
                case 1:
                    cleanser.hienThiLichKhamTrongNgay(LocalDate.now());
                    break;

                case 2:
                    System.out.print("Ten thu cung: ");
                    String tenTC = scanner.nextLine();
                    System.out.print("Tinh trang: ");
                    String tinhTrang = scanner.nextLine();
                    System.out.print("Ghi chu: ");
                    String ghiChu = scanner.nextLine();
                    System.out.print("Ngay tai kham (yyyy-mm-dd): ");
                    LocalDate taiKham = LocalDate.parse(scanner.nextLine());

                    cleanser.capNhatTinhTrang(tenTC, tinhTrang, ghiChu, taiKham);
                    try {
                        taiKham = LocalDate.parse(scanner.nextLine());
                        cleanser.capNhatTinhTrang(tenTC, tinhTrang, ghiChu, taiKham);
                    } catch (DateTimeParseException e) {
                        System.err.println("Loi: Dinh dang ngay khong hop le. Vui long nhap theo dinh dang yyyy-mm-dd.");
                    } catch (Exception e) { // Bắt các lỗi khác có thể xảy ra trong capNhatTinhTrang
                        System.err.println("Da xay ra loi khi cap nhap tinh trang thu cung: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Ten thu cung can in hoa don: ");
                    String tenHoaDon = scanner.nextLine();

                    // dữ liệu mẫu
                    List<String> dichVu = Arrays.asList("Kham tong quat", "Tiem ngua");
                    List<Double> gia = Arrays.asList(150_000.0, 250_000.0);

                    cleanser.inHoaDon(tenHoaDon, dichVu, gia);
                    try {
                        cleanser.inHoaDon(tenHoaDon, dichVu, gia);
                    } catch (Exception e) {
                        System.err.println("Da xay ra loi khi in hoa don: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (luaChon != 0);

        scanner.close();
    }

    public void hienThiLichKhamTrongNgay(LocalDate ngayHienTai) {
        try {
            System.out.println("Lich kham ngay " + ngayHienTai + ":");
            boolean coLich = false;
            // Giả sử danhSachHoSo có thể null hoặc có lỗi khi truy cập
            if (danhSachHoSo == null) {
                throw new IllegalStateException("Danh sach ho tro chua duoc khoi tao.");
            }
            if (danhSachHoSo.isEmpty()) {
                System.out.println("Danh sach ho so rong.");
            } else {
                for (Record hoSo : danhSachHoSo) {
                    if (hoSo == null) { // Xử lý trường hợp có null trong danh sách
                        System.err.println("Canh bao: Co ho so rong trong danh sach, bo qua.");
                        continue;
                    }
                    if (hoSo.getDate() != null && hoSo.getDate().equals(ngayHienTai)) {
                        hoSo.display();
                        coLich = true;
                    }
                }
            }
            if (!coLich) {
                System.out.println("Khong co thu cung nao co lịch kham trong ngay.");
            }
        } catch (IllegalStateException e) {
            System.err.println("Loi he thong: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Da xay ra loi khi hien thi lich kham: " + e.getMessage());
        }
      
    }

    public void capNhatTinhTrang(String tenThuCung, String tinhTrang, String ghiChu, LocalDate ngayTaiKham) {
        boolean found = false;
        for (Record hoSo : danhSachHoSo) {
            if (hoSo.getPet().getName().equalsIgnoreCase(tenThuCung)) {
                hoSo.setTinhTrang(tinhTrang);
                hoSo.setGhiChuYTe(ghiChu);
                hoSo.setNgayTaiKham(ngayTaiKham);
                System.out.println("Da cap nhat ho so:");
                hoSo.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay thu cung co ten " + tenThuCung);
        }
    }

    public void inHoaDon(String tenThuCung, List<String> dichVu, List<Double> giaTien) {
        for (Record hoSo : danhSachHoSo) {
            if (hoSo.getPet().getName().equalsIgnoreCase(tenThuCung)) {
                System.out.println("========== HOA DON ==========");
                System.out.println("Thu cung: " + tenThuCung);
                System.out.println("Chu nuoi: " + hoSo.getPet().getOwnerName());

                double tongTien = 0;
                for (int i = 0; i < dichVu.size(); i++) {
                    System.out.printf("- %s: %.0f VND\n", dichVu.get(i), giaTien.get(i));
                    tongTien += giaTien.get(i);
                }

                System.out.printf("Tong cong: %.0f VND\n", tongTien);
                System.out.println("=============================");
                return;
            }
        }
        System.out.println("Khong tim thay thu cung co ten " + tenThuCung);
    }

    public void fakeData() {
        try {
        Pet p1 = new Pet("Milu", "Nguyen Van A");
        Pet p2 = new Pet("Tom", "Le Thi B");

        Record r1 = new Record(p1, LocalDate.now());
        Record r2 = new Record(p2, LocalDate.now().plusDays(1));

        danhSachHoSo.add(r1);
        danhSachHoSo.add(r2);
        System.out.println("Du lieu mau da duoc khoi tao thanh cong.");
        } catch (Exception e) {
            System.err.println("Loi khi tao du lieu mau: " + e.getMessage());
        }
    }
}
