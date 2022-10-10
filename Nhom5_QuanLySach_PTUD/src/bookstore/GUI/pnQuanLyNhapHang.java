package bookstore.GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import bookstore.BLL.CTPNBLL;
import bookstore.BLL.HoaDonNhapBLL;
import bookstore.BLL.PhieuNhapBLL;
import bookstore.Entity.CTPN;
import bookstore.Entity.PhieuNhap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnQuanLyNhapHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTable tblHoaDonNhap;
	private JTextField txtTimKiemCTHD;
	private JTable tblCTHDNhap;
	private JButton bntLamMoi;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnInHoaDon;
	static String datePrint = "";
	private PhieuNhapBLL obj1 = new PhieuNhapBLL();
	private ArrayList<PhieuNhap> lstpn = new ArrayList<>();
	private CTPNBLL obj2 = new CTPNBLL();
	private ArrayList<CTPN> lstctpn = new ArrayList<>();
	private DefaultTableModel model;
	static ArrayList<CTPN> lstEditctpn = new ArrayList<>();
	static String idNXB = "";

	public pnQuanLyNhapHang() {
		initComponents();
		binDataCTPN("", "", "");
		binDataPN("", "", "");
	}

	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530, 737);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch h\u00F3a \u0111\u01A1n nh\u1EADp", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 700, 619);
		add(panel);
		panel.setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(10, 62, 362, 30);
		panel.add(txtTimKiem);

		JLabel lblTmKimTheo = new JLabel();
		lblTmKimTheo.setText("Tìm Kiếm Theo Mã HD Nhập Hàng");
		lblTmKimTheo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTmKimTheo.setBounds(10, 27, 309, 20);
		panel.add(lblTmKimTheo);

		JButton btnTimKiemPN = new JButton();
		btnTimKiemPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimKiemPN();
			}
		});
		btnTimKiemPN
				.setIcon(new ImageIcon(pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiemPN.setText("Tìm Kiếm");
		btnTimKiemPN.setForeground(Color.WHITE);
		btnTimKiemPN.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimKiemPN.setBorder(null);
		btnTimKiemPN.setBackground(new Color(51, 153, 153));
		btnTimKiemPN.setBounds(380, 51, 131, 40);
		panel.add(btnTimKiemPN);

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 102, 680, 507);
		panel.add(jScrollPane);

		tblHoaDonNhap = new JTable();
		tblHoaDonNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblHoaDonNhapClicked();
			}
		});
		tblHoaDonNhap.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 h\u00F3a \u0111\u01A1n nh\u1EADp",
						"Nh\u00E0 xu\u1EA5t b\u1EA3n", "Ng\u00E0y nh\u1EADp", "Th\u00E0nh ti\u1EC1n" }));
		tblHoaDonNhap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		jScrollPane.setViewportView(tblHoaDonNhap);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n nh\u1EADp h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(720, 10, 810, 619);
		add(panel_1);
		panel_1.setLayout(null);

		txtTimKiemCTHD = new JTextField();
		txtTimKiemCTHD.setBounds(10, 62, 362, 30);
		panel_1.add(txtTimKiemCTHD);

		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Tìm Kiếm Theo Mã CTHD nhập hàng");
		jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel2.setBounds(10, 32, 362, 20);
		panel_1.add(jLabel2);

		JButton btnTimKiemCTPN = new JButton();
		btnTimKiemCTPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimKiemCTPN();
			}
		});
		btnTimKiemCTPN
				.setIcon(new ImageIcon(pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiemCTPN.setText("Tìm Kiếm");
		btnTimKiemCTPN.setForeground(Color.WHITE);
		btnTimKiemCTPN.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimKiemCTPN.setBorder(null);
		btnTimKiemCTPN.setBackground(new Color(51, 153, 153));
		btnTimKiemCTPN.setBounds(382, 51, 132, 40);
		panel_1.add(btnTimKiemCTPN);

		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(10, 102, 790, 507);
		panel_1.add(jScrollPane1);

		tblCTHDNhap = new JTable();
		tblCTHDNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblCTHDNhapClicked();
			}
		});
		tblCTHDNhap.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 CTHD nh\u1EADp", "M\u00E3 h\u00F3a \u0111\u01A1n nh\u1EADp",
						"M\u00E3 s\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1",
						"Th\u00E0nh ti\u1EC1n" }));
		tblCTHDNhap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		jScrollPane1.setViewportView(tblCTHDNhap);

		JPanel jPanel6 = new JPanel();
		jPanel6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel6.setBackground(Color.WHITE);
		jPanel6.setBounds(10, 637, 1510, 90);
		add(jPanel6);

		bntLamMoi = new JButton();
		bntLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLamMoi();
			}
		});
		bntLamMoi.setIcon(
				new ImageIcon(pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		bntLamMoi.setBounds(200, 28, 125, 40);
		bntLamMoi.setText("Làm Mới");
		bntLamMoi.setForeground(Color.WHITE);
		bntLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bntLamMoi.setBorder(null);
		bntLamMoi.setBackground(new Color(51, 153, 153));

		btnThem = new JButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem();
			}
		});
		btnThem.setIcon(new ImageIcon(pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThem.setBounds(439, 28, 125, 40);
		btnThem.setText("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThem.setBorder(null);
		btnThem.setBackground(new Color(51, 153, 153));

		btnSua = new JButton();
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua();
			}
		});
		btnSua.setIcon(new ImageIcon(
				pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setBounds(680, 28, 125, 40);
		btnSua.setText("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSua.setEnabled(false);
		btnSua.setBorder(null);
		btnSua.setBackground(new Color(51, 153, 153));

		btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
		btnXoa.setBounds(908, 28, 125, 40);
		btnXoa.setText("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoa.setEnabled(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(new Color(51, 153, 153));

		btnInHoaDon = new JButton();
		btnInHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInHoaDon();
			}
		});
		btnInHoaDon.setIcon(
				new ImageIcon(pnQuanLyNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnInHoaDon.setBounds(1124, 28, 169, 40);
		btnInHoaDon.setText("In Hóa Đơn");
		btnInHoaDon.setForeground(Color.WHITE);
		btnInHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnInHoaDon.setBorder(null);
		btnInHoaDon.setBackground(new Color(51, 153, 153));
		jPanel6.setLayout(null);
		jPanel6.add(bntLamMoi);
		jPanel6.add(btnThem);
		jPanel6.add(btnSua);
		jPanel6.add(btnXoa);
		jPanel6.add(btnInHoaDon);
	}

	private void btnTimKiemPN() {
		String w = "maPhieuNhap like N'" + "%" + txtTimKiem.getText() + "%" + "'";
		binDataPN("", w, "");
	}

	private void btnTimKiemCTPN() {
		String w = "maCTPN like N'" + "%" + txtTimKiemCTHD.getText() + "%" + "'";
		binDataCTPN("", w, "");
	}

	private void tblHoaDonNhapClicked() {
		if (tblHoaDonNhap.getSelectedRow() == -1) {
			return;
		}
		int row = tblHoaDonNhap.getSelectedRow();
		String ID = "maPhieuNhap = '";
		ID += tblHoaDonNhap.getValueAt(row, 0).toString() + "'";
		binDataCTPN("", ID, "");
		btnSua.setEnabled(true);
		btnThem.setEnabled(false);
		btnXoa.setEnabled(true);
	}

	private void tblCTHDNhapClicked() {
		if (tblCTHDNhap.getSelectedRow() == -1) {
			return;
		}
		String ID = "maPhieuNhap = '";
		ID += tblCTHDNhap.getValueAt(tblCTHDNhap.getSelectedRow(), 1).toString() + "'";
		binDataPN("", ID, "");
	}

	private void btnLamMoi() {
		binDataCTPN("", "", "");
		binDataPN("", "", "");
		txtTimKiem.setText("");
		txtTimKiem.setText("");
		btnThem.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
	}

	private void btnThem() {
		pnHoaDonNhapHang frm = new pnHoaDonNhapHang();
		GiaoDienChinh.swapPanel(frm);
	}

	private void btnSua() {
		pnSuaHoaDonNhapHang frm = new pnSuaHoaDonNhapHang();
		int row = tblHoaDonNhap.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Chọn một hóa đơn nhập hàng trước!");
			return;
		}
		String w = "maPhieuNhap = '" + tblHoaDonNhap.getValueAt(row, 0).toString() + "'";
		
		lstEditctpn = obj2.getAll("", w, ""); 
		frm.lstCTPN = obj2.getAll("", w, "");
		idNXB = tblHoaDonNhap.getValueAt(row, 1).toString();

//        new frmNhap(this, true, true).setVisible(true);
		GiaoDienChinh.swapPanel(frm);
		pnSuaHoaDonNhapHang.txtNhaXuatBan.setText(tblHoaDonNhap.getValueAt(row, 1).toString());
		model = new DefaultTableModel();
		DefaultTableModel old = (DefaultTableModel) pnSuaHoaDonNhapHang.table.getModel();
		int n = old.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(old.getColumnName(i));
		}
		n = frm.lstCTPN.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { frm.lstCTPN.get(i).getMaSach(), frm.lstCTPN.get(i).getSoLuong(),
					frm.lstCTPN.get(i).getDonGia(), frm.lstCTPN.get(i).getThanhTien() });
		}
		pnSuaHoaDonNhapHang.table.setModel(model);
		binDataCTPN("", "", "");
		binDataPN("", "", "");
	}

	private void btnXoa() {
		int row = tblHoaDonNhap.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Chọn một Phiếu Nhập trước!");
			return;
		}
		int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa bản ghi?", "Cảnh báo",
				JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION) {
			obj2.deleteData_PN(tblHoaDonNhap.getValueAt(row, 0).toString());
			boolean c = obj1.deleteData(tblHoaDonNhap.getValueAt(row, 0).toString());
			binDataCTPN("", "", "");
			binDataPN("", "", "");
			if (c) {
				JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Xóa phiếu nhập không thành công!");
			}
		}

	}

	private void btnInHoaDon() {
		int row = tblHoaDonNhap.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Chọn một Phiếu Nhập trước!");
			return;
		} else {
			HoaDonNhapBLL bll = new HoaDonNhapBLL();
			bll.inHoaDon(tblHoaDonNhap.getValueAt(row, 0).toString());
		}

//        PhieuNhap data = new PhieuNhap();
//        data.setMaPhieuNhap(tblHoaDonNhap.getValueAt(row, 0).toString());
//        data.setMaNXB(tblHoaDonNhap.getValueAt(row, 1).toString());
//        datePrint = tblHoaDonNhap.getValueAt(row, 2).toString();
//        data.setThanhTien(Integer.parseInt(tblHoaDonNhap.getValueAt(row, 3).toString()));
////        System.out.println(data.getMaPhieuNhap()+" "+data.getTenKH()+" "+data.getNgayXuat()+" "+data.getThanhTien());
//        JFileChooser fc = new JFileChooser();
//        int option = fc.showSaveDialog(this);
//        if (option == JFileChooser.APPROVE_OPTION) {
//            String filename = fc.getSelectedFile().getName();
//            String path = fc.getSelectedFile().getParentFile().getPath();
//            int len = filename.length();
//            String ext = "";
//            String file = "";
//
//            if (len > 4) {
//                ext = filename.substring(len - 4, len);
//            }
//
//            if (ext.equals(".xls")) {
//                file = path + "\\" + filename;
//            } else {
//                file = path + "\\" + filename + ".xls";
//            }
//            try {
//                toExcel(data, tblCTHDNhap, new File(file));
//                if (JOptionPane.showConfirmDialog(this, "Mở file?", "Xuất file thành công!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                    File f = new File(file);
//                    try {
//                        Desktop.getDesktop().open(f);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(pnQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
//            }
//        }
	}

	public static void toExcel(PhieuNhap px, JTable table, File file) throws IOException {
		String sheetName = "Sheet1";// name of sheet
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		TableModel model = table.getModel();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Mã Phiếu Nhập");
		cell = row.createCell(1);
		cell.setCellValue(px.getMaPhieuNhap());
		cell = row.createCell(3);
		cell.setCellValue("Ngày nhập");
		cell = row.createCell(4);
		cell.setCellValue(datePrint);
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("Nhà Xuất Bản");
		cell = row.createCell(1);
		cell.setCellValue(px.getMaNXB());

//        Get col name
		row = sheet.createRow(3);
		cell = row.createCell(0);
		cell.setCellValue("STT");
		for (int i = 0; i < model.getColumnCount(); i++) {
			cell = row.createCell(i + 1);
			cell.setCellValue(model.getColumnName(i).toString());
		}
//        iterating r number of rows
		for (int r = 0; r < model.getRowCount(); r++) {
			row = sheet.createRow(r + 4);
			cell = row.createCell(0);
			cell.setCellValue(r + 1);
			// iterating c number of columns
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c + 1);
				cell.setCellValue(model.getValueAt(r, c).toString());
			}
		}
		row = sheet.createRow(model.getRowCount() + 4);
		cell = row.createCell(model.getColumnCount() - 1);
		cell.setCellValue("Tổng tiền");
		cell = row.createCell(model.getColumnCount());
		cell.setCellValue(px.getThanhTien());

		FileOutputStream fileOut = new FileOutputStream(file);

		// write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		wb.close();
	}

	public String getIDPN() {
		String id = "PN";
		int val = 0;
		binDataPN("", "", "");
		int l = tblHoaDonNhap.getRowCount();
		for (int i = 0; i < l; i++) {
			if (Integer.parseInt(tblHoaDonNhap.getValueAt(i, 0).toString().substring(2)) > val) {
				val = Integer.parseInt(tblHoaDonNhap.getValueAt(i, 0).toString().substring(2));
			}
		}
		id += String.valueOf(val + 1);
		return id;
	}

	public String getIDCTPN() {
		String id = "CTPN";
		int val = 0;
		binDataCTPN("", "", "");
		int l = tblCTHDNhap.getRowCount();
		for (int i = 0; i < l; i++) {
			if (Integer.parseInt(tblCTHDNhap.getValueAt(i, 0).toString().substring(4)) > val) {
				val = Integer.parseInt(tblCTHDNhap.getValueAt(i, 0).toString().substring(4));
			}
		}
		id += String.valueOf(val + 1);
		return id;
	}

	private void binDataPN(String t, String w, String o) {
		lstpn = obj1.getAll(t, w, o);
		Vector col = new Vector();
		col.add("Mã Phiếu Nhập");
		col.add("Nhà Xuất Bản");
		col.add("Ngày Nhập");
		col.add("Tổng Tiền");
		Vector data = new Vector();
		for (PhieuNhap i : lstpn) {
			Vector row = new Vector();
			row.add(i.getMaPhieuNhap());
			row.add(i.getMaNXB());
			row.add(i.getNgayNhap());
			row.add(i.getThanhTien());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tblHoaDonNhap.setModel(dtm);
	}

	private void binDataCTPN(String t, String w, String o) {
		lstctpn = obj2.getAll(t, w, o);
		Vector col = new Vector();
		col.add("Mã CTPN");
		col.add("Mã Phiếu Nhập");
		col.add("Mã Sách");
		col.add("Số Lượng");
		col.add("Đơn Giá");
		col.add("Thành Tiền");

		Vector data = new Vector();
		for (CTPN i : lstctpn) {
			Vector row = new Vector();
			row.add(i.getMaCTPN());
			row.add(i.getMaPhieuNhap());
			row.add(i.getMaSach());
			row.add(i.getSoLuong());
			row.add(i.getDonGia());
			row.add(i.getThanhTien());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tblCTHDNhap.setModel(dtm);
	}
}
