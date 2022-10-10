package bookstore.BLL;

import bookstore.DAL.HoaDonNhapDAL;

/**
 * 
 * @author Nhom5
 *
 */
public class HoaDonNhapBLL {
	HoaDonNhapDAL dao = new HoaDonNhapDAL();
	public void inHoaDon(String ma) {
		dao.inHoaDon(ma);
	}
}
