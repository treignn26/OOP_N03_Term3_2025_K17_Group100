public void hienThiLichKhamTrongNgay(LocalDate ngayHienTai, List<Record> danhSachHoSo) {
    System.out.println("Lịch khám ngày " + ngayHienTai + ":");
    boolean coLich = false;
    for (Record hoSo : danhSachHoSo) {
        if (hoSo.getDate().equals(ngayHienTai)) {
            hoSo.display();
            coLich = true;
        }
    }
    if (!coLich) {
        System.out.println("Không có thú cưng nào có lịch khám trong ngày.");
    }
}
