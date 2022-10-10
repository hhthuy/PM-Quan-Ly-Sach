package bookstore.GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.GianHangBLL;
import bookstore.Entity.GianHang;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnTimLoaiSach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnTimLoaiSach frame = new pnTimLoaiSach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public pnTimLoaiSach() {
		initComponents();
		binData("", "", "");
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(250, 100, 1000, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 250, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTen = new JLabel("Tên Loại Sách:");
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(10, 10, 230, 30);
		panel.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBounds(35, 50, 181, 30);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnTimKiem.setBackground(new Color(0, 153, 153));
		btnTimKiem.setIcon(new ImageIcon(pnTimLoaiSach.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiem.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		btnTimKiem.setBorder(null);
		btnTimKiem.setBounds(73, 284, 115, 40);
		panel.add(btnTimKiem);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnTimLoaiSach.class.getResource("/nhom05/bookstore/icon/refresh-56-32.png")));
		btnLamMoi.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(0, 153, 153));
		btnLamMoi.setBounds(73, 332, 115, 40);
		panel.add(btnLamMoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(270, 10, 706, 397);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 76, 706, 321);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setGridColor(new Color(0, 153, 153));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 lo\u1EA1i s\u00E1ch", "T\u00EAn lo\u1EA1i s\u00E1ch", "M\u00F4 t\u1EA3"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 0, 706, 67);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTitle = new JLabel("TÌM KIẾM LOẠI SÁCH");
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblTitle.setBounds(10, 10, 331, 47);
		panel_3.add(lblTitle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 417, 966, 64);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnChon = new JButton("Chọn");
		btnChon.setForeground(new Color(255, 255, 255));
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonLoaiSach();
			}
		});
		btnChon.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		btnChon.setBorder(null);
		btnChon.setBackground(new Color(0, 153, 153));
		btnChon.setBounds(428, 10, 115, 40);
		panel_2.add(btnChon);
	}
	public void chonLoaiSach() {
		setVisible(false);
		pnQuanLySach.cbbGianHang.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1));
	}
	protected void clearText() {
		txtTen.setText("");
		binData("", "", "");
	}
	protected void search() {
		String w = "tenGianHang like N'" + "%" + txtTen.getText() + "%" + "'";
        binData("", w, "");
	}
	public void binData(String t, String w, String o) {
		GianHangBLL gh = new GianHangBLL();
		ArrayList<GianHang> ls = gh.getAll(t, w, o);
        Vector col = new Vector();
        col.add("Mã Gian Hàng");
        col.add("Tên Gian Hàng");
        col.add("Mô Tả");

        Vector data = new Vector();
        for (GianHang i : ls) {
            Vector row = new Vector();
            row.add(i.getMaGianHang());
            row.add(i.getTenGianHang());
            row.add(i.getMoTa());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, col);
        table.setModel(dtm);
    }
}
