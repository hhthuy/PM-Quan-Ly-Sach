package bookstore.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bookstore.Entity.KhachHang;

public class KhachHangDAL extends SqlDataConnection {

    private final String INSERT = "insert into tb_KhachHang(maKH,tenKH,sdt,diachi)"
            + " values(?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_KhachHang] SET [tenKH] = ? ,[sdt] = ?"
            + " ,[diachi] = ? WHERE [maKH] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_KhachHang] WHERE maKH = ?";

    public ArrayList<KhachHang> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "Select * FROM [dbo].[tb_KhachHang]";
        ArrayList<KhachHang> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_KhachHang ";
            if (WHERE.length() != 0) {
                GET_ALL += "WHERE " + WHERE;
            }
            if (ORDER.length() != 0) {
                GET_ALL += "ORDER BY " + ORDER;
            }
        }
//        System.out.println(GET_ALL);
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMakhachhang(rs.getString("maKH"));
                    kh.setTenkhachhang(rs.getString("tenKH"));
                    kh.setSdt(rs.getString("sdt"));
                    kh.setDiachi(rs.getString("diachi"));
                    arr.add(kh);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    public ArrayList<KhachHang> getAllKhachHang(){
    	ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
    	String sql = "select * from tb_KhachHang";
    	try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMakhachhang(rs.getString(1));
                    kh.setTenkhachhang(rs.getString(2));
                    kh.setSdt(rs.getString(3));
                    kh.setDiachi(rs.getString(4));
                    arr.add(kh);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public boolean insertData(KhachHang data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMakhachhang());
            ps.setString(2, data.getTenkhachhang());
            ps.setString(3, data.getSdt());
            ps.setString(4, data.getDiachi());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateData(KhachHang data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getTenkhachhang());
            ps.setString(2, data.getSdt());
            ps.setString(3, data.getDiachi());
            ps.setString(4, data.getMakhachhang());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteData(String id) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(DELETE);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public ArrayList<KhachHang> searchKhachHang(KhachHang kh){
    	ArrayList<KhachHang> ls = new ArrayList<KhachHang>();
    	try {
			openConnection();
			String sql = "SELECT * FROM tb_KhachHang";
            String where = "";
			if (kh.getMakhachhang() != null) {
                where += "[maKH] like ? AND ";
            }
            if (kh.getTenkhachhang() != null) {
                where += "[tenKH] like ? AND ";
            }
            if (kh.getSdt() != null) {
                where += "[sdt]=? AND ";
            }
            if (kh.getDiachi() != null) {
                where += "[diaChi] like ? AND ";
            }
            if (where.length() > 0) {
                sql += " WHERE " + where.substring(0, where.length() - 5);
            }
            PreparedStatement stmt = con.prepareStatement(sql);
            int i = 1;
            if (kh.getMakhachhang() != null) {
                stmt.setString(i++, "%" + kh.getMakhachhang() + "%");
            }
            if (kh.getTenkhachhang() != null) {
                stmt.setString(i++, "%" +kh.getTenkhachhang() + "%");
            }
            if (kh.getSdt() != null) {
                stmt.setString(i++, kh.getSdt());
            }
            if (kh.getDiachi() != null) {
                stmt.setString(i++, "%" + kh.getDiachi() + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	KhachHang s = new KhachHang();
            	s.setMakhachhang(rs.getString(1));
            	s.setTenkhachhang(rs.getString(2));
            	s.setSdt(rs.getString(3));
            	s.setDiachi(rs.getString(4));
            	ls.add(s);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ls;
    }
}
