/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.BaoCaoDT;
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
public class BaoCaoDTDAL extends SqlDataConnection {

    public ArrayList<BaoCaoDT> getAll(String w1, String w2) {
        String GET_ALL;
        ArrayList<BaoCaoDT> arr = new ArrayList<>();
        GET_ALL = "declare @doanhthu int,@tongnhap int,@tongban int;"
        		+ "set @tongnhap=(SELECT SUM(thanhTien) from tb_PhieuNhap where ngayNhap>="+w1+" and ngayNhap<="+w2+"); "
        		+ "set @tongban =(SELECT SUM(thanhTien) FROM tb_PhieuXuat where ngayXuat >="+w1+" and ngayXuat <="+w2+"); "
        		+ "set @doanhthu = @tongban-@tongnhap; "
        		+ "SELECT tb_Sach.maSach, tb_Sach.tieuDe, tb_NXB.tenNXB, tb_GianHang.tenGianHang, tb_Sach.soLuongTon,@tongnhap as 'TongNhap',@tongban as 'TongBan',@doanhthu as 'DoanhThu', "
        		+ "isnull((select sum(soLuong) from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach "
        		+ "and tb_CTPN.maPhieuNhap = tb_PhieuNhap.maPhieuNhap and ngayNhap >= "+w1+" and "
        		+ "ngayNhap <= "+w2+"),0) as 'SLNhap', "
        		+ "isnull((select sum(soLuong) "
        		+ "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
        		+ "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and ngayXuat >= "+w1+" and "
        		+ "ngayXuat <= "+w2+"),0) as 'SLBan' "
        		+ ",(select CONVERT(varchar,GETDATE(),103)) as 'Ngay lap' "
        		+ ",(select CONVERT(varchar,"+w1+",103)) as 'Tu' "
        		+ ",(select CONVERT(varchar,"+w2+",103)) as 'Den' "
        		+ "FROM tb_Sach INNER JOIN tb_GianHang ON tb_Sach.maGianHang = tb_GianHang.maGianHang INNER JOIN tb_NXB ON tb_Sach.maNXB = tb_NXB.maNXB";
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BaoCaoDT item = new BaoCaoDT();
                    item.setMaSach(rs.getString(1));
                    item.setTieuDe(rs.getString(2));
                    item.setTenNXB(rs.getString(3));
                    item.setSoLuongTon(rs.getInt(5));
                    item.setSlNhap(rs.getInt(9));
                    item.setSlXuat(rs.getInt(10));
                    item.setTienNhap(rs.getInt(6));
                    item.setTienBan(rs.getInt(7));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    public void inBaoCao(String ngay1,String ngay2) {
    	try {
			openConnection();
			Map map = new HashMap();
			JasperReport report = JasperCompileManager.compileReport("src/HoaDon/BaoCaoDoanhThu.jrxml");
			map.put("ngay1", ngay1);
			map.put("ngay2",ngay2);
			JasperPrint p = JasperFillManager.fillReport(report, map, con);
			JasperViewer.viewReport(p, false);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
    }
}
