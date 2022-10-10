/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.SachDAL;
import bookstore.Entity.Sach;
import java.util.ArrayList;

/**
 *
 * @author Nhom5
 */
public class SachBLL {
    SachDAL obj = new SachDAL();
    
    public ArrayList<Sach> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    public boolean insertData(Sach data){
        return obj.insertData(data);
    }
    public boolean updateData(Sach data){
        return obj.updateData(data);
    }
    public boolean deleteData(String id){
        return obj.deleteData(id);
    }
    public String getIDByName(String ten) {
    	return obj.getIDByName(ten);
    }
    public ArrayList<Sach> searchSach(String ten,String tacgia,String manxb,String magh){
    	Sach s = new Sach();
    	s.setTieuDe(ten);
    	s.setTacGia(tacgia);
    	s.setMaNXB(manxb);
    	s.setMaGianHang(magh);
    	return obj.searchSach(s);
    }
    public String getNameByID(String id) {
    	return obj.getNameById(id);
    }
    public ArrayList<Sach> searchSach(String id) {
    	return obj.searchByNXB(id);
    }
}
