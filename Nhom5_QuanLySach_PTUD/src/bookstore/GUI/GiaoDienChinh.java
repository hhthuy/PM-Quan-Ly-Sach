package bookstore.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * 
 * @author Nhom5
 *
 */
public class GiaoDienChinh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienChinh frame = new GiaoDienChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GiaoDienChinh() {
		initComponents();
		giaoDienChinh();
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 619);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
		setTitle("Giao Diện Chương Trình");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHeThong = new JMenu("HỆ THỐNG");
		mnHeThong.setForeground(new Color(0, 153, 153));
		mnHeThong.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/password_50px.png")));
		mnHeThong.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		menuBar.add(mnHeThong);
		
		JMenuItem mnItemDangXuat = new JMenuItem("ĐĂNG XUẤT");
		mnItemDangXuat.setBackground(new Color(255, 255, 255));
		mnItemDangXuat.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnItemDangXuat.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/logout-26-16.png")));
		mnHeThong.add(mnItemDangXuat);
		mnItemDangXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?","Thông báo!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					frmDangNhap frm = new frmDangNhap();
				frm.setVisible(true);
				dispose();
				}else {
				}
			}
		});
		
		JMenuItem mnItemThoat = new JMenuItem("THOÁT");
		mnItemThoat.setBackground(new Color(255, 255, 255));
		mnItemThoat.setForeground(Color.RED);
		mnItemThoat.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnItemThoat.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/exit-8-16.png")));
		mnHeThong.add(mnItemThoat);
		mnItemThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát?","Thông báo!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					
				}
			}
		});
		
		JMenu mnSach = new JMenu("SÁCH");
		mnSach.setForeground(new Color(0, 153, 153));
		mnSach.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		mnSach.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/book_50px.png")));
		menuBar.add(mnSach);
		
		JMenuItem mnItemThem = new JMenuItem("KHO SÁCH");
		mnItemThem.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnItemThem.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/add_16.png")));
		mnItemThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnQuanLySach frm = new pnQuanLySach();
				swapPanel(frm);
			}
		});
		mnSach.add(mnItemThem);
		
		JMenuItem mnItemTimKiem = new JMenuItem("TÌM KIẾM SÁCH");
		mnItemTimKiem.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/search-189-16.png")));
		mnItemTimKiem.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnSach.add(mnItemTimKiem);
		mnItemTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnTimKiemSach frm = new pnTimKiemSach();
				swapPanel(frm);
			}
		});
		
		JMenuItem mnItemLoaiSach = new JMenuItem("LOẠI SÁCH");
		mnItemLoaiSach.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/commodity-category-16.png")));
		mnItemLoaiSach.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnSach.add(mnItemLoaiSach);
		mnItemLoaiSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnLoaiSach frm = new pnLoaiSach();
				swapPanel(frm);
			}
		});
		
		JMenuItem mnItemNhaXuatBan = new JMenuItem("NHÀ XUẤT BẢN");
		mnItemNhaXuatBan.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/wd-applet-supplier-management-16.png")));
		mnItemNhaXuatBan.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnSach.add(mnItemNhaXuatBan);
		mnItemNhaXuatBan.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				pnNhaXuatBan frm = new pnNhaXuatBan();
				swapPanel(frm);
			}
		});
		
		JMenu mnHoaDon = new JMenu("HÓA ĐƠN");
		mnHoaDon.setForeground(new Color(0, 153, 153));
		mnHoaDon.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		mnHoaDon.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/purchase_order_50px.png")));
		menuBar.add(mnHoaDon);
		
		JMenuItem mnItemNhap = new JMenuItem("HÓA ĐƠN NHẬP HÀNG");
		mnItemNhap.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/import-49-16.png")));
		mnItemNhap.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnHoaDon.add(mnItemNhap);
		mnItemNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnQuanLyNhapHang frm = new pnQuanLyNhapHang();
				swapPanel(frm);
			}
		});
		
		JMenuItem mnItemXuat = new JMenuItem("HÓA ĐƠN BÁN HÀNG");
		mnItemXuat.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/export-67-16.png")));
		mnItemXuat.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnHoaDon.add(mnItemXuat);
		mnItemXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnQuanLyHoaDonBanHang pn = new pnQuanLyHoaDonBanHang();
				swapPanel(pn);
			}
		});
		
		JMenu mnNhanVien = new JMenu("NHÂN VIÊN");
		mnNhanVien.setForeground(new Color(0, 153, 153));
		mnNhanVien.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/online_support_50px.png")));
		mnNhanVien.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		menuBar.add(mnNhanVien);
		
		JMenuItem mnItemQuanLyNV = new JMenuItem("QUẢN LÝ NHÂN VIÊN");
		mnItemQuanLyNV.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnItemQuanLyNV.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/employee-information-16.png")));
		mnNhanVien.add(mnItemQuanLyNV);
		
		JMenuItem mnItemTimKiemNhanVien = new JMenuItem("TÌM KIẾM NHÂN VIÊN");
		mnItemTimKiemNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnTimKiemNhanVien frm = new pnTimKiemNhanVien();
				swapPanel(frm);
			}
		});
		mnItemTimKiemNhanVien.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/search-189-16.png")));
		mnItemTimKiemNhanVien.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnNhanVien.add(mnItemTimKiemNhanVien);
		mnItemQuanLyNV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnNhanVien frm = new pnNhanVien();
				swapPanel(frm);
			}
			
		});
		
		JMenu mnKhachHang = new JMenu("KHÁCH HÀNG");
		mnKhachHang.setForeground(new Color(0, 153, 153));
		mnKhachHang.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/customer_50px.png")));
		mnKhachHang.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		menuBar.add(mnKhachHang);
		
		JMenuItem mnItemQuanLyKH = new JMenuItem("QUẢN LÝ KHÁCH HÀNG");
		mnItemQuanLyKH.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnItemQuanLyKH.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/manager-3-16.png")));
		mnKhachHang.add(mnItemQuanLyKH);
		
		JMenuItem mnItemTimKiemKH = new JMenuItem("TÌM KIẾM KHÁCH HÀNG");
		mnItemTimKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnTimKiemKhachHang frm = new pnTimKiemKhachHang();
				swapPanel(frm);
			}
		});
		mnItemTimKiemKH.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/search-189-16.png")));
		mnItemTimKiemKH.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnKhachHang.add(mnItemTimKiemKH);
		mnItemQuanLyKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnKhachHang frm = new pnKhachHang();
				swapPanel(frm);
			}
		});
		
		JMenu mnBaoCao = new JMenu("BÁO CÁO");
		mnBaoCao.setForeground(new Color(0, 153, 153));
		mnBaoCao.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/increase_50px.png")));
		mnBaoCao.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		menuBar.add(mnBaoCao);
		
		JMenuItem mnItemBaoCao = new JMenuItem("XEM BÁO CÁO");
		mnItemBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnBaoCao pn = new pnBaoCao();
				swapPanel(pn);
			}
		});
		mnItemBaoCao.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/report-center-16.png")));
		mnItemBaoCao.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnBaoCao.add(mnItemBaoCao);
		
		JMenu mnThongTin = new JMenu("THÔNG TIN");
		mnThongTin.setForeground(new Color(0, 153, 153));
		mnThongTin.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/icons8_information_32.png")));
		mnThongTin.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		menuBar.add(mnThongTin);
		
		JMenuItem mnItemXemTT = new JMenuItem("XEM THÔNG TIN");
		mnItemXemTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThongTin frm = new frmThongTin();
				frm.setVisible(true);
			}
		});
		mnItemXemTT.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/information-26-16.png")));
		mnItemXemTT.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		mnThongTin.add(mnItemXemTT);
		mnThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmThongTin frm = new frmThongTin();
				frm.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
	}
	public static void swapPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel,BorderLayout.CENTER);
		panel.setVisible(true);
	}
	public void giaoDienChinh() {
		pnChinh frm = new pnChinh();
		contentPane.add(frm, BorderLayout.SOUTH);
	}
}
