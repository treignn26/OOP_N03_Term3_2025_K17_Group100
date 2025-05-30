public void hienThiLichKhamTrongNgay(LocalDate ngayHienTai, List<Record> danhSachHoSo) {
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
