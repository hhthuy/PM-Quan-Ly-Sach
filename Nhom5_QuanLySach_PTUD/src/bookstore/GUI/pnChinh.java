package bookstore.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class pnChinh extends JPanel {

	private JLabel lblDate;
	private JLabel lblTime;
	private JPanel panel_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnChinh frame = new pnChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public pnChinh() {
		initComponents();
		binDate();
		gio();
	}
	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setSize(1530,737);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(437, 5, 756, 51);
		add(panel);
		
		JLabel lblTitle = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ HIỆU SÁCH TƯ NHÂN");
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI Variable", Font.BOLD, 30));
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(724, 70, 184, 39);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblTime = new JLabel("-");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Segoe UI Variable", Font.PLAIN, 25));
		panel_1.add(lblTime);
		
		JLabel lblNewLabel = new JLabel("Ngày: ");
		lblNewLabel.setBounds(10, 705, 45, 22);
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		
		lblDate = new JLabel("Ngày:");
		lblDate.setBounds(55, 705, 72, 22);
		add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		
		ImageIcon img = new ImageIcon(GiaoDienChinh.class.getResource("/nhom05/bookstore/icon/picture1.png"));
		panel_2 = new JPanel();
		panel_2.setBounds(240, 143, 1140, 640);
		JLabel bg = new JLabel("",img,JLabel.CENTER);
		bg.setSize(1140,640);
		panel_2.add(bg);
		add(panel_2);
	}
	public void gio() {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					Calendar ca = new GregorianCalendar();
					int gio = ca.get(Calendar.HOUR);
					int phut = ca.get(Calendar.MINUTE);
					int giay = ca.get(Calendar.SECOND);
					int am_pm = ca.get(Calendar.AM_PM);
					String day_night;
					if(am_pm==1) {
						day_night = "PM";
					}else {
						day_night = "AM";
					}
					String time = gio+":"+phut+":"+giay+" "+day_night;
					lblTime.setText(time);
				}
			}
		}.start();
	}
	public void binDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        lblDate.setText(sdf.format(new Date()));
    }
	public void getDate() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binDate();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
	}
}
