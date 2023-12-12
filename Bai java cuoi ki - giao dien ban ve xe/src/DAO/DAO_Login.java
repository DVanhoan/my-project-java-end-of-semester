package DAO;

import Model.NguoiDung;
import Program.ConnectMySQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Login implements DAOInterface<NguoiDung>{
    private PreparedStatement stmt;

    public static DAO_Login getInstance(){
        return new DAO_Login();
    }
    @Override
    public int insert(NguoiDung nguoiDung) throws SQLException {
        ConnectMySQL con = (ConnectMySQL) ConnectMySQL.getConnection();
        int ketQua = 0;



        return ketQua;
    }

    @Override
    public int update(NguoiDung nguoiDung) {
        return 0;
    }

    @Override
    public int delete(NguoiDung nguoiDung) {
        return 0;
    }

    @Override
    public ArrayList<NguoiDung> selectAll() {
        return null;
    }

    @Override
    public int select_Login(NguoiDung nguoiDung) {
        return 0;
    }

    @Override
    public ArrayList<NguoiDung> selectByCondition(String condition) {
        return null;
    }
}
