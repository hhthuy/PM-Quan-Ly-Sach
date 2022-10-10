package bookstore.BLL;

import bookstore.DAL.HoaDonBanDAL;

/**
 * 
 * @author Nhom5
 *
 */
public class HoaDonBanBLL {
	HoaDonBanDAL dao = new HoaDonBanDAL();
	public void inHoaDon(String ma) {
		dao.inHoaDon(ma);
	}
}
