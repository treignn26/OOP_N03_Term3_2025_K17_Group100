import java.sql.PreparedStatement;
import java.sql.SQLException;

public void cap_nhat_tinh_trang_suc_khoe(
    string id,
    string tinh_trang,
    string ghi_chu,
    string ten_thuoc,
    int so_luong_thuoc,
    string ngay_hen_tai_kham
) {
    string query = "UPDATE thu_cung SET tinh_trang = ?, ghi_chu = ?, ten_thuoc = ?, so_luong_thuoc = ?, ngay_tai_kham = ? WHERE id = ?";
    try (PreparedStatement stmt = connection.PreparedStatement(query)) {
        stmt.setString(1, tinh_trang);
        stmt.setString(2, ghi_chu);
        stmt.setString(3, ten_thuoc);
        stmt.setString(4, so_luong_thuoc);    
        stmt.setString(5, ngay_hen_tai_kham);
        stmt.setString(6, id);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0){
            System.out.println("Cap nhat tinh trang suc khoe thu cung thanh cong!");
        } else {
            System.out.println("Khong tim thay thu cung voi Id: " + id);
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
}