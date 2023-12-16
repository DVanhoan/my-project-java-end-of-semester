package Test;

import Model.KhachHang;
import Model.Sach;
import dao.DAOKhachHang;
import dao.SachDAO;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class TestSachDAO {
    public static void main(String[] args) {

        // thêm mới sách cho nhà sách
//
//        Sach sach1 = new Sach("LTJV", "Lập trình Java", 50000, 2025);
//        Sach sach2 = new Sach("LTC", "Lập trình C++", 70000, 2030);
//        Sach sach3 = new Sach("Giaitich", "GiaiTich", 1000000, 2030);
//        Sach sach4 = new Sach("ls", "lich su", 1000000, 2030);

//
//        SachDAO.getInstance().insert(sach4);



        // sửa thông tin sách của nhà sách
//        Sach sach1 = new Sach("LTJV", "Lập trình Java", 1000000, 2025);
//        SachDAO.getInstance().update(sach1);



          //xóa sách trong nhà sách.
//        Sach sach1 = new Sach("LTJV", "Lập trình Java", 1000000, 2025);
//        SachDAO.getInstance().delete(sach1);





          SachDAO.getInstance().selectAll();


    }
}
