package bookstore.BLL;

import java.util.ArrayList;
import bookstore.DAL.KhachHangDAL;
import bookstore.Entity.KhachHang;

public class KhachHangBLL {
	KhachHangDAL obj = new KhachHangDAL();

	public ArrayList<KhachHang> getAll(String top, String where, String order) {
		return obj.getAll(top, where, order);
	}
	public ArrayList<KhachHang> getAllKhachHang(){
		return obj.getAllKhachHang();
	}
	public boolean insertData(KhachHang data) {
		return obj.insertData(data);
	}

	public boolean updateData(KhachHang data) {
		return obj.updateData(data);
	}

	public boolean deleteData(String id) {
		return obj.deleteData(id);
	}
	public ArrayList<KhachHang> searchKhachHang(String ma,String ten,String sdt,String dc){
		KhachHang kh = new KhachHang();
		kh.setMakhachhang(ma);
		kh.setTenkhachhang(ten);
		kh.setSdt(sdt);
		kh.setDiachi(dc);
		KhachHangDAL dao = new KhachHangDAL();
		return dao.searchKhachHang(kh);
	}
}
