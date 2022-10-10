package bookstore.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;

import bookstore.BLL.BaoCaoBanChayBLL;
import bookstore.BLL.BaoCaoDTBLL;
import bookstore.BLL.BaoCaoKHTXBLL;
import bookstore.BLL.BaoCaoPNBLL;
import bookstore.BLL.BaoCaoPXBLL;
import bookstore.Entity.BaoCaoBanChay;
import bookstore.Entity.BaoCaoDT;
import bookstore.Entity.BaoCaoKHTX;
import bookstore.Entity.BaoCaoPN;
import bookstore.Entity.BaoCaoPX;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnBaoCao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHienThi1;
	private JTextField txtHienThi2;
	private JTextField txtHienThi3;
	private JTable tbHienThi;
	private JTextField txtNgayLap;
	private JCheckBox ckbBatDau;
	private JCheckBox ckbKetThuc;
	private JDateChooser jdcKetThuc;
	private JDateChooser jdcBatDau;
	private final BaoCaoPNBLL objpn = new BaoCaoPNBLL();
	private ArrayList<BaoCaoPN> lstpn = new ArrayList<>();
	private final BaoCaoPXBLL objpx = new BaoCaoPXBLL();
	private ArrayList<BaoCaoPX> lstpx = new ArrayList<>();
	private final BaoCaoDTBLL objdt = new BaoCaoDTBLL();
	private ArrayList<BaoCaoDT> lstdt = new ArrayList<>();
	private ArrayList<BaoCaoBanChay> lst = new ArrayList<>();
	private ArrayList<BaoCaoKHTX> lstKHTX = new ArrayList<>();
	private JLabel lblHienThi3;
	private JLabel lblHienThi2;
	private JLabel lblHienThi1;
	private AbstractButton rdbNhap;
	private JRadioButton rdbXuat;
	private JRadioButton rdbDoanhThu;
	private JLabel lblNgayLap;
	private JLabel lblTitle;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JRadioButton rdbBanChay;
	private JRadioButton rdbKHThuongXuyen;

	public pnBaoCao() {
		initComponents();
		ManagerRadioButton();
	}

	public void ManagerRadioButton() {
		ButtonGroup group = new ButtonGroup();
		group.add(rdbNhap);
		group.add(rdbXuat);
		group.add(rdbDoanhThu);
		group.add(rdbBanChay);
		group.add(rdbKHThuongXuyen);
		rdbNhap.setSelected(true);
	}

	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530, 737);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 1510, 251);
		add(panel);
		panel.setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setForeground(new Color(204, 255, 255));
		jPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(10, 10, 942, 230);
		panel.add(jPanel1);

		jdcBatDau = new JDateChooser();
		jdcBatDau.setBounds(27, 104, 159, 19);
		jdcBatDau.setDateFormatString("dd/MM/yyyy");

		ckbBatDau = new JCheckBox();
		ckbBatDau.setBounds(27, 68, 117, 27);
		ckbBatDau.setText("Ngày bắt đầu");
		ckbBatDau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		ckbBatDau.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ckbBatDau.setBackground(Color.WHITE);

		ckbKetThuc = new JCheckBox();
		ckbKetThuc.setBounds(204, 66, 123, 31);
		ckbKetThuc.setText("Ngày kết thúc");
		ckbKetThuc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		ckbKetThuc.setBackground(Color.WHITE);

		jdcKetThuc = new JDateChooser();
		jdcKetThuc.setBounds(204, 104, 148, 19);
		jdcKetThuc.setDateFormatString("dd/MM/yyyy");

		rdbNhap = new JRadioButton();
		rdbNhap.setBounds(436, 8, 241, 40);
		rdbNhap.setText("Báo Cáo Nhập Hàng");
		rdbNhap.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		rdbXuat = new JRadioButton();
		rdbXuat.setBounds(436, 50, 241, 40);
		rdbXuat.setText("Báo Cáo Bán Hàng");
		rdbXuat.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		rdbDoanhThu = new JRadioButton();
		rdbDoanhThu.setBounds(436, 92, 241, 40);
		rdbDoanhThu.setText("Báo Cáo Doanh Thu");
		rdbDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jPanel1.setLayout(null);
		jPanel1.add(jdcBatDau);
		jPanel1.add(ckbBatDau);
		jPanel1.add(ckbKetThuc);
		jPanel1.add(jdcKetThuc);
		jPanel1.add(rdbNhap);
		jPanel1.add(rdbXuat);
		jPanel1.add(rdbDoanhThu);

		rdbBanChay = new JRadioButton("Top 5 sách bán chạy");
		rdbBanChay.setBounds(436, 135, 241, 40);
		jPanel1.add(rdbBanChay);
		rdbBanChay.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		rdbKHThuongXuyen = new JRadioButton("Khách hàng thường xuyên");
		rdbKHThuongXuyen.setBounds(435, 177, 267, 40);
		jPanel1.add(rdbKHThuongXuyen);
		rdbKHThuongXuyen.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JButton btnXacNhan = new JButton();
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhan();
			}
		});
		btnXacNhan.setBounds(770, 57, 114, 49);
		jPanel1.add(btnXacNhan);
		btnXacNhan.setText("Xác Nhận");
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnXacNhan.setBorder(null);
		btnXacNhan.setBackground(new Color(51, 153, 153));

		JButton btnInBaoCao = new JButton();
		btnInBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInBaoCao();
			}
		});
		btnInBaoCao.setBounds(770, 118, 120, 49);
		jPanel1.add(btnInBaoCao);
		btnInBaoCao.setText("Xuất Báo Cáo");
		btnInBaoCao.setForeground(Color.WHITE);
		btnInBaoCao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnInBaoCao.setBorder(null);
		btnInBaoCao.setBackground(new Color(51, 153, 153));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(962, 10, 538, 230);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblHienThi1 = new JLabel("Số hóa đơn:");
		lblHienThi1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHienThi1.setBounds(80, 25, 153, 25);
		panel_1.add(lblHienThi1);

		txtHienThi1 = new JTextField();
		txtHienThi1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtHienThi1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHienThi1.setBounds(243, 25, 126, 25);
		panel_1.add(txtHienThi1);
		txtHienThi1.setColumns(10);

		lblHienThi2 = new JLabel("Số lượng sách:");
		lblHienThi2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHienThi2.setBounds(80, 73, 153, 25);
		panel_1.add(lblHienThi2);

		txtHienThi2 = new JTextField();
		txtHienThi2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtHienThi2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHienThi2.setColumns(10);
		txtHienThi2.setBounds(243, 76, 126, 25);
		panel_1.add(txtHienThi2);

		txtHienThi3 = new JTextField();
		txtHienThi3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtHienThi3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHienThi3.setColumns(10);
		txtHienThi3.setBounds(243, 132, 126, 25);
		panel_1.add(txtHienThi3);

		lblHienThi3 = new JLabel("Tổng số tiền:");
		lblHienThi3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHienThi3.setBounds(80, 129, 153, 25);
		panel_1.add(lblHienThi3);

		lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNgayLap.setBounds(80, 181, 153, 25);
		panel_1.add(lblNgayLap);

		txtNgayLap = new JTextField();
		txtNgayLap.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNgayLap.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(243, 184, 126, 25);
		panel_1.add(txtNgayLap);

		lbl3 = new JLabel("VNĐ");
		lbl3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl3.setBounds(379, 132, 52, 25);
		panel_1.add(lbl3);

		lbl2 = new JLabel("Cuốn");
		lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl2.setBounds(379, 75, 52, 25);
		panel_1.add(lbl2);

		lbl1 = new JLabel("");
		lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl1.setBounds(379, 25, 52, 25);
		panel_1.add(lbl1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 316, 1510, 411);
		add(scrollPane);

		tbHienThi = new JTable();
		scrollPane.setViewportView(tbHienThi);

		lblTitle = new JLabel("_");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(616, 271, 262, 34);
		add(lblTitle);

	}

	public void btnInBaoCao() {
		String w = "";
		String w1 ="";
		try {
			w = tbHienThi.getValueAt(0, 0).toString();
		} catch (Exception e) {
		}
		if (w.equals("")) {
			JOptionPane.showMessageDialog(this, "Không có dữ liệu để in!");
			return;
		}
		if(rdbNhap.isSelected()) {
			BaoCaoPNBLL bll = new BaoCaoPNBLL();
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "2000-01-01";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else {
				w = "2000-01-01";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			}
		}else if(rdbXuat.isSelected()) {
			BaoCaoPXBLL bll = new BaoCaoPXBLL();
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "2000-01-01";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else {
				w = "2000-01-01";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			}
		}else if(rdbDoanhThu.isSelected()) {
			BaoCaoDTBLL bll = new BaoCaoDTBLL();
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "2000-01-01";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else {
				w = "2000-01-01";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			}
		}else if(rdbBanChay.isSelected()) {
			BaoCaoBanChayBLL bll = new BaoCaoBanChayBLL();
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "2000-01-01";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else {
				w = "2000-01-01";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			}
		}
		else if(rdbKHThuongXuyen.isSelected()) {
			BaoCaoKHTXBLL bll = new BaoCaoKHTXBLL();
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = ""+formatDate(jdcBatDau)+"";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "2000-01-01";
				w1 = ""+formatDate(jdcKetThuc)+"";
				bll.inBaoCao(w, w1);
			} else {
				w = "2000-01-01";
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				w1 = ""+df.format(new Date())+"";
				bll.inBaoCao(w, w1);
			}
		}
		
	}

	public String formatDate(JDateChooser date) {
		String res = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			res = df.format(date.getDate());
		} catch (Exception e) {
		}
		if (res.equals("")) {

			return null;
		}
		return res;
	}

	public boolean checkDate(JDateChooser d1, JDateChooser d2) {
		if (formatDate(d2) == null || formatDate(d1) == null) {
			return false;
		}
		if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()
				&& jdcKetThuc.getDate().compareTo(jdcBatDau.getDate()) < 0) {
			return true;
		}
		return false;
	}

	public void binDataDT(String d1, String d2) {
		lstdt = objdt.getAll(d1, d2);
		Vector col = new Vector();
		col.add("Mã sách");
		col.add("Tên sách");
		col.add("Nhà xuất bản");
		col.add("Số lượng tồn");
		col.add("Số lượng nhập");
		col.add("Số lượng bán");
		Vector data = new Vector();
        int TienNhap = 0;
        int TienBan = 0;
		for (BaoCaoDT i : lstdt) {
			TienBan = i.getTienBan();
			TienNhap = i.getTienNhap();
			Vector row = new Vector();
			row.add(i.getMaSach());
			row.add(i.getTieuDe());
			row.add(i.getTenNXB());
			row.add(i.getSoLuongTon());
			row.add(i.getSlNhap());
			row.add(i.getSlXuat());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tbHienThi.setModel(dtm);
		lblHienThi1.setText("Tổng tiền nhập sách: ");
		txtHienThi1.setText(String.valueOf(TienNhap));
		lblHienThi2.setText("Tổng tiền bán sách: ");
		txtHienThi2.setText(String.valueOf(TienBan));
		lblHienThi3.setText("Doanh thu: ");
		txtHienThi3.setText(String.valueOf(TienBan - TienNhap));
		lbl2.setText("VNĐ");
		lbl1.setText("VNĐ");
	}

	public void binDataPN(String w, String o) {
		lstpn = objpn.getAll(w, o);
		Vector col = new Vector();
		col.add("Mã phiếu nhập");
		col.add("Nhà xuất bản");
		col.add("Ngày nhập");
		col.add("Số lượng sách");
		col.add("Thành tiền");
		int soLuong = 0, thanhTien = 0;
		Vector data = new Vector();
		for (BaoCaoPN i : lstpn) {
			soLuong += i.getSoLuongSach();
			thanhTien += i.getThanhTien();
			Vector row = new Vector();
			row.add(i.getMaPhieuNhap());
			row.add(i.getNhaXuatBan());
			row.add(i.getNgayNhap());
			row.add(i.getSoLuongSach());
			row.add(i.getThanhTien());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tbHienThi.setModel(dtm);
		lblHienThi1.setText("Tổng số hóa đơn: ");
		txtHienThi1.setText(String.valueOf(lstpn.size()));
		lblHienThi2.setText("Tổng số sách nhập: ");
		txtHienThi2.setText(String.valueOf(soLuong));
		lblHienThi3.setText("Tổng số tiền: ");
		txtHienThi3.setText(String.valueOf(thanhTien));
		lbl2.setText("Cuốn");
		lbl1.setText("");
	}

	public void binDataPX(String w, String o) {
		lstpx = objpx.getAll(w, o);
		Vector col = new Vector();
		col.add("Mã phiếu xuất");
		col.add("Mã khách hàng");
		col.add("Ngày xuất");
		col.add("Số lượng sách");
		col.add("Thành tiền");
		int soLuong = 0, thanhTien = 0;
		Vector data = new Vector();
		for (BaoCaoPX i : lstpx) {
			soLuong += i.getSoLuongSach();
			thanhTien += i.getThanhTien();
			Vector row = new Vector();
			row.add(i.getMaPhieuXuat());
			row.add(i.getMaKH());
			row.add(i.getNgayXuat());
			row.add(i.getSoLuongSach());
			row.add(i.getThanhTien());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tbHienThi.setModel(dtm);
		lblHienThi1.setText("Tổng số hóa đơn:");
		txtHienThi1.setText(String.valueOf(lstpx.size()));
		lblHienThi2.setText("Tổng số sách bán:");
		txtHienThi2.setText(String.valueOf(soLuong));
		lblHienThi3.setText("Tổng số tiền:");
		txtHienThi3.setText(String.valueOf(thanhTien));
		lbl2.setText("Cuốn");
		lbl1.setText("");
	}

	public void binDataBanChay(String where) {
		bookstore.DAL.BaoCaoBanChayDAL dao = new bookstore.DAL.BaoCaoBanChayDAL();
		lst = dao.getAll(where);
		Vector col = new Vector();
		col.add("Mã sách");
		col.add("Tên sách");
		col.add("Tên tác giả");
		col.add("Giá bìa");
		col.add("Năm xuất bản");
		col.add("Số lượng bán");
		Vector data = new Vector();
		for (BaoCaoBanChay i : lst) {
			Vector row = new Vector();
			row.add(i.getSach().getMaSach());
			row.add(i.getSach().getTieuDe());
			row.add(i.getSach().getTacGia());
			row.add(i.getSach().getGiaBia());
			row.add(i.getSach().getNamXuatBan());
			row.add(i.getSoLuongBan());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tbHienThi.setModel(dtm);
	}
	public void BinDataKHTX(String where) {
		BaoCaoKHTXBLL bll = new BaoCaoKHTXBLL();
		lstKHTX = bll.getAll(where);
		Vector col = new Vector();
		col.add("Mã khách hàng");
		col.add("Tên khách hàng");
		col.add("Số điện thoại");
		col.add("Địa chỉ");
		col.add("Số hóa đơn lập");
		Vector data = new Vector();
		for (BaoCaoKHTX i : lstKHTX) {
			Vector row = new Vector();
			row.add(i.getKhachHang().getMakhachhang());
			row.add(i.getKhachHang().getTenkhachhang());
			row.add(i.getKhachHang().getSdt());
			row.add(i.getKhachHang().getDiachi());
			row.add(i.getSoLuong());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tbHienThi.setModel(dtm);
	}

	public void btnXacNhan() {
		if (checkDate(jdcBatDau, jdcKetThuc)) {
			JOptionPane.showMessageDialog(this, "Ngày kết thúc không thể nhỏ hơn ngày báo cáo!");
			return;
		}
		if (rdbNhap.isSelected()) {
			lblTitle.setText("Báo Cáo Nhập Hàng");
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				String w = "ngayNhap >= '" + formatDate(jdcBatDau) + "' and ngayNhap <= '" + formatDate(jdcKetThuc) + "'";
				binDataPN(w, "soLuongSach DESC");
				enabledText();
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				String w = "ngayNhap >= '" + formatDate(jdcBatDau) + "'";
				binDataPN(w, "soLuongSach DESC");
				enabledText();
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				String w = "ngayNhap <= '" + formatDate(jdcKetThuc) + "'";
				binDataPN(w, "soLuongSach DESC");
				enabledText();
			} else {
				binDataPN("", "soLuongSach DESC");
				enabledText();
			}
		} else if (rdbXuat.isSelected()) {
			lblTitle.setText("Báo Cáo Bán Hàng");
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				String w = "ngayXuat >= '" + formatDate(jdcBatDau) + "' and ngayXuat <= '" + formatDate(jdcKetThuc) + "'";
				binDataPX(w, "soLuongSach DESC");
				enabledText();
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				String w = "ngayXuat >= '" + formatDate(jdcBatDau) + "'";
				binDataPX(w, "soLuongSach DESC");
				enabledText();
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				String w = "ngayXuat <= '" + formatDate(jdcKetThuc) + "'";
				binDataPX(w, "soLuongSach DESC");
				enabledText();
			} else {
				binDataPX("", "soLuongSach DESC");
				enabledText();
			}
		} else if (rdbBanChay.isSelected()) {
			lblTitle.setText("Top 5 Sách Bán Chạy Nhất");
			String w = "";
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "where ngayXuat >= '" + formatDate(jdcBatDau) + "' and ngayXuat <= '" + formatDate(jdcKetThuc)
						+ "'";
				binDataBanChay(w);
				clearText();
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "where ngayXuat >= '" + formatDate(jdcBatDau) + "'";
				binDataBanChay(w);
				clearText();
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "where ngayXuat <= '" + formatDate(jdcKetThuc) + "'";
				binDataBanChay(w);
				clearText();
			} else {
				binDataBanChay(w);
				clearText();
			}
		}else if(rdbKHThuongXuyen.isSelected()) {
			String w = "";
			lblTitle.setText("Khách Hàng Thường Xuyên");
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
				if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "where p.ngayXuat >= '" + formatDate(jdcBatDau) + "' and p.ngayXuat <= '" + formatDate(jdcKetThuc)+ "'";
				BinDataKHTX(w);
				clearText();
			} else if (ckbBatDau.isSelected()) {
				if (formatDate(jdcBatDau) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "where ngayXuat >= '" + formatDate(jdcBatDau) + "'";
				BinDataKHTX(w);
				clearText();
			} else if (ckbKetThuc.isSelected()) {
				if (formatDate(jdcKetThuc) == null) {
					JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
							"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
					return;
				}
				w = "where ngayXuat <= '" + formatDate(jdcKetThuc) + "'";
				BinDataKHTX(w);
				clearText();
			} else {
				BinDataKHTX(w);
				clearText();
			}
		}else if(rdbDoanhThu.isSelected()){
			String w = "2000-01-01";
			String w1 = "";
			String w2 = "";
			if (ckbBatDau.isSelected() && ckbKetThuc.isSelected()) {
			lblTitle.setText("Báo Cáo Doanh Thu");
			if (formatDate(jdcBatDau) == null || formatDate(jdcKetThuc) == null) {
				JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
						"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
				return;
			}
			w1 = "'" + formatDate(jdcBatDau) + "'";
			w2 = "'" + formatDate(jdcKetThuc) + "'";
			binDataDT(w1, w2);
			enabledText();
		} else if (ckbBatDau.isSelected()) {
			lblTitle.setText("Báo Cáo Doanh Thu");
			if (formatDate(jdcBatDau) == null) {
				JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
						"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
				return;
			}
			w1 = "'" + formatDate(jdcBatDau) + "'";
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			w2 = "'"+df.format(new Date())+"'";
			binDataDT(w1, w2);
			enabledText();
		} else if (ckbKetThuc.isSelected()) {
			lblTitle.setText("Báo Cáo Doanh Thu");
			if (formatDate(jdcKetThuc) == null) {
				JOptionPane.showMessageDialog(this, "1.Bạn chưa chọn ngày\n2.Nhập lại đúng định dạng!",
						"Sai định dạng kiểu ngày! (dd/MM/yyyy)", 1);
				return;
			}
			w1 = "'"+w+"'";
			w2 = "'"+formatDate(jdcKetThuc)+"'";
			binDataDT(w1, w2);
			enabledText();
		} else {
			lblTitle.setText("Báo Cáo Doanh Thu");
			w1 = "'"+w+"'";
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			w2 = "'"+df.format(new Date())+"'";
			binDataDT(w1, w2);
			enabledText();
		}}

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		lblNgayLap.setText("Ngày lập:");
		txtNgayLap.setText(df.format(date));
		txtNgayLap.setEditable(false);
		String time = "";
		if (ckbBatDau.isSelected()) {
			time += formatDate(jdcBatDau);
		}
		time += "-";
		if (ckbKetThuc.isSelected()) {
			time += formatDate(jdcKetThuc);
		}
		// lbDate.setText(time);
	}
	public void clearText() {
		txtHienThi1.setText("");
		txtHienThi1.setEnabled(false);
		lblHienThi1.setEnabled(false);
		txtHienThi2.setText("");
		txtHienThi2.setEnabled(false);
		lblHienThi2.setEnabled(false);
		txtHienThi3.setText("");
		txtHienThi3.setEnabled(false);
		lblHienThi3.setEnabled(false);
		lbl1.setEnabled(false);
		lbl2.setEnabled(false);
		lbl3.setEnabled(false);
	}
	public void enabledText() {
		txtHienThi1.setEnabled(true);
		lblHienThi1.setEnabled(true);
		txtHienThi2.setEnabled(true);
		lblHienThi2.setEnabled(true);
		txtHienThi3.setEnabled(true);
		lblHienThi3.setEnabled(true);
		lbl1.setEnabled(true);
		lbl2.setEnabled(true);
		lbl3.setEnabled(true);
	}
}
