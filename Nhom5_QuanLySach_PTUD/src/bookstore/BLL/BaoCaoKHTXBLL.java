package bookstore.BLL;

import java.util.ArrayList;

import bookstore.DAL.BaoCaoKHTXDAL;
import bookstore.Entity.BaoCaoKHTX;

public class BaoCaoKHTXBLL {
	BaoCaoKHTXDAL dao = new BaoCaoKHTXDAL();
	public ArrayList<BaoCaoKHTX> getAll(String where){
		return dao.getAll(where);
	}
	public void inBaoCao(String s,String s1) {
		dao.inBaoCao(s, s1);
	}
}
