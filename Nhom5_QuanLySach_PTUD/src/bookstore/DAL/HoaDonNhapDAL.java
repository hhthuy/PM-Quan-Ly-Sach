package bookstore.DAL;

import java.util.Hashtable;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class HoaDonNhapDAL extends SqlDataConnection {
	public void inHoaDon(String ma) {
		try {
			openConnection();
			Hashtable map = new Hashtable();
			JasperReport report = JasperCompileManager.compileReport("src/HoaDon/HoaDonNhap.jrxml");
			map.put("maPhieuNhap", ma);

			JasperPrint p = JasperFillManager.fillReport(report, map, con);
			JasperViewer.viewReport(p, false);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
