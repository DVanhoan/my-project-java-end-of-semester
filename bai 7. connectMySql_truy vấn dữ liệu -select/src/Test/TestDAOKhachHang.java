package Test;

import Model.KhachHang;
import dao.DAOKhachHang;

import java.sql.Date;

public class TestDAOKhachHang {
    public static void main(String[] args) {
        //thêm mới cho bảng khách hàng mua sách



        KhachHang khachHang = new KhachHang(101, "Vi Văn Toán",new Date(21-3-2003), "Đà Nẵng");
        KhachHang khachHang2 = new KhachHang(102, "Vi Thành Việt",new Date(21-3-2004), "Đà Nẵng");
        KhachHang khachHang3 = new KhachHang(103, "Vi Hồng Thao",new Date(21-7-2003), "Đà Nẵng");
        KhachHang khachHang4 = new KhachHang(104, "Vi Văn Hiến",new Date(21-3-2002), "Hà Nội");
//        DAOKhachHang.getInstance().insert(khachHang4);
    }
}
