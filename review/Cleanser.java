import java.time.LocalDate;
import java.util.*;

public class Cleanser {

    private List<Record> danhSachHoSo = new ArrayList<>();

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.fakeData(); // tạo dữ liệu mẫu

        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n=== PHONG KHAM THU CUNG  ===");
            System.out.println("1. Hien thi lich kham hom nay");
            System.out.println("2. Cap nhap tinh trang thu cung");
            System.out.println("3. In hoa don benh nhan");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // bỏ ký tự xuống dòng

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
                    break;

                case 3:
                    System.out.print("Ten thu cung can in hoa don: ");
                    String tenHoaDon = scanner.nextLine();

                    // dữ liệu mẫu
                    List<String> dichVu = Arrays.asList("Kham tong quat", "Tiem ngua");
                    List<Double> gia = Arrays.asList(150_000.0, 250_000.0);

                    cleanser.inHoaDon(tenHoaDon, dichVu, gia);
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;

                default:
                    System.out.println(" Lua chon khong hop le.");
            }

        } while (luaChon != 0);

        scanner.close();
    }

    // ----------------------------
    // Dưới đây là các phương thức từ bài trước đã điều chỉnh
    // ----------------------------

   public void hienThiLichKhamTrongNgay(LocalDate ngayHienTai) {
    System.out.println("Lich kham ngay " + ngayHienTai + ":");
    boolean coLich = false;
    for (Record hoSo : danhSachHoSo) {
        if (hoSo.getDate().equals(ngayHienTai)) {
            hoSo.display();
            coLich = true;
        }
    }
    if (!coLich) {
        System.out.println("Khong co thu cung nao co lịch kham trong ngay.");
    }
}



   public void capNhatTinhTrangSucKhoe(LocalDate ngayHienTai, List<Record> danhSachHoSo) {
    System.out.println("Cap nhap tinh trang suc khoe co lich kham trong ngay " + ngayHienTai + ":");
    boolean coLich = false;

    for (Record hoSo : danhSachHoSo) {
        if (hoSo.getDate().equals(ngayHienTai)) {
            System.out.println("\nHo so thu cung:");
            hoSo.display();

            // Nhập dữ liệu cập nhật
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap tinh trang suc khoe :");
            hoSo.setTinhTrang(scanner.nextLine());

            System.out.println("Nhap ghi chu y te:");
            hoSo.setGhiChuYTe(scanner.nextLine());

            System.out.println("Nhap ten thuoc (hoac de trong):");
            String tenThuoc = scanner.nextLine();
            if (!tenThuoc.isEmpty()) {
                System.out.println("Nhap so luong thuoc:");
                hoSo.setThuoc(tenThuoc, scanner.nextInt());
                scanner.nextLine(); // Bỏ qua dòng mới
            }

            System.out.println("Nhap ngay tai kham (yyyy-MM-dd hoac de trong:");
            String ngayTaiKham = scanner.nextLine();
            if (!ngayTaiKham.isEmpty()) {
                hoSo.setNgayTaiKham(LocalDate.parse(ngayTaiKham));
            }

            System.out.println("Da cap nhap ho so:");
            hoSo.display();
            coLich = true;
        }
    }

    public void inHoaDon(String tenThuCung, List<String> dichVu, List<Double> giaTien, List<Record> danhSachHoSo) {
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

    // ----------------------------
    // Dữ liệu mẫu để test
    // ----------------------------
    public void fakeData() {
        Pet p1 = new Pet("Milu", "Nguyen Van A");
        Pet p2 = new Pet("Tom", "Le Thi B");

        Record r1 = new Record(p1, LocalDate.now());
        Record r2 = new Record(p2, LocalDate.now().plusDays(1));

        danhSachHoSo.add(r1);
        danhSachHoSo.add(r2);
    }
}
