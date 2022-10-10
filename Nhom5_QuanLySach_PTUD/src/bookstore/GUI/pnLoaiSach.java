package bookstore.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bookstore.BLL.GianHangBLL;
import bookstore.Entity.GianHang;

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

public class pnLoaiSach extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTen;
	private JTextField txtMa;
	private JTable tblLoaiSach;
	private JTextArea txtMoTa;
	private GianHangBLL obj = new GianHangBLL();
	private ArrayList<GianHang> lst = new ArrayList<>();
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	
	public pnLoaiSach() {
		initComponents();
		binData("", "", "");
	}
	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530,737);
		setLayout(null);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(null);
		jPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel2.setBackground(Color.WHITE);
		jPanel2.setBounds(10, 10, 275, 717);
		add(jPanel2);
		
		JLabel lblMa = new JLabel();
		lblMa.setText("Mã Loại Sách");
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setForeground(new Color(51, 153, 153));
		lblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblMa.setBounds(11, 10, 254, 30);
		jPanel2.add(lblMa);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setBounds(35, 130, 209, 30);
		jPanel2.add(txtTen);
		
		JLabel lblMoTa = new JLabel();
		lblMoTa.setText("Mô tả");
		lblMoTa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoTa.setForeground(new Color(51, 153, 153));
		lblMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblMoTa.setBounds(11, 170, 254, 30);
		jPanel2.add(lblMoTa);
		
		JLabel lblTen = new JLabel();
		lblTen.setText("Tên Loại Sách");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(51, 153, 153));
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(11, 90, 254, 30);
		jPanel2.add(lblTen);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMa.setBounds(35, 50, 209, 30);
		jPanel2.add(txtMa);
		
		txtMoTa = new JTextArea();
		txtMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMoTa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMoTa.setBounds(35, 210, 209, 144);
		jPanel2.add(txtMoTa);
		
		JPanel jPanel3 = new JPanel();
		jPanel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel3.setBackground(Color.WHITE);
		jPanel3.setBounds(295, 90, 1225, 557);
		add(jPanel3);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		GroupLayout gl_jPanel3 = new GroupLayout(jPanel3);
		gl_jPanel3.setHorizontalGroup(
			gl_jPanel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jPanel3.setVerticalGroup(
			gl_jPanel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblLoaiSach = new JTable();
		tblLoaiSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		tblLoaiSach.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tblLoaiSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 lo\u1EA1i s\u00E1ch", "T\u00EAn lo\u1EA1i s\u00E1ch", "M\u00F4 t\u1EA3"
			}
		));
		jScrollPane1.setViewportView(tblLoaiSach);
		jPanel3.setLayout(gl_jPanel3);
		
		JPanel jPanel4 = new JPanel();
		jPanel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel4.setBackground(Color.WHITE);
		jPanel4.setBounds(295, 657, 1225, 70);
		add(jPanel4);
		
		JButton btnLamMoi = new JButton();
		btnLamMoi.setBounds(114, 15, 128, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLamMoi();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnLoaiSach.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setText("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(51, 153, 153));
		
		btnThem = new JButton();
		btnThem.setBounds(337, 15, 128, 40);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem();
			}
		});
		btnThem.setIcon(new ImageIcon(pnLoaiSach.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThem.setText("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThem.setBorder(null);
		btnThem.setBackground(new Color(51, 153, 153));
		
		btnSua = new JButton();
		btnSua.setBounds(561, 15, 128, 40);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua();
			}
		});
		btnSua.setIcon(new ImageIcon(pnLoaiSach.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setText("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSua.setEnabled(false);
		btnSua.setBorder(null);
		btnSua.setBackground(new Color(51, 153, 153));
		
		btnXoa = new JButton();
		btnXoa.setBounds(781, 15, 128, 40);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(pnLoaiSach.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
		btnXoa.setText("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoa.setEnabled(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(new Color(51, 153, 153));
		
		JButton btnXuat = new JButton();
		btnXuat.setBounds(998, 15, 129, 40);
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXuat();
			}
		});
		btnXuat.setIcon(new ImageIcon(pnLoaiSach.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnXuat.setText("Xuất DS");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXuat.setBorder(null);
		btnXuat.setBackground(new Color(51, 153, 153));
		jPanel4.setLayout(null);
		jPanel4.add(btnLamMoi);
		jPanel4.add(btnThem);
		jPanel4.add(btnSua);
		jPanel4.add(btnXoa);
		jPanel4.add(btnXuat);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(295, 10, 1201, 70);
		add(panel);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ LOẠI SÁCH");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(51, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setBounds(10, 0, 1181, 70);
		panel.add(lblTitle);
		
	}
	private void tableClick() {
		if (tblLoaiSach.getSelectedRow() == -1) {
			return;
		}
		else {
			btnThem.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		int row = tblLoaiSach.getSelectedRow();
		txtMa.setText(tblLoaiSach.getValueAt(row, 0).toString());
		txtTen.setText(tblLoaiSach.getValueAt(row, 1).toString());
		txtMoTa.setText(tblLoaiSach.getValueAt(row, 2).toString());
		}
		
	}
	private void btnLamMoi() {
		binData("", "", "");
		clearText();
		btnThem.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
	}

	private void btnThem() {
		GianHang data = new GianHang();
		if (txtMa.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Mã loại sách trống!");
			return;
		}
		data.setMaGianHang(txtMa.getText());
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên loại sách trống!");
			return;
		}
		data.setTenGianHang(txtTen.getText());
		data.setMoTa(txtMoTa.getText());
		if (obj.insertData(data)) {
			binData("", "", "");
			JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
		} else {
			JOptionPane.showMessageDialog(this, "Thêm mới thất bại !");
		}
		clearText();
	}

	private void btnSua() {
		int row = tblLoaiSach.getSelectedRow();
		if (row >= 0) {
			String id = tblLoaiSach.getValueAt(row, 0).toString();
			GianHang data = new GianHang();
			if (txtTen.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Tên loại sách trống!");
				return;
			}
			data.setTenGianHang(txtTen.getText());
			data.setMoTa(txtMoTa.getText());
			data.setMaGianHang(id);
			if (obj.updateData(data)) {
				binData("", "", "");
				JOptionPane.showMessageDialog(this, "Sửa thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Sửa không thành công!");
			}
			clearText();
		} else {
			JOptionPane.showMessageDialog(this, "Chọn bạn ghi cần sửa trước");
		}
	}

	private void btnXoa() {
		int row = tblLoaiSach.getSelectedRow();
		if (row >= 0) {
			String id = tblLoaiSach.getValueAt(row, 0).toString();
			int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa bản ghi?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if (obj.deleteData(id)) {
					binData("", "", "");
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Xóa không thành công!");
				}
			}
			clearText();
		} else {
			JOptionPane.showMessageDialog(this, "Chọn bạn ghi cần xóa trước");
		}
	}

	private void clearText() {
		txtMa.setText("");
		txtTen.setText("");
		txtMoTa.setText("");
	}

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
				toExcel(tblLoaiSach, new File(file));
				JOptionPane.showMessageDialog(this, "Xuất file thành công!");

			} catch (IOException ex) {
				//Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
			}
		}
	}
	private void toExcel(JTable table, File file) throws IOException {
		String sheetName = "Sheet1";// name of sheet
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		TableModel model = table.getModel();
		// Get colum name
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < model.getColumnCount(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(model.getColumnName(i).toString());
		}
		// iterating r number of rows
		for (int r = 1; r <= model.getRowCount(); r++) {
			row = sheet.createRow(r);
			// iterating c number of columns
			for (int c = 0; c < model.getColumnCount(); c++) {
				HSSFCell cell = row.createCell(c);

				cell.setCellValue(model.getValueAt(r - 1, c).toString());
			}
		}

		FileOutputStream fileOut = new FileOutputStream(file);

		// write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		wb.close();
	}
	public void binData(String t, String w, String o) {
		lst = obj.getAll(t, w, o);
		Vector col = new Vector();
		col.add("Mã Loại Sách");
		col.add("Tên Loại Sách");
		col.add("Mô Tả");

		Vector data = new Vector();
		for (GianHang i : lst) {
			Vector row = new Vector();
			row.add(i.getMaGianHang());
			row.add(i.getTenGianHang());
			row.add(i.getMoTa());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tblLoaiSach.setModel(dtm);
	}
}
