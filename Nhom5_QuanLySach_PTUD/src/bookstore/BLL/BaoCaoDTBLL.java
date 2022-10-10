/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.BaoCaoDTDAL;
import bookstore.Entity.BaoCaoDT;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class BaoCaoDTBLL {
    BaoCaoDTDAL obj = new BaoCaoDTDAL();
    
    public ArrayList<BaoCaoDT> getAll(String w1,String w2){
        return obj.getAll(w1, w2);
    }
    public void inBaoCao(String ngay1,String ngay2) {
    	obj.inBaoCao(ngay1, ngay2);
    }
}
