package bookstore.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bookstore.BLL.KhachHangBLL;
import bookstore.Entity.KhachHang;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnKhachHang extends JPanel {
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTable tblKhachHang;
	private JButton btnThemMoi;
	private JButton btnLamMoi;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXuat;
	private KhachHangBLL obj = new KhachHangBLL();
	private ArrayList<KhachHang> lst = new ArrayList<>();
	private JPanel panel3;
	private JLabel lblTitle;

	public pnKhachHang() {
		initComponents();
		binData("", "", "");
	}

	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530, 737);
		setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(null);
		jPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(10, 10, 275, 717);
		jPanel1.setLayout(null);
		add(jPanel1);

		JLabel lblMa = new JLabel();
		lblMa.setText("M?? Kh??ch H??ng:");
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setForeground(new Color(0, 153, 153));
		lblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblMa.setBackground(Color.WHITE);
		lblMa.setBounds(11, 6, 254, 30);
		jPanel1.add(lblMa);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setEditable(false);
		txtMa.setBounds(35, 46, 210, 30);
		jPanel1.add(txtMa);

		JLabel lblTen = new JLabel();
		lblTen.setText("T??n Kh??ch H??ng:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(11, 86, 254, 30);
		jPanel1.add(lblTen);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBounds(35, 126, 210, 30);
		jPanel1.add(txtTen);

		JLabel lblSDT = new JLabel();
		lblSDT.setText("S??? ??i???n Tho???i:");
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDT.setForeground(new Color(0, 153, 153));
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSDT.setBackground(Color.RED);
		lblSDT.setBounds(11, 166, 254, 30);
		jPanel1.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSDT.setBounds(35, 206, 210, 30);
		jPanel1.add(txtSDT);

		JLabel lblDiaChi = new JLabel();
		lblDiaChi.setText("?????a Ch???:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setForeground(new Color(0, 153, 153));
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDiaChi.setBounds(11, 246, 254, 30);
		jPanel1.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setBounds(35, 286, 210, 30);
		jPanel1.add(txtDiaChi);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBounds(295, 90, 1225, 558);
		add(panel2);
		panel2.setLayout(null);

		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jScrollPane1.setBounds(10, 10, 1205, 538);
		panel2.add(jScrollPane1);

		tblKhachHang = new JTable();
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		tblKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tblKhachHang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 kh\u00E1ch h\u00E0ng",
				"T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9" }));
		jScrollPane1.setViewportView(tblKhachHang);

		JPanel jPanel4 = new JPanel();
		jPanel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel4.setBackground(Color.WHITE);
		jPanel4.setBounds(295, 657, 1225, 70);
		add(jPanel4);

		btnLamMoi = new JButton();
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLamMoi();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnKhachHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setText("L??m M???i");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBorderPainted(false);
		btnLamMoi.setBackground(new Color(0, 153, 153));

		btnThemMoi = new JButton();
		btnThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemMoi();
			}
		});
		btnThemMoi.setIcon(new ImageIcon(pnKhachHang.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThemMoi.setText("Th??m M???i");
		btnThemMoi.setForeground(Color.WHITE);
		btnThemMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThemMoi.setBorderPainted(false);
		btnThemMoi.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThemMoi.setBackground(new Color(0, 153, 153));

		btnSua = new JButton();
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua();
			}
		});
		btnSua.setIcon(
				new ImageIcon(pnKhachHang.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setText("S???a");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSua.setEnabled(false);
		btnSua.setBorderPainted(false);
		btnSua.setBackground(new Color(0, 153, 153));

		btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(pnKhachHang.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
		btnXoa.setText("X??a");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoa.setEnabled(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(new Color(51, 153, 153));

		btnXuat = new JButton();
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXuat();
			}
		});
		btnXuat.setIcon(new ImageIcon(pnKhachHang.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnXuat.setText("Xu???t DS");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXuat.setBorder(null);
		btnXuat.setBackground(new Color(51, 153, 153));
		GroupLayout gl_jPanel4 = new GroupLayout(jPanel4);
		gl_jPanel4.setHorizontalGroup(
			gl_jPanel4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPanel4.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(btnLamMoi)
					.addGap(65)
					.addComponent(btnThemMoi)
					.addGap(66)
					.addComponent(btnSua)
					.addGap(69)
					.addComponent(btnXoa)
					.addGap(63)
					.addComponent(btnXuat, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(117))
		);
		gl_jPanel4.setVerticalGroup(
			gl_jPanel4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel4.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_jPanel4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXuat, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemMoi)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_jPanel4.linkSize(SwingConstants.VERTICAL, new Component[] {btnLamMoi, btnThemMoi, btnSua, btnXoa});
		gl_jPanel4.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnLamMoi, btnThemMoi, btnSua, btnXoa});
		jPanel4.setLayout(gl_jPanel4);
		
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(295, 10, 1225, 70);
		add(panel3);
		
		lblTitle = new JLabel("QU???N L?? KH??CH H??NG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setBounds(10, 0, 1205, 70);
		panel3.add(lblTitle);
	}

	public void binData(String t, String w, String o) {
		lst = obj.getAll(t, w, o);
		Vector col = new Vector();
		col.add("M?? kh??ch h??ng");
		col.add("T??n kh??ch h??ng");
		col.add("S??? ??i???n tho???i");
		col.add("?????a ch???");

		Vector data = new Vector();
		for (KhachHang i : lst) {
			Vector row = new Vector();
			row.add(i.getMakhachhang());
			row.add(i.getTenkhachhang());
			row.add(i.getSdt());
			row.add(i.getDiachi());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tblKhachHang.setModel(dtm);
	}

	private void tableClick() {
		if (tblKhachHang.getSelectedRow() == -1) {
			return;
		}
		btnThemMoi.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);

		int row = tblKhachHang.getSelectedRow();
		txtMa.setText(tblKhachHang.getValueAt(row, 0).toString());
		txtTen.setText(tblKhachHang.getValueAt(row, 1).toString());
		txtSDT.setText(tblKhachHang.getValueAt(row, 2).toString());
		txtDiaChi.setText(tblKhachHang.getValueAt(row, 3).toString());
	}

	private void btnThemMoi() {
		KhachHang data = new KhachHang();
		data.setMakhachhang(setID());
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "T??n Kh??ch h??ng tr???ng!");
		}
		data.setTenkhachhang(txtTen.getText());
		if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "SDT tr???ng!");
		}
		data.setSdt(txtSDT.getText());
		if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "?????a ch??? tr???ng!");
		}
		data.setDiachi(txtDiaChi.getText());
		if (kiemTraSDT(txtSDT.getText()) == false) {
			JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i ph???i c?? 10 s??? v?? b???t ?????u l?? 0");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Th??m m???i b???n ghi?", "Th??ng b??o!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (obj.insertData(data) == true) {
					binData("", "", "");
					JOptionPane.showMessageDialog(this, "Th??m m???i th??nh c??ng !");
				} else {
					JOptionPane.showMessageDialog(this, "Th??m m???i th???t b???i !");
				}
			}
			clearText();
		}
	}

	private void btnSua() {
		int row = tblKhachHang.getSelectedRow();
		if (row >= 0) {

			String id = tblKhachHang.getValueAt(row, 0).toString();
			KhachHang data = new KhachHang();
			data.setMakhachhang(id);
			if (txtTen.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "T??n Kh??ch h??ng tr???ng!");
			}
			data.setTenkhachhang(txtTen.getText());
			if (txtSDT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "SDT tr???ng!");
			}
			data.setSdt(txtSDT.getText());
			if (txtDiaChi.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "?????a ch??? tr???ng!");
			}
			data.setDiachi(txtDiaChi.getText());
			if (kiemTraSDT(txtSDT.getText()) == false) {
				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i ph???i c?? 10 s??? v?? b???t ?????u l?? 0");
			} else {
				if (JOptionPane.showConfirmDialog(this, "S???a b???n ghi n??y?", "Th??ng b??o",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (obj.updateData(data)) {
						binData("", "", "");
						JOptionPane.showMessageDialog(this, "S???a th??nh c??ng!");
						clearText();
					} else {
						JOptionPane.showMessageDialog(this, "S???a kh??ng th??nh c??ng!");
						clearText();
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Ch???n b???n ghi c???n s???a tr?????c");
		}
		//clearText();
	}

	private void btnXoa() {
		int row = tblKhachHang.getSelectedRow();
		if (row >= 0) {
			String id = tblKhachHang.getValueAt(row, 0).toString();
			int dialogResult = JOptionPane.showConfirmDialog(this, "B???n mu???n x??a b???n ghi?", "C???nh b??o",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if (obj.deleteData(id)) {
					binData("", "", "");
					JOptionPane.showMessageDialog(this, "X??a th??nh c??ng!");
				} else {
					JOptionPane.showMessageDialog(this, "X??a kh??ng th??nh c??ng!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Ch???n b???n ghi c???n x??a tr?????c");
		}
		clearText();
	}

	private void btnLamMoi() {
		binData("", "", "");
		clearText();
		btnSua.setEnabled(false);
		btnThemMoi.setEnabled(true);
		btnXoa.setEnabled(false);
	}

	// xu???t ra file excel
	private void btnXuat() {
		JFileChooser fc = new JFileChooser();
		int option = fc.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			String filename = fc.getSelectedFile().getName();
			String path = fc.getSelectedFile().getParentFile().getPath();
			int len = filename.length();
			String ext = "";
			String file = "";

			if (len > 4) {
				ext = filename.substring(len - 4, len);
			}

			if (ext.equals(".xls")) {
				file = path + "\\" + filename;
			} else {
				file = path + "\\" + filename + ".xls";
			}
			try {
				toExcel(tblKhachHang, new File(file));
				if (JOptionPane.showConfirmDialog(this, "M??? file?", "Xu???t file th??nh c??ng!!!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					File f = new File(file);
					try {
						Desktop.getDesktop().open(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException ex) {
				//Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(this, "Xu???t file kh??ng th??nh c??ng!");
			}
		}
	}

	public void toExcel(JTable table, File file) throws IOException {
		String sheetName = "Sheet1";// T??n sheet
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		TableModel model = table.getModel();
		// L???y t??n c???t
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < model.getColumnCount(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(model.getColumnName(i).toString());
		}
		for (int r = 1; r <= model.getRowCount(); r++) {
			row = sheet.createRow(r);
			for (int c = 0; c < model.getColumnCount(); c++) {
				HSSFCell cell = row.createCell(c);

				cell.setCellValue(model.getValueAt(r - 1, c).toString());
			}
		}

		FileOutputStream fileOut = new FileOutputStream(file);

		// ghi workbook t??? Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		wb.close();
	}

	// l??m m???i text
	private void clearText() {
		txtMa.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
	}

	// ki???m tra s??? ??i???n tho???i
	public boolean kiemTraSDT(String sdt) {
		String reg = "^(0){1}[1-9]{1}[0-9]{8}$";
		boolean kt = sdt.matches(reg);
		if (kt == false) {
			return false;
		} else {
			return true;
		}
	}

	// t???o id t??? ?????ng
	public String setID() {
		String id = "KH";
		int val = 0;
		for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
			if (Integer.parseInt(tblKhachHang.getValueAt(i, 0).toString().substring(2)) > val) {
				val = Integer.parseInt(tblKhachHang.getValueAt(i, 0).toString().substring(2));
			}
		}
		id += String.valueOf(val + 1);
		return id;
	}
}
