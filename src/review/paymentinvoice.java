public void inHoaDon(String tenThuCung, List<String> dichVu, List<Double> giaTien, List<Record> danhSachHoSo) {
    for (Record hoSo : danhSachHoSo) {
        if (hoSo.getPet().getName().equalsIgnoreCase(tenThuCung)) {
            System.out.println("========== HÓA ĐƠN ==========");
            System.out.println("Thú cưng: " + tenThuCung);
            System.out.println("Chủ nuôi: " + hoSo.getPet().getOwnerName());

            double tongTien = 0;
            for (int i = 0; i < dichVu.size(); i++) {
                System.out.printf("- %s: %.0f VND\n", dichVu.get(i), giaTien.get(i));
                tongTien += giaTien.get(i);
            }

            System.out.printf("Tổng cộng: %.0f VND\n", tongTien);
            System.out.println("=============================");
            return;
        }
    }
    System.out.println("Không tìm thấy thú cưng có tên " + tenThuCung);
}
