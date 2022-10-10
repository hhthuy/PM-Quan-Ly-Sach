package bookstore.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bookstore.Entity.BaoCaoKHTX;
import bookstore.Entity.KhachHang;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class BaoCaoKHTXDAL extends SqlDataConnection {
	public ArrayList<BaoCaoKHTX> getAll(String where) {
		String sql = "select k.maKH,k.tenKH,k.sdt,k.diachi, count(k.tenKH) as 'So luong' "
				+ "from tb_PhieuXuat p INNER JOIN tb_KhachHang k ON p.maKH = k.maKH "+where+""
				+ "group by k.maKH,k.tenKH,k.diachi,k.sdt "
				+ "having count(maPhieuXuat)>=3";
		ArrayList<BaoCaoKHTX> ls = new ArrayList<>();
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BaoCaoKHTX data = new BaoCaoKHTX();
				KhachHang kh = new KhachHang();
				kh.setMakhachhang(rs.getString(1));
				kh.setTenkhachhang(rs.getString(2));
				kh.setSdt(rs.getString(3));
				kh.setDiachi(rs.getString(4));
				data.setKhachHang(kh);
				data.setSoLuong(rs.getInt(5));
				ls.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public void inBaoCao(String ngay1,String ngay2) {
		try {
			openConnection();
			Map map = new HashMap();
			JasperReport report = JasperCompileManager.compileReport("src/HoaDon/BaoCaoKHTX.jrxml");
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
