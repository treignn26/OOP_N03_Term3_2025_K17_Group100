public void capNhatTinhTrangSucKhoe(LocalDate ngayHienTai, List<Record> danhSachHoSo) {
    System.out.println("Cập nhật tình trạng sức khỏe cho các thú cưng có lịch khám ngày " + ngayHienTai + ":");
    boolean coLich = false;

    for (Record hoSo : danhSachHoSo) {
        if (hoSo.getDate().equals(ngayHienTai)) {
            System.out.println("\nHồ sơ thú cưng:");
            hoSo.display();

            // Nhập dữ liệu cập nhật
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập tình trạng sức khỏe (Bình thường / Cần theo dõi / Cần điều trị):");
            hoSo.setTinhTrang(scanner.nextLine());

            System.out.println("Nhập ghi chú y tế:");
            hoSo.setGhiChuYTe(scanner.nextLine());

            System.out.println("Nhập tên thuốc (hoặc để trống):");
            String tenThuoc = scanner.nextLine();
            if (!tenThuoc.isEmpty()) {
                System.out.println("Nhập số lượng thuốc:");
                hoSo.setThuoc(tenThuoc, scanner.nextInt());
                scanner.nextLine(); // Bỏ qua dòng mới
            }

            System.out.println("Nhập ngày tái khám (yyyy-MM-dd hoặc để trống):");
            String ngayTaiKham = scanner.nextLine();
            if (!ngayTaiKham.isEmpty()) {
                hoSo.setNgayTaiKham(LocalDate.parse(ngayTaiKham));
            }

            System.out.println("Đã cập nhật hồ sơ:");
            hoSo.display();
            coLich = true;
        }
    }

    if (!coLich) {
        System.out.println("Không có thú cưng nào có lịch khám trong ngày " + ngayHienTai + ".");
    }
}
