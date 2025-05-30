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
