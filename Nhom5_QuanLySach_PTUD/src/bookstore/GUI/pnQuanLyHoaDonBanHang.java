package bookstore.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.CTPXBLL;
import bookstore.BLL.HoaDonBanBLL;
import bookstore.BLL.PhieuXuatBLL;
import bookstore.Entity.CTPX;
import bookstore.Entity.PhieuXuat;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnQuanLyHoaDonBanHang extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiemPX;
	private JTable tblPX;
	private JTextField txtTimKiemCTPX;
	private JTable tblCTPX;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnInHoaDon;
	static String datePrint = "";
    private PhieuXuatBLL objpx = new PhieuXuatBLL();
    private ArrayList<PhieuXuat> lstpx = new ArrayList<>();
    private CTPXBLL objctpx = new CTPXBLL();
    private ArrayList<CTPX> lstctpx = new ArrayList<>();
	private DefaultTableModel model;
    static ArrayList<CTPX> lstEditctpx = new ArrayList<>();
    static String tenKH = "";
    
    public pnQuanLyHoaDonBanHang() {
    	initComponents();
    	binDataPX("", "", "");
        binDataCTPX("", "", "");
    }
	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530,737);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "H\u00F3a \u0111\u01A1n b\u00E1n h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 695, 617);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTimKiemPX = new JLabel();
		lblTimKiemPX.setText("Tìm Kiếm Theo Mã HĐ");
		lblTimKiemPX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTimKiemPX.setBounds(10, 28, 220, 30);
		panel.add(lblTimKiemPX);
		
		txtTimKiemPX = new JTextField();
		txtTimKiemPX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtTimKiemPX.setBounds(10, 68, 284, 30);
		panel.add(txtTimKiemPX);
		
		JButton btnTimKiemPX = new JButton();
		btnTimKiemPX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimKiemPX();
			}
		});
		btnTimKiemPX.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiemPX.setText("Tìm Kiếm");
		btnTimKiemPX.setForeground(Color.WHITE);
		btnTimKiemPX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimKiemPX.setBorder(null);
		btnTimKiemPX.setBackground(new Color(51, 153, 153));
		btnTimKiemPX.setBounds(304, 62, 142, 40);
		panel.add(btnTimKiemPX);
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBorder(null);
		jScrollPane.setBounds(10, 108, 675, 499);
		panel.add(jScrollPane);
		
		tblPX = new JTable();
		tblPX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablePhieuXuatClicked();
			}
		});
		tblPX.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		jScrollPane.setViewportView(tblPX);
		
		JPanel jPanel6 = new JPanel();
		jPanel6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel6.setBackground(Color.WHITE);
		jPanel6.setBounds(10, 637, 1510, 90);
		add(jPanel6);
		
		btnLamMoi = new JButton();
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLamMoi();
			}
		});
		btnLamMoi.setBounds(220, 24, 125, 40);
		btnLamMoi.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setText("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(51, 153, 153));
		
		btnThem = new JButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem();				
			}
		});
		btnThem.setBounds(447, 24, 125, 40);
		btnThem.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
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
		btnSua.setBounds(683, 24, 125, 40);
		btnSua.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
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
		btnXoa.setBounds(940, 24, 125, 40);
		btnXoa.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
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
		btnInHoaDon.setBounds(1180, 24, 139, 40);
		btnInHoaDon.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnInHoaDon.setText("In Hóa Đơn");
		btnInHoaDon.setForeground(Color.WHITE);
		btnInHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnInHoaDon.setBorder(null);
		btnInHoaDon.setBackground(new Color(51, 153, 153));
		jPanel6.setLayout(null);
		jPanel6.add(btnLamMoi);
		jPanel6.add(btnThem);
		jPanel6.add(btnSua);
		jPanel6.add(btnXoa);
		jPanel6.add(btnInHoaDon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(715, 10, 805, 617);
		add(panel_1);
		panel_1.setLayout(null);
		
		txtTimKiemCTPX = new JTextField();
		txtTimKiemCTPX.setBounds(10, 68, 362, 30);
		panel_1.add(txtTimKiemCTPX);
		
		JLabel lblTimKiemCTPX = new JLabel();
		lblTimKiemCTPX.setText("Tìm Kiếm Theo Mã CTHĐ");
		lblTimKiemCTPX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTimKiemCTPX.setBounds(10, 32, 236, 30);
		panel_1.add(lblTimKiemCTPX);
		
		JButton btnTimKiemCTPX = new JButton();
		btnTimKiemCTPX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimKiemCTPX();
			}
		});
		btnTimKiemCTPX.setIcon(new ImageIcon(pnQuanLyHoaDonBanHang.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiemCTPX.setText("Tìm Kiếm");
		btnTimKiemCTPX.setForeground(Color.WHITE);
		btnTimKiemCTPX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimKiemCTPX.setBorder(null);
		btnTimKiemCTPX.setBackground(new Color(51, 153, 153));
		btnTimKiemCTPX.setBounds(382, 62, 137, 40);
		panel_1.add(btnTimKiemCTPX);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBorder(null);
		jScrollPane1.setBounds(10, 108, 785, 499);
		panel_1.add(jScrollPane1);
		
		tblCTPX = new JTable();
		tblCTPX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableCTPXClicked();
			}
		});
		jScrollPane1.setViewportView(tblCTPX);
	}
	private void btnSua() {  
    	pnSuaHoaDonBanHang frm = new pnSuaHoaDonBanHang();
        int row = tblPX.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn một hóa đơn trước!");
            return;
        }
        String w = "maPhieuXuat = '" + tblPX.getValueAt(row, 0).toString() + "'";
        lstEditctpx = objctpx.getAll("", w, "");
        frm.lstCTPX = objctpx.getAll("", w, "");
        tenKH = tblPX.getValueAt(row, 1).toString();
        GiaoDienChinh.swapPanel(frm);
        pnSuaHoaDonBanHang.txtKhachHang.setText(tblPX.getValueAt(row, 1).toString());
        model = new DefaultTableModel();
        DefaultTableModel old = (DefaultTableModel) pnSuaHoaDonBanHang.table.getModel();
        int n = old.getColumnCount();
        for(int i=0;i<n;i++) {
        	model.addColumn(old.getColumnName(i));
        }
        n = frm.lstCTPX.size();
        for(int i=0;i<n;i++) {
        	model.addRow(new Object[] {frm.lstCTPX.get(i).getMaSach(),frm.lstCTPX.get(i).getSoLuong(),frm.lstCTPX.get(i).getThanhTien()});
        }
        pnSuaHoaDonBanHang.table.setModel(model);
        binDataCTPX("", "", "");
        binDataPX("", "", "");
    }
	
	private void tablePhieuXuatClicked() {
        
        if (tblPX.getSelectedRow() == -1) {
            return;
        }
        int row = tblPX.getSelectedRow();
        String ID = "maPhieuXuat = '";
        ID += tblPX.getValueAt(row, 0).toString() + "'";
        binDataCTPX("", ID, "");
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(false);
    }
    private void tableCTPXClicked() {
        if (tblCTPX.getSelectedRow() == -1) {
            return;
        }
        String ID = "maPhieuXuat = '";
        ID += tblCTPX.getValueAt(tblCTPX.getSelectedRow(), 1).toString() + "'";
        binDataPX("", ID, "");
    }

    private void btnThem() {
    	pnHoaDonBanHang xuat = new pnHoaDonBanHang();
    	GiaoDienChinh.swapPanel(xuat);
        binDataCTPX("", "", "");
        binDataPX("", "", "");
    }

    private void btnXoa() {         
        int row = tblPX.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn một hóa đơn trước!");
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa bản ghi?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            objctpx.deleteData_PX(tblPX.getValueAt(row, 0).toString());
            boolean c = objpx.deleteData(tblPX.getValueAt(row, 0).toString());
            binDataCTPX("", "", "");
            binDataPX("", "", "");
            if (c) {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn không thành công!");
            }
        }

    }

    private void btnLamMoi() {         
        binDataCTPX("", "", "");
        binDataPX("", "", "");
        txtTimKiemCTPX.setText("");
        txtTimKiemPX.setText("");
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
    }
	private void btnInHoaDon() {         
        int row = tblPX.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn một hóa đơn trước!");
            return;
        }else {
        	String ma = tblPX.getValueAt(row, 0).toString();
        	HoaDonBanBLL bll = new HoaDonBanBLL();
        	bll.inHoaDon(ma);
        }
    }
	private void btnTimKiemPX() {
        
        String w = "maPhieuXuat like N'" + "%" + txtTimKiemPX.getText() + "%" + "'";
        binDataPX("", w, "");
    }
    private void btnTimKiemCTPX() {
        String w = "maCTPX like N'" + "%" + txtTimKiemCTPX.getText() + "%" + "'";
        binDataCTPX("", w, "");
    }
    public void binDataPX(String t, String w, String o) {
        lstpx = objpx.getAll(t, w, o);
        Vector<String> col = new Vector();
        col.add("Mã Hóa đơn");
        col.add("Mã Khách Hàng");
        col.add("Ngày Xuất");
        col.add("Tổng Tiền");

        Vector data = new Vector();
        for (PhieuXuat i : lstpx) {
            Vector row = new Vector();
            row.add(i.getMaPhieuXuat());
            row.add(i.getMaKH());
            row.add(i.getNgayXuat());
            row.add(i.getThanhTien());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, col);
        tblPX.setModel(dtm);
    }

    public void binDataCTPX(String t, String w, String o) {
        lstctpx = objctpx.getAll(t, w, o);
        Vector<String> col = new Vector();
        col.add("Mã CTHD");
        col.add("Mã Hóa Đơn");
        col.add("Mã Sách");
        col.add("Số Lượng");
        col.add("Thành Tiền");

        Vector data = new Vector();
        for (CTPX i : lstctpx) {
            Vector row = new Vector();
            row.add(i.getMaCTPX());
            row.add(i.getMaPhieuXuat());
            row.add(i.getMaSach());
            row.add(i.getSoLuong());
            row.add(i.getThanhTien());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, col);
        tblCTPX.setModel(dtm);
    }
    public String getIDCTPX() {
        String id = "CTPX";
        int val = 0;
        binDataCTPX("", "", "");
        int l = tblCTPX.getRowCount();
        for (int i = 0; i < l; i++) {
            if (Integer.parseInt(tblCTPX.getValueAt(i, 0).toString().substring(4)) > val) {
                val = Integer.parseInt(tblCTPX.getValueAt(i, 0).toString().substring(4));
            }
        }
        id += String.valueOf(val + 1);
        return id;
    }
    public String getIDPX() {
        String id = "PX";
        int val = 0;
        binDataPX("", "", "");
        int l = tblPX.getRowCount();
        for (int i = 0; i < l; i++) {
            if (Integer.parseInt(tblPX.getValueAt(i, 0).toString().substring(2)) > val) {
                val = Integer.parseInt(tblPX.getValueAt(i, 0).toString().substring(2));
            }
        }
        id += String.valueOf(val + 1);
        return id;
    }
}
