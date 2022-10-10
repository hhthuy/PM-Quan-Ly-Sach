package bookstore.GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bookstore.BLL.NhanVienBLL;
import bookstore.Entity.NhanVien;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.border.EtchedBorder;

/**
 * 
 * @author Nhom5
 *
 */
public class pnNhanVien extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtChucVu;
	private JButton btnSua;
	private JButton btnXoa;
	private NhanVienBLL bll = new NhanVienBLL();
	private ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
	private DefaultTableModel model;
	private JTable tblNhanVien;

	public pnNhanVien() {
		initComponents();
		binData();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530,737);
		setLayout(null);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 275, 717);
		add(panel);
		panel.setLayout(null);

		JLabel lblMa = new JLabel("Mã nhân viên:");
		lblMa.setForeground(new Color(0, 153, 153));
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setBackground(new Color(0, 153, 153));
		lblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblMa.setBounds(10, 23, 255, 30);
		panel.add(lblMa);

		JLabel lblTen = new JLabel("Tên nhân viên:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(10, 109, 255, 30);
		panel.add(lblTen);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBackground(Color.WHITE);
		lblSDT.setForeground(new Color(0, 153, 153));
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSDT.setBounds(10, 195, 255, 32);
		panel.add(lblSDT);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setForeground(new Color(0, 153, 153));
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 285, 255, 32);
		panel.add(lblDiaChi);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChucVu.setForeground(new Color(0, 153, 153));
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblChucVu.setBounds(10, 370, 255, 32);
		panel.add(lblChucVu);

		txtMa = new JTextField();
		txtMa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setBounds(36, 63, 212, 30);
		panel.add(txtMa);
		txtMa.setEditable(false);
		txtMa.setColumns(10);

		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(36, 143, 212, 30);
		panel.add(txtTen);

		txtSDT = new JTextField();
		txtSDT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(36, 239, 212, 30);
		panel.add(txtSDT);

		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(36, 324, 212, 30);
		panel.add(txtDiaChi);

		txtChucVu = new JTextField();
		txtChucVu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(36, 406, 212, 30);
		panel.add(txtChucVu);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(295, 90, 1225, 557);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1205, 537);
		panel_1.add(scrollPane);
		
		tblNhanVien = new JTable();
		tblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		tblNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Ch\u1EE9c v\u1EE5"
			}
		));
		scrollPane.setViewportView(tblNhanVien);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(295, 657, 1225, 70);
		add(panel_2);
		panel_2.setLayout(null);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.setBackground(new Color(0, 153, 153));
		btnLamMoi.setBorder(null);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnNhanVien.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBounds(84, 15, 126, 40);
		panel_2.add(btnLamMoi);

		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 153, 153));
		btnThem.setBorder(null);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhanVien();
			}
		});
		btnThem.setIcon(new ImageIcon(pnNhanVien.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThem.setBounds(305, 15, 126, 40);
		panel_2.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBorder(null);
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(0, 153, 153));
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNhanVien();
			}
		});
		btnXoa.setIcon(new ImageIcon(pnNhanVien.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoa.setBounds(738, 15, 126, 40);
		panel_2.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBorder(null);
		btnSua.setBackground(new Color(0, 153, 153));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNhanVien();
			}
		});
		btnSua.setIcon(new ImageIcon(pnNhanVien.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSua.setBounds(520, 15, 126, 40);
		panel_2.add(btnSua);

		JButton btnXuat = new JButton("Xuất danh sách");
		btnXuat.setBorder(null);
		btnXuat.setForeground(new Color(255, 255, 255));
		btnXuat.setBackground(new Color(0, 153, 153));
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXuat();
			}
		});
		btnXuat.setIcon(new ImageIcon(pnNhanVien.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnXuat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXuat.setBounds(945, 15, 173, 40);
		panel_2.add(btnXuat);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(295, 10, 1225, 70);
		add(panel_3);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(10, 0, 1165, 70);
		panel_3.add(lblTitle);
	}

	private void xoaNhanVien() {
		int row = tblNhanVien.getSelectedRow();
		if (row >= 0) {
			String id = tblNhanVien.getValueAt(row, 0).toString();
			int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa bản ghi?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if (bll.deleteNhanVien(id)) {
					binData();
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Xóa không thành công!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn bản ghi cần xóa trước");
		}
		lamMoi();
	}

	private void suaNhanVien() {
		int row = tblNhanVien.getSelectedRow();
		if (row >= 0) {
			String id = tblNhanVien.getValueAt(row, 0).toString();
			NhanVien nv = new NhanVien();
			nv.setMaNhanVien(id);
			nv.setTenNhanVien(txtTen.getText());
			nv.setSDT(txtSDT.getText());
			nv.setDiaChi(txtDiaChi.getText());
			nv.setChucVu(txtChucVu.getText());
			if (JOptionPane.showConfirmDialog(this, "Sửa bản ghi này?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (bll.updateNhanVien(nv)) {
					binData();
					JOptionPane.showMessageDialog(this, "Sửa thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa không thành công!");
				}
			}

		} else {
			JOptionPane.showMessageDialog(this, "Chọn bạn ghi cần sửa trước");
		}
		lamMoi();
	}

	private void tableClick() {
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		int row = tblNhanVien.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 nhân viên!");
		} else {
			txtMa.setText(tblNhanVien.getValueAt(row, 0).toString());
			txtTen.setText(tblNhanVien.getValueAt(row, 1).toString());
			txtSDT.setText(tblNhanVien.getValueAt(row, 2).toString());
			txtDiaChi.setText(tblNhanVien.getValueAt(row, 3).toString());
			txtChucVu.setText(tblNhanVien.getValueAt(row, 4).toString());
		}
	}

	private void themNhanVien() {
		NhanVien nv = new NhanVien();
		nv.setMaNhanVien(setID());
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên rỗng!");
		}
		nv.setTenNhanVien(txtTen.getText());
		if (txtChucVu.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Chức vụ rỗng!");
		}
		nv.setChucVu(txtChucVu.getText());
		if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ nhân viên rỗng!");
		}
		nv.setDiaChi(txtDiaChi.getText());
		if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại rỗng!");
		}
		nv.setSDT(txtSDT.getText());
		if(kiemTraSDT(txtSDT.getText())==false) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 số và bắt đầu là 0");
		}else {
			if (JOptionPane.showConfirmDialog(this, "Thêm một nhân viên mới?", "Xác nhận",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					if (bll.addNhanVien(nv) == true) {
						JOptionPane.showMessageDialog(this, "Thêm thành công!");
						lamMoi();
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại vì trùng mã nhân viên!");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			binData();
		}		
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
				toExcel(tblNhanVien, new File(file));
				if (JOptionPane.showConfirmDialog(this, "Mở file?", "Xuất file thành công!!!",
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
				JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
			}
		}
	}
	private void toExcel(JTable table, File file) throws IOException {
		String sheetName = "Sheet1";
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

	private void binData() {
		ls = bll.getAllNhanVien();
		model = new DefaultTableModel();
		DefaultTableModel oldModel = (DefaultTableModel) tblNhanVien.getModel();
		int n = oldModel.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(oldModel.getColumnName(i));
		}
		n = ls.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { ls.get(i).getMaNhanVien(), ls.get(i).getTenNhanVien(), ls.get(i).getSDT(),
					ls.get(i).getDiaChi(), ls.get(i).getChucVu() });
		}
		tblNhanVien.setModel(model);
	}

	private void lamMoi() {
		txtMa.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtChucVu.setText("");
		txtSDT.setText("");
		binData();
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
	}

	private String setID() {
		String id = "NV";
		int val = 0;
		for (int i = 0; i < tblNhanVien.getRowCount(); i++) {
			if (Integer.parseInt(tblNhanVien.getValueAt(i, 0).toString().substring(2)) > val) {
				val = Integer.parseInt(tblNhanVien.getValueAt(i, 0).toString().substring(2));
			}
		}
		id += String.valueOf(val + 1);
		return id;
	}

	private boolean kiemTraSDT(String sdt) {
		String reg = "^(0){1}[1-9]{1}[0-9]{8}$";
		boolean kt = sdt.matches(reg);
		if (kt == false) {
			return false;
		} else {
			return true;
		}
	}
}
