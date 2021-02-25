package Thi;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class TrangChu extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChu() {
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JPanel panel_trangchu = new JPanel();
		panel_trangchu.setBackground(new Color(255, 204, 255));
		panel_trangchu.setBounds(0, 0, 671, 453);
		add(panel_trangchu);
		panel_trangchu.setLayout(null);
		
		JPanel panel_nv = new JPanel();
		panel_nv.setLayout(null);
		panel_nv.setBackground(new Color(60, 179, 113));
		panel_nv.setBounds(10, 10, 204, 147);
		panel_trangchu.add(panel_nv);
		
		JLabel lblNewLabel = new JLabel("15");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(130, 10, 58, 50);
		panel_nv.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u00E2n vi\u00EAn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_1.setBounds(92, 99, 106, 38);
		panel_nv.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\L\u1EACP TR\u00CCNH DESKTOP\\ICON\\-customer-service-agent_89777.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(147, 112, 219));
		lblNewLabel_2.setBounds(10, 38, 55, 58);
		panel_nv.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(75, 10, 4, 117);
		panel_nv.add(panel_1);
		
		JPanel panel_sp = new JPanel();
		panel_sp.setLayout(null);
		panel_sp.setBackground(new Color(0, 153, 153));
		panel_sp.setBounds(234, 10, 204, 147);
		panel_trangchu.add(panel_sp);
		
		JLabel lblNewLabel_3 = new JLabel("15");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_3.setBounds(130, 10, 58, 50);
		panel_sp.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("S\u1EA3n ph\u1EA9m");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(88, 99, 106, 38);
		panel_sp.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\L\u1EACP TR\u00CCNH DESKTOP\\ICON\\ic_phone_iphone_128_28572.png"));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(147, 112, 219));
		lblNewLabel_2_1.setBounds(10, 34, 45, 64);
		panel_sp.add(lblNewLabel_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(230, 230, 250));
		panel_1_1.setBounds(65, 10, 4, 117);
		panel_sp.add(panel_1_1);
		
		JPanel panel_kh = new JPanel();
		panel_kh.setLayout(null);
		panel_kh.setBackground(new Color(255, 153, 102));
		panel_kh.setBounds(454, 10, 204, 147);
		panel_trangchu.add(panel_kh);
		
		JLabel lblNewLabel_4 = new JLabel("15");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_4.setBounds(130, 10, 58, 50);
		panel_kh.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kh\u00E1ch h\u00E0ng ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(85, 99, 119, 38);
		panel_kh.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("D:\\L\u1EACP TR\u00CCNH DESKTOP\\ICON\\iconfinder-11-avatar-2754576_120520.png"));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(147, 112, 219));
		lblNewLabel_2_2.setBounds(10, 39, 55, 58);
		panel_kh.add(lblNewLabel_2_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(230, 230, 250));
		panel_1_2.setBounds(75, 10, 4, 117);
		panel_kh.add(panel_1_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 168, 651, 2);
		panel_trangchu.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HightS\\Pictures\\D\u1EF1 \u00E1n\\D\u1EF1 \u00E1n\\2x\\128963289_679119399324096_7903022297501364844_n.jpg"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(10, 183, 648, 270);
		panel_trangchu.add(lblNewLabel_5);

	}
}
