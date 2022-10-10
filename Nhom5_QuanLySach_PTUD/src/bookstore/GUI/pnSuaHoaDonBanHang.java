package bookstore.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import bookstore.BLL.CTPXBLL;
import bookstore.BLL.PhieuXuatBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.CTPX;
import bookstore.Entity.PhieuXuat;
import bookstore.Entity.Sach;

public class pnSuaHoaDonBanHang extends JPanel {

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

	/**
	 * Create the frame.
	 */
	public pnSuaHoaDonBanHang() {
		setVisible(false);
		setSize(1530,737);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1510, 51);
		add(panel);

		JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 71, 1510, 127);
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
//				frm.setVisible(true);
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
		spinner.setBounds(529, 74, 55, 30);
		spinner.setValue(1);
		panel_1.add(spinner);

		JLabel lblNewLabel_3 = new JLabel("Cuốn");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(594, 75, 55, 30);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("Đơn giá:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(654, 75, 84, 30);
		panel_1.add(lblNewLabel_2_1);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDonGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDonGia.setEditable(false);
		txtDonGia.setBounds(748, 75, 117, 30);
		panel_1.add(txtDonGia);
		txtDonGia.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("VNĐ/Cuốn");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(875, 75, 81, 30);
		panel_1.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 208, 1510, 78);
		add(panel_2);
		panel_2.setLayout(null);

		JButton btnThem = new JButton();
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBorder(null);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem();
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
				btnXoa();
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
				btnSua();
			}
		});
		btnSua.setBackground(new Color(0, 153, 153));
		btnSua.setIcon(new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
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
		btnLamLai.setIcon(new ImageIcon(pnHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamLai.setText("Làm lại");
		btnLamLai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLamLai.setBounds(674, 23, 113, 44);
		panel_2.add(btnLamLai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 296, 1159, 431);
		add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonChiTietPhieuXuat();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(1179, 296, 341, 431);
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
		btnXoaTC.setBounds(82, 55, 176, 44);
		panel_3.add(btnXoaTC);

		JButton btnThemHD = new JButton("Cập nhật hóa đơn");
		btnThemHD.setForeground(new Color(255, 255, 255));
		btnThemHD.setBorder(null);
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaHoaDon();
			}
		});
		btnThemHD.setBackground(new Color(0, 153, 153));
		btnThemHD.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThemHD.setBounds(82, 138, 176, 44);
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
		btnHuy.setBounds(82, 217, 176, 44);
		panel_3.add(btnHuy);
	}
	public void huyBo() {
		if (JOptionPane.showConfirmDialog(this, "Bạn muốn hủy thao tác?", "Thông báo!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            lstCTPX.removeAll(lstCTPX);
            GiaoDienChinh.swapPanel(frmXuat);
        }
	}

	public void xoaALL() {
		lstCTPX.removeAll(lstCTPX);
        lstMaSach.removeAll(lstMaSach);
        binData(lstCTPX);
	}

	public void btnXoa() {
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
				//clearText();
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

	public void btnSua() {
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
			lstCTPX.get(i).setThanhTien(Integer.parseInt(txtDonGia.getText()) * lstCTPX.get(i).getSoLuong());
			binData(lstCTPX);
			//clearText();
		}
	}

	public void suaHoaDon() {
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
			JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng!");
			txtKhachHang.requestFocus();
			return;
		} else {
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
					JOptionPane.showMessageDialog(this, "Sửa phiếu xuất thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa phiếu xuất thất bại!");
				}
			}

		} 
		lstCTPX.removeAll(lstCTPX);
		this.setVisible(false);
		GiaoDienChinh.swapPanel(frmXuat);
	}

	public void btnThem() {
		lsts = sachBLL.getAll("", "", "");
		CTPX data = new CTPX();
		try {
			data.setMaSach(sachBLL.getIDByName(txtSach.getText()));
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
		String w = "maSach = '" + data.getMaSach() + "'";
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
		//clearText();
	}

	public void clearText() {
		txtDonGia.setText("");
		txtSach.setText("");
		txtKhachHang.setText("");
		spinner.setValue(1);
	}

	public void binData(ArrayList<CTPX> lst) {
		Vector col = new Vector();
		col.add("Mã sách");
		col.add("Số lượng");
//		col.add("Đơn giá");
		col.add("Thành tiền");

		Vector data = new Vector();
		for (CTPX i : lst) {
			Vector row = new Vector();
			row.add(i.getMaSach());
			row.add(i.getSoLuong());
//			row.add(i.getDonGia());
			row.add(i.getThanhTien());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		table.setModel(dtm);
	}
}
