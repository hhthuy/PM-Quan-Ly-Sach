/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.BaoCaoPX;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nhom5
 */
public class BaoCaoPXDAL extends SqlDataConnection{
    public ArrayList<BaoCaoPX> getAll(String WHERE, String ORDER) {
        String GET_ALL = "select maPhieuXuat,maKH, ngayXuat,(select sum(soluong)"
                +" from tb_CTPx where tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat)"
                +" as 'SoLuongSach',thanhTien from tb_PhieuXuat";
        ArrayList<BaoCaoPX> arr = new ArrayList<>();
        if (WHERE.length() != 0) {
            GET_ALL += " WHERE " + WHERE;
        }
        if (ORDER.length() != 0) {
            GET_ALL += " ORDER BY " + ORDER;
        }
//        System.out.println(GET_ALL);
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BaoCaoPX item = new BaoCaoPX();
                    item.setMaPhieuXuat(rs.getString("maPhieuXuat"));
                    item.setMaKH(rs.getString("maKH"));
                    item.setNgayXuat(rs.getString("ngayXuat"));
                    item.setSoLuongSach(rs.getInt("SoLuongSach"));
                    item.setThanhTien(rs.getInt("thanhTien"));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    public void inBaoCao(String ngay1, String ngay2) {
    	try {
			openConnection();
			Map map = new HashMap();
			JasperReport report = JasperCompileManager.compileReport("src/HoaDon/BaoCaoBanHang.jrxml");
			map.put("ngayLap", ngay1);
			map.put("ngayLap1",ngay2);
			JasperPrint p = JasperFillManager.fillReport(report, map, con);
			JasperViewer.viewReport(p, false);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
    }
}
