package bookstore.BLL;

import java.util.ArrayList;

import bookstore.DAL.NhanVienDAL;
import bookstore.Entity.NhanVien;

public class NhanVienBLL {
	NhanVienDAL dao = new NhanVienDAL();
	public ArrayList<NhanVien> getAllNhanVien(){
		return dao.getAllNhanVien();
	}
	public boolean addNhanVien(NhanVien s) {
		return dao.addNhanVien(s);
	}
	public boolean deleteNhanVien(String id) {
		return dao.deleteNhanVien(id);
	}
	public boolean updateNhanVien(NhanVien nv) {
		return dao.updateNhanVien(nv);
	}
	public ArrayList<NhanVien> searchNhanVien(String name) {
		return dao.searchNhanVien(name);
	}
	public ArrayList<NhanVien> search(String ten,String sdt,String diachi){
		NhanVien s = new NhanVien();
		s.setTenNhanVien(ten);
		s.setDiaChi(diachi);
		s.setSDT(sdt);
		return dao.searchNhanVien(s);
	}
}
