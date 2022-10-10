/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.GianHangDAL;
import bookstore.Entity.GianHang;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Nhom5
 */
public class GianHangBLL {
    GianHangDAL obj = new GianHangDAL();
    
    public ArrayList<GianHang> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    public boolean insertData(GianHang data){
        return obj.insertData(data);
    }
    public boolean updateData(GianHang data){
        return obj.updateData(data);
    }
    public boolean deleteData(String id){
        return obj.deleteData(id);
    }
    public String getTenByID(String id) {
    	return obj.getTenByID(id);
    }
    public String getIDByName(String name) {
    	return obj.getIdByName(name);
    }
    
}
