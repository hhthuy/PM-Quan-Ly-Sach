package bookstore.GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import bookstore.BLL.CTPNBLL;
import bookstore.BLL.HoaDonNhapBLL;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.BLL.PhieuNhapBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.CTPN;
import bookstore.Entity.PhieuNhap;
import bookstore.Entity.Sach;
/**
 * 
 * @author Nhom5
 *
 */

public class pnHoaDonNhapHang extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtNhaXuatBan;
	public static JTextField txtSach;
	public static JTextField txtDonGia;
	public static JTable table;
	private JSpinner spinner;
	private pnQuanLyNhapHang quanLyNhap = new pnQuanLyNhapHang();
	private PhieuNhapBLL phieuNhapBLL = new PhieuNhapBLL();
	private CTPNBLL chiTietPhieuNhapBLL = new CTPNBLL();
	private SachBLL sachBLL = new SachBLL();
	private NhaXuatBanBLL nxbBLL = new NhaXuatBanBLL();
	private ArrayList<Sach> lstSach = new ArrayList<>();
	public static ArrayList<CTPN> lstCTPN = new ArrayList<>();
	private ArrayList<String> lstMaSach = new ArrayList<>();
	private boolean isEdit = false;

	/**
	 * Create the frame.
	 */
	public pnHoaDonNhapHang() {
		setVisible(false);
		setSize(1530, 737);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1510, 51);
		add(panel);

		JLabel lblTitle = new JLabel("HÓA ĐƠN NHẬP HÀNG");
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel.add(lblTitle);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 61, 1510, 127);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNhaXuatBan = new JLabel("Chọn nhà xuất bản:");
		lblNhaXuatBan.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNhaXuatBan.setBounds(25, 10, 175, 30);
		panel_1.add(lblNhaXuatBan);

		txtNhaXuatBan = new JTextField();
		txtNhaXuatBan.setSelectionColor(new Color(51, 153, 153));
		txtNhaXuatBan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtNhaXuatBan.setEditable(false);
		txtNhaXuatBan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNhaXuatBan.setBounds(209, 10, 169, 30);
		panel_1.add(txtNhaXuatBan);
		txtNhaXuatBan.setColumns(10);

		JButton btnChonKH = new JButton("");
		btnChonKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frmkh.setVisible(true);
				frmChonNhaXuatBan frm = new frmChonNhaXuatBan();
				frm.setVisible(true);
			}
		});
		btnChonKH.setIcon(new ImageIcon(pnHoaDonNhapHang.class.getResource("/nhom05/bookstore/icon/1add.png")));
		btnChonKH.setBounds(388, 10, 33, 30);
		panel_1.add(btnChonKH);

		JLabel lblChonSach = new JLabel("Chọn sách:");
		lblChonSach.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblChonSach.setBounds(25, 73, 117, 30);
		panel_1.add(lblChonSach);

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
		btnChonSach.setIcon(new ImageIcon(pnHoaDonNhapHang.class.getResource("/nhom05/bookstore/icon/1add.png")));
		btnChonSach.setBounds(388, 75, 33, 30);
		panel_1.add(btnChonSach);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSoLuong.setBounds(437, 75, 96, 30);
		panel_1.add(lblSoLuong);

		spinner = new JSpinner();
		spinner.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		spinner.setBounds(529, 75, 83, 30);
		spinner.setValue(1);
		panel_1.add(spinner);

		JLabel lblCuon = new JLabel("Cuốn");
		lblCuon.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCuon.setBounds(622, 75, 55, 30);
		panel_1.add(lblCuon);

		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDonGia.setBounds(687, 75, 84, 30);
		panel_1.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDonGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDonGia.setEditable(false);
		txtDonGia.setBounds(781, 76, 117, 30);
		panel_1.add(txtDonGia);
		txtDonGia.setColumns(10);

		JLabel lblVND = new JLabel("VNĐ/Cuốn");
		lblVND.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblVND.setBounds(908, 75, 81, 30);
		panel_1.add(lblVND);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 198, 1510, 78);
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
		btnThem.setIcon(new ImageIcon(pnHoaDonNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
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
		btnXoa.setIcon(new ImageIcon(pnHoaDonNhapHang.class.getResource("/nhom05/bookstore/icon/delete-74-32.png")));
		btnXoa.setText("Xóa");
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnXoa.setBounds(262, 23, 113, 40);
		panel_2.add(btnXoa);

		JButton btnSua = new JButton();
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBorder(null);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaPhieuNhap();
			}
		});
		btnSua.setBackground(new Color(0, 153, 153));
		btnSua.setIcon(new ImageIcon(pnHoaDonNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
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
		btnLamLai.setIcon(new ImageIcon(pnHoaDonNhapHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamLai.setText("Làm lại");
		btnLamLai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLamLai.setBounds(674, 23, 113, 44);
		panel_2.add(btnLamLai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 286, 1193, 441);
		add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonChiTietPhieuNhap();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 s\u00E1ch",
				"S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n" }));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(1213, 286, 307, 441);
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
		btnXoaTC.setBounds(86, 39, 155, 44);
		panel_3.add(btnXoaTC);

		JButton btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.setForeground(new Color(255, 255, 255));
		btnThemHD.setBorder(null);
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themHoaDon();
			}
		});
		btnThemHD.setBackground(new Color(0, 153, 153));
		btnThemHD.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThemHD.setBounds(86, 146, 155, 44);
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
		btnHuy.setBounds(86, 251, 155, 44);
		panel_3.add(btnHuy);
	}
	public void huyBo() {
		if (JOptionPane.showConfirmDialog(this, "Bạn muốn hủy thao tác?", "Thông báo!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            lstCTPN.removeAll(lstCTPN);
        }
	}

	public void xoaALL() {
		lstCTPN.removeAll(lstCTPN);
        lstMaSach.removeAll(lstMaSach);
        binData(lstCTPN);
	}

	public void xoaCTPN() {
		if (table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa bản ghi này?", "Cảnh báo!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String s = table.getValueAt(table.getSelectedRow(), 0).toString();
				for (int x = 0; x < lstCTPN.size(); x++) {
					if (lstCTPN.get(x).getMaSach().equals(s)) {
						lstCTPN.remove(x);
						break;
					}
				}
				for (int x = 0; x < lstMaSach.size(); x++) {
					if (lstMaSach.get(x).equals(s)) {
						lstMaSach.remove(x);
						break;
					}
				}
				binData(lstCTPN);
//				clearText();
			}
		}
	}

	public void chonChiTietPhieuNhap() {
		if (table.getSelectedRow() == -1) {
			return;
		}
		String item = table.getValueAt(table.getSelectedRow(), 0).toString();
		for (Sach i : lstSach) {
			if (item.equals(i.getMaSach())) {
				item = i.getTieuDe();
				break;
			}
		}
		txtSach.setText(sachBLL.getNameByID(table.getValueAt(table.getSelectedRow(), 0).toString()));
		txtDonGia.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
		spinner.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString()));
	}

	public void suaPhieuNhap() {
		int i = table.getSelectedRow();
		if (i < 0) {
			JOptionPane.showMessageDialog(this, "Chọn bản ghi cần sửa trước!");
			return;
		}
		lstSach = sachBLL.getAll("", "", "");
		try {
			lstCTPN.get(i).setMaSach(sachBLL.getIDByName(txtSach.getText().toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		lstMaSach.remove(table.getValueAt(i, 0).toString());
		for (String in : lstMaSach) {
			if (in.equals(lstCTPN.get(i).getMaSach())) {
				JOptionPane.showMessageDialog(this, "Mã sách này đã tồn tại!");
				return;
			}
		}
		lstMaSach.add(lstCTPN.get(i).getMaSach());
		lstCTPN.get(i).setSoLuong((int) spinner.getValue());
		if (lstCTPN.get(i).getSoLuong() < 1) {
			JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
			spinner.setValue(1);
			return;
		}
		lstCTPN.get(i).setDonGia(Integer.parseInt(txtDonGia.getText()));
		if (lstCTPN.get(i).getDonGia() < 1) {
			JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ!");
			txtDonGia.setText("1");
			return;
		}
		lstCTPN.get(i).setThanhTien(lstCTPN.get(i).getDonGia() * lstCTPN.get(i).getSoLuong());
		binData(lstCTPN);
//		clearText();
		txtDonGia.setText("");
		txtSach.setText("");
		spinner.setValue(1);
	}

	public void themHoaDon() {
		if (lstCTPN.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hóa đơn trống!");
			return;
		} else if (txtNhaXuatBan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Hãy lựa chọn nhà xuất bản!");
//			txtNhaXuatBan.requestFocus();
			return;
		} else if (isEdit) {
			PhieuNhap dt = new PhieuNhap();
			dt.setMaNXB(nxbBLL.getIdByName(txtNhaXuatBan.getText()));
			String maPN = pnQuanLyNhapHang.lstEditctpn.get(0).getMaPhieuNhap();
			dt.setMaPhieuNhap(maPN);
			int thanhTien = 0;
			for (CTPN i : lstCTPN) {
				thanhTien += i.getThanhTien();
			}
			dt.setThanhTien(thanhTien);
			if (JOptionPane.showConfirmDialog(this, "Sửa phiếu nhập này?", "Thông báo!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (phieuNhapBLL.updateData(dt)) {
					for (CTPN x : lstCTPN) {
						boolean check = true;
						x.setMaPhieuNhap(maPN);
						for (CTPN y : pnQuanLyNhapHang.lstEditctpn) {
							if (x.getMaSach().equals(y.getMaSach())) {
								check = false;
								x.setMaCTPN(y.getMaCTPN());
//                                System.out.println(x.getMaCTPN() + " " + x.getMaPhieuNhap() + " " + x.getMaSach() + " " + x.getSoLuong() + " " + x.getDonGia() + " " + x.getThanhTien());
								chiTietPhieuNhapBLL.updateData(x);
								pnQuanLyNhapHang.lstEditctpn.remove(y);
								break;
							}
						}
						if (check) {
							x.setMaCTPN(quanLyNhap.getIDCTPN());
							chiTietPhieuNhapBLL.insertData(x);
						}
					}
					for (CTPN y : pnQuanLyNhapHang.lstEditctpn) {
						String id = y.getMaCTPN();
						chiTietPhieuNhapBLL.deleteData_CTPN(id);
					}
					JOptionPane.showMessageDialog(this, "Sửa phiếu nhập thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa phiếu nhập thất bại!");
				}
			}

		} else {
			PhieuNhap data = new PhieuNhap();
			String idPN = quanLyNhap.getIDPN();
			data.setMaPhieuNhap(idPN);
			data.setMaNXB(nxbBLL.getIdByName(txtNhaXuatBan.getText()));
			LocalDate now = LocalDate.now();
			data.setNgayNhap(Date.valueOf(now));
			int thanhTien = 0;
			for (CTPN i : lstCTPN) {
				thanhTien += i.getThanhTien();
			}
			data.setThanhTien(thanhTien);
			if (JOptionPane.showConfirmDialog(this, "Tạo phiếu nhập này?", "Thông báo!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (phieuNhapBLL.insertData(data)) {
					for (CTPN i : lstCTPN) {
						i.setMaCTPN(quanLyNhap.getIDCTPN());
						i.setMaPhieuNhap(idPN);
						chiTietPhieuNhapBLL.insertData(i);
					}

					JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thành công!");
					lstCTPN.removeAll(lstCTPN);
					HoaDonNhapBLL bll = new HoaDonNhapBLL();
					bll.inHoaDon(idPN);

				} else {
					JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thất bại!");
				}
			}
		}
		this.setVisible(false);
		GiaoDienChinh.swapPanel(quanLyNhap);
	}

	public void themSach() {
		lstSach = sachBLL.getAll("", "", "");
		CTPN data = new CTPN();
		try {
			data.setMaSach(sachBLL.getIDByName(txtSach.getText().toString()));
			for (String i : lstMaSach) {
				if (i.equals(data.getMaSach())) {
					JOptionPane.showMessageDialog(this, "Sách bạn chọn đã có!");
					clearText();
					return;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Hãy lựa chọn sách!");
			clearText();
			return;
		}
		data.setSoLuong((int) spinner.getValue());
		if (data.getSoLuong() < 1) {
			JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
			spinner.setValue(1);
			return;
		}
		data.setDonGia(Integer.parseInt(txtDonGia.getText()));
		if (data.getDonGia() < 1) {
			JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ!");
			return;
		}
		data.setThanhTien(data.getDonGia() * data.getSoLuong());
		lstMaSach.add(data.getMaSach());
		lstCTPN.add(data);
		binData(lstCTPN);
		txtDonGia.setText("");
		txtSach.setText("");
		spinner.setValue(1);
	}

	public void clearText() {
		txtDonGia.setText("");
		txtSach.setText("");
		txtNhaXuatBan.setText("");
		spinner.setValue(1);
	}

	public void binData(ArrayList<CTPN> lst) {
		Vector col = new Vector();
		col.add("Mã sách");
		col.add("Số lượng");
		col.add("Đơn giá");
		col.add("Thành tiền");

		Vector data = new Vector();
		for (CTPN i : lst) {
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
		cell.setCellValue(px.getNgayNhap().toString());
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
}
