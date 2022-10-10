package bookstore.BLL;

import java.util.ArrayList;

import bookstore.DAL.BaoCaoBanChayDAL;
import bookstore.Entity.BaoCaoBanChay;

public class BaoCaoBanChayBLL {
	private BaoCaoBanChayDAL dao = new BaoCaoBanChayDAL();
	public ArrayList<BaoCaoBanChay> getAll(String where){
		return dao.getAll(where);
	}
	public void inBaoCao(String ngay1,String ngay2) {
		dao.inBaoCao(ngay1, ngay2);
	}
}
