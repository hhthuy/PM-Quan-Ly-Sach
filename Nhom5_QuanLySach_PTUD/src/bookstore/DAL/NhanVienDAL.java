package bookstore.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bookstore.Entity.NhanVien;

public class NhanVienDAL extends SqlDataConnection{
	public ArrayList<NhanVien> getAllNhanVien() {
		String sql = "select * from tb_NhanVien";
		ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
		NhanVien nv = null;
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nv  = new NhanVien();
				nv.setMaNhanVien(rs.getString(1));
				nv.setTenNhanVien(rs.getString(2));
				nv.setSDT(rs.getString(3));
				nv.setDiaChi(rs.getString(4));
				nv.setChucVu(rs.getString(5));
				ls.add(nv);
				}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public boolean addNhanVien(NhanVien s) {
		boolean check = false;
		String sql = "insert into tb_NhanVien(maNhanVien,tenNhanVien,sdt,diaChi,chucVu) values (?,?,?,?,?)";
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getMaNhanVien());
			ps.setString(2, s.getTenNhanVien());
			ps.setString(3, s.getSDT());
			ps.setString(4, s.getDiaChi());
			ps.setString(5, s.getChucVu());
			int rs = ps.executeUpdate();
			if(rs>0) {
				check = true;
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public boolean deleteNhanVien(String id) {
		boolean check = false;
		String sql = "delete from tb_NhanVien where maNhanVien = ?";
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int kq = ps.executeUpdate();
			if(kq>0) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public boolean updateNhanVien(NhanVien nv) {
		boolean check = false;
		String sql = "update tb_NhanVien set tenNhanVien = ?,sdt = ?,diaChi = ?,chucVu = ? where maNhanVien = ?";
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nv.getTenNhanVien());
			ps.setString(2, nv.getSDT());
			ps.setString(3, nv.getDiaChi());
			ps.setString(4, nv.getChucVu());
			ps.setString(5, nv.getMaNhanVien());
			int kq = ps.executeUpdate();
			if(kq>0) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public ArrayList<NhanVien> searchNhanVien(String name) {
		ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
		String sql = "select * from tb_NhanVien where tenNhanVien like N'"+"%"+"+name+"+"%"+"'";
		try {
			openConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(rs.getString(1));
				nv.setTenNhanVien(rs.getString(2));
				nv.setSDT(rs.getString(3));
				nv.setDiaChi(rs.getString(4));
				nv.setChucVu(rs.getString(5));
				ls.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public ArrayList<NhanVien> searchNhanVien(NhanVien nhanvien){
		ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
		String sql = "select * from tb_NhanVien";
		String where = "";
		try {
			if(nhanvien.getTenNhanVien()!=null) {
				where += "tenNhanVien like ? AND ";
			}
			if(nhanvien.getSDT()!=null) {
				where += "sdt = ? AND ";
			}
			if(nhanvien.getDiaChi()!=null) {
				where += "diaChi like ? AND ";
			}
			if(where.length()>0) {
				sql += " where "+where.substring(0,where.length()-5);
			}
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			int i =1;
			if(nhanvien.getTenNhanVien()!=null) {
				ps.setString(i++, "%"+nhanvien.getTenNhanVien()+"%");
			}
			if(nhanvien.getSDT()!=null) {
				ps.setString(i++, nhanvien.getSDT());
			}
			if(nhanvien.getDiaChi()!=null) {
				ps.setString(i++, "%"+nhanvien.getDiaChi()+"%");
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(rs.getString(1));
				nv.setTenNhanVien(rs.getString(2));
				nv.setSDT(rs.getString(3));
				nv.setDiaChi(rs.getString(4));
				nv.setChucVu(rs.getString(5));
				ls.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
