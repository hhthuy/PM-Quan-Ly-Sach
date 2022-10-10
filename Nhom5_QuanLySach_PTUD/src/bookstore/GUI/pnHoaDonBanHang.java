package bookstore.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import bookstore.BLL.CTPXBLL;
import bookstore.BLL.HoaDonBanBLL;
import bookstore.BLL.PhieuXuatBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.CTPX;
import bookstore.Entity.PhieuXuat;
import bookstore.Entity.Sach;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

/**
 * 
 * @author Nhom5
 *
 */
public class pnHoaDonBanHang extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtKhachHang;
	public static JTextField txtSach;
	public static JTextField txtDonGia;
	public static JTable table;
	private JSpinner spinner;
	private pnQuanLyHoaDonBanHang frmXuat = new pnQuanLyHoaDonBanHang();
	private PhieuXuatBLL phieuXuat = new PhieuXuatBLL();
	private CTPXBLL objctpx = new CTPXBLL();
	private SachBLL sachBLL = new SachBLL();
	private ArrayList<Sach> lsts = new ArrayList<>();
	public static ArrayList<CTPX> lstCTPX = new ArrayList<>();
	private ArrayList<String> lstMaSach = new ArrayList<>();
	private boolean isEdit = false;
	private JButton btnThemHD;


	public pnHoaDonBanHang(java.awt.Frame parent, boolean modal, boolean _isEdit) {
		super();
		isEdit = _isEdit;
		initComponents();
		lstCTPX.clear();
		for (CTPX i : frmXuat.lstEditctpx) {
			lstCTPX.add(i);
		}
		for (CTPX i : lstCTPX) {
			lstMaSach.add(i.getMaSach());
		}
		txtKhachHang.setText(frmXuat.tenKH);
		btnThemHD.setText("Sửa hóa đơn");
		spinner.setValue(1);
		binData(lstCTPX);
	}

	public pnHoaDonBanHang() {
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setVisible(false);
		setLayout(null);
		setSize(1530, 737);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1510, 54);
		add(panel);

		JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 74, 1510, 127);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Chọn khách hàng:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 10, 175, 30);
		panel_1.add(lblNewLabel_1);

		txtKhachHang = new JTextField();
		txtKhachHang.setSelectionColor(new Color(51, 153, 153));
		txtKhachHang.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtKhachHang.setEditable(false);
		txtKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtKhachHang.setBounds(209, 10, 169, 30);
		panel_1.add(txtKhachHang);
		txtKhachHang.setColumns(10);

		JButton btnChonKH = new JButton("");
		btnChonKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frmkh.setVisible(true);
				frmChonKhachHang frm = new frmChonKhachHang();
				frm.setVisible(true);
			}
		});
		btnChonKH.setIcon(new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/1add.png")));
		btnChonKH.setBounds(388, 10, 33, 30);
		panel_1.add(btnChonKH);

		JLabel lblNewLabel_1_1 = new JLabel("Chọn sách:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(25, 73, 117, 30);
		panel_1.add(lblNewLabel_1_1);

		txtSach = new JTextField();
		txtSach.setSelectionColor(new Color(51, 153, 153));
		txtSach.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSach.setEditable(false);
		txtSach.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSach.setColumns(10);
		txtSach.setBounds(209, 75, 169, 30);
		panel_1.add(txtSach);

		JButton btnChonSach = new JButton("");
		btnChonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frmChonSach().setVisible(true);
			}
		});
		btnChonSach.setIcon(new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/1add.png")));
		btnChonSach.setBounds(388, 75, 33, 30);
		panel_1.add(btnChonSach);

		JLabel lblNewLabel_2 = new JLabel("Số lượng:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(437, 75, 96, 30);
		panel_1.add(lblNewLabel_2);

		spinner = new JSpinner();
		spinner.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		spinner.setBounds(529, 74, 79, 30);
		spinner.setValue(1);
		panel_1.add(spinner);

		JLabel lblNewLabel_3 = new JLabel("Cuốn");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(618, 75, 50, 30);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("Đơn giá:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(678, 75, 84, 30);
		panel_1.add(lblNewLabel_2_1);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDonGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDonGia.setEditable(false);
		txtDonGia.setBounds(772, 76, 117, 30);
		panel_1.add(txtDonGia);
		txtDonGia.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("VNĐ/Cuốn");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(899, 75, 81, 30);
		panel_1.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 211, 1510, 78);
		add(panel_2);
		panel_2.setLayout(null);

		JButton btnThem = new JButton();
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBorder(null);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSach();
			}
		});
		btnThem.setBackground(new Color(0, 153, 153));
		btnThem.setIcon(new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThem.setText("Thêm");
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnThem.setBounds(69, 23, 113, 40);
		panel_2.add(btnThem);

		JButton btnXoa = new JButton();
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBorder(null);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaCTPN();
			}
		});
		btnXoa.setBackground(new Color(0, 153, 153));
		btnXoa.setIcon(new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/delete-74-32.png")));
		btnXoa.setText("Xóa");
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnXoa.setBounds(262, 23, 113, 40);
		panel_2.add(btnXoa);

		JButton btnSua = new JButton();
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBorder(null);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaHoaDon();
			}
		});
		btnSua.setBackground(new Color(0, 153, 153));
		btnSua.setIcon(
				new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setText("Sửa");
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSua.setBounds(463, 23, 113, 40);
		panel_2.add(btnSua);

		JButton btnLamLai = new JButton();
		btnLamLai.setForeground(new Color(255, 255, 255));
		btnLamLai.setBorder(null);
		btnLamLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnLamLai.setBackground(new Color(0, 153, 153));
		btnLamLai.setIcon(
				new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamLai.setText("Làm lại");
		btnLamLai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLamLai.setBounds(674, 23, 113, 44);
		panel_2.add(btnLamLai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 299, 1193, 428);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonChiTietPhieuXuat();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 s\u00E1ch",
				"S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n" }));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(1213, 299, 307, 428);
		add(panel_3);
		panel_3.setLayout(null);

		JButton btnXoaTC = new JButton("Xóa tất cả");
		btnXoaTC.setForeground(new Color(255, 255, 255));
		btnXoaTC.setBorder(null);
		btnXoaTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaALL();
			}
		});
		btnXoaTC.setBackground(new Color(0, 153, 153));
		btnXoaTC.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoaTC.setBounds(80, 44, 155, 44);
		panel_3.add(btnXoaTC);

		btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.setForeground(new Color(255, 255, 255));
		btnThemHD.setBorder(null);
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themHoaDon();
			}
		});
		btnThemHD.setBackground(new Color(0, 153, 153));
		btnThemHD.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThemHD.setBounds(80, 144, 155, 44);
		panel_3.add(btnThemHD);

		JButton btnHuy = new JButton("Hủy bỏ");
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setBorder(null);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huyBo();
			}
		});
		btnHuy.setBackground(new Color(0, 153, 153));
		btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnHuy.setBounds(80, 251, 155, 44);
		panel_3.add(btnHuy);
	}

	public void huyBo() {
		if (JOptionPane.showConfirmDialog(this, "Bạn muốn hủy thao tác?", "Thông báo!!!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.setVisible(false);
			GiaoDienChinh.swapPanel(frmXuat);
			lstCTPX.removeAll(lstCTPX);
		}
	}

	public void xoaALL() {
		lstCTPX.removeAll(lstCTPX);
		lstMaSach.removeAll(lstMaSach);
		binData(lstCTPX);
	}

	public void xoaCTPN() {
		if (table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa bản ghi này?", "Cảnh báo!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String s = table.getValueAt(table.getSelectedRow(), 0).toString();
				for (int x = 0; x < lstCTPX.size(); x++) {
					if (lstCTPX.get(x).getMaSach().equals(s)) {
						lstCTPX.remove(x);
						break;
					}
				}
				for (int x = 0; x < lstMaSach.size(); x++) {
					if (lstMaSach.get(x).equals(s)) {
						lstMaSach.remove(x);
						break;
					}
				}
				binData(lstCTPX);
				// clearText();
			}
		}
	}

	public void chonChiTietPhieuXuat() {
		if (table.getSelectedRow() == -1) {
			return;
		}
		String item = table.getValueAt(table.getSelectedRow(), 0).toString();
		for (Sach i : lsts) {
			if (item.equals(i.getMaSach())) {
				item = i.getTieuDe();
				break;
			}
		}
		txtSach.setText(sachBLL.getNameByID(table.getValueAt(table.getSelectedRow(), 0).toString()));
		txtDonGia.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
		spinner.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString()));
	}

	public void suaHoaDon() {
		int i = table.getSelectedRow();
		if (i < 0) {
			JOptionPane.showMessageDialog(this, "Chọn bản ghi cần sửa trước!");
			return;
		} else {
			lsts = new ArrayList<>();
			lsts = sachBLL.getAll("", "", "");
			try {
				lstCTPX.get(i).setMaSach(sachBLL.getIDByName(txtSach.getText().toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			lstMaSach.remove(table.getValueAt(i, 0).toString());
			for (String in : lstMaSach) {
				if (in.equals(lstCTPX.get(i).getMaSach())) {
					JOptionPane.showMessageDialog(this, "Mã sách này đã tồn tại!");
					return;
				}
			}
			lstMaSach.add(lstCTPX.get(i).getMaSach());
			lstCTPX.get(i).setSoLuong((int) spinner.getValue());
			if (lstCTPX.get(i).getSoLuong() < 1) {
				JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
				spinner.setValue(1);
				return;
			}
			String w = "maSach = '" + lstCTPX.get(i).getMaSach() + "'";
			lsts = sachBLL.getAll("", w, "");
			lstCTPX.get(i).setThanhTien(lstCTPX.get(i).getDonGia() * lstCTPX.get(i).getSoLuong());
			binData(lstCTPX);
			// clearText();
		}
	}

	public void themHoaDon() {
		PhieuXuat px = new PhieuXuat();
		px.setMaPhieuXuat(phieuXuat.getAll("", "", "").get(0).getMaPhieuXuat());
		px.setNgayXuat(java.sql.Date.valueOf(LocalDate.now()));
		px.setMaKH(txtKhachHang.getText());
		px.setThanhTien(ABORT);
		boolean isEdit = false;
		if (lstCTPX.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hóa đơn trống!");
			return;
		} else if (txtKhachHang.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy nhập tên khách hàng!");
			txtKhachHang.requestFocus();
			return;
		} else if (isEdit == true) {
			PhieuXuat dt = new PhieuXuat();
			dt.setMaKH(txtKhachHang.getText());
			String maPX = pnQuanLyHoaDonBanHang.lstEditctpx.get(0).getMaPhieuXuat();
			dt.setMaPhieuXuat(maPX);
			int thanhTien = 0;
			for (CTPX i : lstCTPX) {
				thanhTien += i.getThanhTien();
			}
			dt.setThanhTien(thanhTien);
			if (JOptionPane.showConfirmDialog(this, "Sửa bản ghi này?", "Thông báo!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (phieuXuat.updateData(dt)) {
					for (CTPX x : lstCTPX) {
						boolean check = true;
						x.setMaPhieuXuat(maPX);
						for (CTPX y : pnQuanLyHoaDonBanHang.lstEditctpx) {
							if (x.getMaSach().equals(y.getMaSach())) {
								check = false;
								x.setMaCTPX(y.getMaCTPX());
								objctpx.updateData(x);
								pnQuanLyHoaDonBanHang.lstEditctpx.remove(y);
								break;
							}
						}
						if (check) {
							x.setMaCTPX(frmXuat.getIDCTPX());
							objctpx.insertData(x);
						}
					}
					for (CTPX y : pnQuanLyHoaDonBanHang.lstEditctpx) {
						String id = y.getMaCTPX();
						objctpx.deleteData_CTPX(id);
					}
					JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa hóa đơn thất bại!");
				}
			}

		} else {
			PhieuXuat data = new PhieuXuat();
			String idPX = frmXuat.getIDPX();
			data.setMaPhieuXuat(idPX);
			data.setMaKH(txtKhachHang.getText());
			LocalDate now = LocalDate.now();
			data.setNgayXuat(java.sql.Date.valueOf(now));
			int thanhTien = 0;
			for (CTPX i : lstCTPX) {
				thanhTien += i.getThanhTien();
			}
			data.setThanhTien(thanhTien);
			if (JOptionPane.showConfirmDialog(this, "Tạo mới hóa đơn?", "Thông báo!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (phieuXuat.insertData(data)) {
					for (CTPX i : lstCTPX) {
						i.setMaCTPX(frmXuat.getIDCTPX());
						i.setMaPhieuXuat(idPX);
						objctpx.insertData(i);
					}
					JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công!");
					lstCTPX = new ArrayList<>();

					HoaDonBanBLL bll = new HoaDonBanBLL();
					bll.inHoaDon(idPX);

				} else {
					JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại!");
				}
			}
		}
		this.setVisible(false);
		GiaoDienChinh.swapPanel(frmXuat);
	}

	public static void toExcel(PhieuXuat px, JTable table, File file) throws IOException {
		String sheetName = "Sheet1";// name of sheet
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		TableModel model = table.getModel();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Mã hóa đơn");
		cell = row.createCell(1);
		cell.setCellValue(px.getMaPhieuXuat());
		cell = row.createCell(3);
		cell.setCellValue("Ngày lập");
		cell = row.createCell(4);
		cell.setCellValue(px.getNgayXuat().toString());
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("Mã Khách Hàng");
		cell = row.createCell(1);
		cell.setCellValue(px.getMaKH());

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

	public void themSach() {
		lsts = sachBLL.getAll("", "", "");
		CTPX data = new CTPX();
		try {
			data.setMaSach(sachBLL.getIDByName(txtSach.getText()));
			for (String i : lstMaSach) {
				if (i.equals(data.getMaSach())) {
					JOptionPane.showMessageDialog(this, "Sách bạn chọn đã có!");
					return;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Hãy lựa chọn sách!");
			// clearText();
			return;
		}
		data.setSoLuong((int) spinner.getValue());
		if (data.getSoLuong() < 1) {
			JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
			spinner.setValue(1);
			return;
		}
		String w = "maSach = '" + data.getMaSach() + "'";
		lsts = new ArrayList<>();
		lsts = sachBLL.getAll("", w, "");
		if (data.getSoLuong() > lsts.get(0).getSoLuongTon()) {
			JOptionPane.showMessageDialog(this, "Sách trong kho còn " + lsts.get(0).getSoLuongTon() + " cuốn!",
					"Không đủ sách", 1);
			spinner.setValue(1);
			return;
		}
		data.setDonGia(lsts.get(0).getGiaBia());
//		data.setDonGia(Integer.parseInt(txtDonGia.getText()));
		data.setThanhTien(data.getDonGia() * (data.getSoLuong()));
		lstMaSach.add(data.getMaSach());
		lstCTPX.add(data);
		binData(lstCTPX);
		txtDonGia.setText("");
		txtSach.setText("");
		spinner.setValue(1);
		// clearText();
	}

	public void clearText() {
		txtDonGia.setText("");
		txtSach.setText("");
		txtKhachHang.setText("");
		spinner.setValue(1);
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int count = dm.getRowCount();
		for (int i = count - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
	}

	public void binData(ArrayList<CTPX> lst) {
		Vector col = new Vector();
		col.add("Mã sách");
		col.add("Số lượng");
		col.add("Đơn giá");
		col.add("Thành tiền");

		Vector data = new Vector();
		for (CTPX i : lst) {
			Vector row = new Vector();
			row.add(i.getMaSach());
			row.add(i.getSoLuong());
			row.add(i.getDonGia());
			row.add(i.getThanhTien());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		table.setModel(dtm);
	}
}
