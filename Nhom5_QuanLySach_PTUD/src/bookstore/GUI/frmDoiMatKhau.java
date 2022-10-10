package bookstore.GUI;

import bookstore.BLL.NguoiDungBLL;
import bookstore.Entity.NguoiDung;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Nhom5
 */
public class frmDoiMatKhau extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NguoiDungBLL obj = new NguoiDungBLL();
    ArrayList<NguoiDung> lst = new ArrayList<>();
    /**
     * Creates new form jdDoiMatKhau
     */
    public frmDoiMatKhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(new Color(255, 255, 255));
         setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
        initComponents();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnHuy = new javax.swing.JButton();
        btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnDoiMatKhau = new javax.swing.JButton();
        btnDoiMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pw3 = new javax.swing.JPasswordField();
        pw3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pw3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pw1 = new javax.swing.JPasswordField();
        pw1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pw1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pw2 = new javax.swing.JPasswordField();
        pw2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pw2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đổi Mật Khẩu");

        jLabel1.setText("Mật Khẩu Hiện Tại:");

        jLabel2.setText("Mật Khẩu Mới:");

        jLabel3.setText("Nhập Lại Mật Khẩu Mới:");

        btnHuy.setText("Hủy Bỏ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setText("Đổi Mật Khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnDoiMatKhau)
                        .addGap(50, 50, 50)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pw1)
                            .addComponent(pw2)
                            .addComponent(pw3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pw3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String w = "taiKhoan = '" + frmDangNhap.taiKhoan + "' and matKhau = '" + pw1.getText()+ "'";
            if (obj.getAll("", w, "").isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu hiện tại!");
                pw1.setText("");
                pw2.setText("");
                pw3.setText("");
                pw1.requestFocus();
            } else if (pw2.getText().isEmpty() || pw3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới!");
                pw2.setText("");
                pw3.setText("");
                pw2.requestFocus();
                return;
            } else if (!pw2.getText().equals(pw3.getText())) {
                JOptionPane.showMessageDialog(this, "Mật khẩu mới không khớp");
                pw2.setText("");
                pw3.setText("");
                pw2.requestFocus();
                return;
            }else{
                NguoiDung data = new NguoiDung();
                data.setTaiKhoan(frmDangNhap.taiKhoan);
                data.setMatKhau(pw2.getText());
                if(obj.updateData(data)){
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
                    obj.updateDataSave(data);
                }else{
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại!");
                }
            }

        } catch (Exception e) {
        }
        this.setVisible(false);
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmDoiMatKhau dialog = new frmDoiMatKhau(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pw1;
    private javax.swing.JPasswordField pw2;
    private javax.swing.JPasswordField pw3;

}
