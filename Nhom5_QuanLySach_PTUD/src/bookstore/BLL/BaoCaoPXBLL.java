/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.BaoCaoPXDAL;
import bookstore.Entity.BaoCaoPX;
import java.util.ArrayList;

/**
 *
 * @author Nhom5
 */
public class BaoCaoPXBLL {
    BaoCaoPXDAL obj = new BaoCaoPXDAL();
    public ArrayList<BaoCaoPX> getAll(String where,String order){
        return obj.getAll(where,order);
    }
    public void inBaoCao(String ngay1,String ngay2) {
    	obj.inBaoCao(ngay1, ngay2);
    }
}
