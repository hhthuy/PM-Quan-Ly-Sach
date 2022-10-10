package bookstore.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bookstore.Entity.BaoCaoBanChay;
import bookstore.Entity.Sach;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class BaoCaoBanChayDAL extends SqlDataConnection {
	public ArrayList<bookstore.Entity.BaoCaoBanChay> getAll(String where) {
		ArrayList<bookstore.Entity.BaoCaoBanChay> ls = new ArrayList<>();
		String sql = "select top(5) s.maSach, s.tieuDe,s.tacGia,s.giaBia,s.namXuatBan,sum(c.soLuong) as 'So Luong Ban' "
				+ "from (SELECT tb_PhieuXuat.maPhieuXuat, tb_CTPX.maCTPX, tb_PhieuXuat.maKH, tb_CTPX.maSach, tb_CTPX.soLuong, tb_PhieuXuat.ngayXuat "
				+ "FROM tb_CTPX INNER JOIN "
				+ "tb_PhieuXuat ON tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat "+where+") c left join "
				+ "tb_Sach s on c.maSach = s.maSach "
				+ "group by s.tieuDe,s.maSach,s.giaBia,s.namXuatBan,s.tacGia "
				+ "order by 'So Luong Ban' desc";
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					bookstore.Entity.BaoCaoBanChay dc = new bookstore.Entity.BaoCaoBanChay();
					Sach s = new Sach();
					s.setMaSach(rs.getString(1));
					s.setTieuDe(rs.getString(2));
					s.setTacGia(rs.getString(3));
					s.setGiaBia(rs.getInt(4));
					s.setNamXuatBan(rs.getInt(5));
					dc.setSach(s);
					dc.setSoLuongBan(rs.getInt(6));
					ls.add(dc);
				}
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public void inBaoCao(String ngay1,String ngay2) {
		try {
			openConnection();
			Map map = new HashMap();
			JasperReport report = JasperCompileManager.compileReport("src/HoaDon/BaoCaoBanChay.jrxml");
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
