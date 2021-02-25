package Thi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.GridLayout;
import javax.swing.DropMode;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setTitle("LOG IN");
		setBounds(100, 100, 619, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(0, 0, 603, 322);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(246, 95, 343, 129);
		panel_2.setBackground(new Color(153, 204, 255));
		panel.add(panel_2);
		panel_2.setLayout(null);

		textUser = new JTextField();
		textUser.setBounds(125, 17, 190, 25);
		textUser.setToolTipText("");
		textUser.setForeground(new Color(153, 51, 51));
		textUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		panel_2.add(textUser);
		textUser.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(125, 86, 190, 25);
		passwordField.setForeground(new Color(153, 51, 51));
		passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		panel_2.add(passwordField);
		
				JLabel lblUser = new JLabel("User Name");
				lblUser.setBounds(10, 10, 116, 37);
				panel_2.add(lblUser);
				lblUser.setForeground(new Color(153, 51, 51));
				lblUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
				
						JLabel lblPass = new JLabel("Password");
						lblPass.setBounds(10, 79, 116, 37);
						panel_2.add(lblPass);
						lblPass.setForeground(new Color(153, 51, 51));
						lblPass.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 41, 234, 256);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HightS\\Pictures\\Dự án\\Dự án\\2x\\unnamed.png"));

		JButton btnSubmit = new JButton("Đăng nhập");
		btnSubmit.setBounds(263, 262, 110, 35);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
					Connection conn = DriverManager.getConnection(dbURL);
					String query = "select * from Login where Username=? and Password=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textUser.getText());
//					pst.setString(2, passwordField.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						MainFrame main = new MainFrame();
						main.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu không đúng!");
						textUser.setText("");
						passwordField.setText("");
					}
					rs.close();
					pst.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnSubmit.setBackground(new Color(153, 153, 255));
		btnSubmit.setForeground(new Color(204, 0, 0));
		btnSubmit.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(393, 262, 110, 35);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
				passwordField.setText("");
			}
		});
		btnCancel.setForeground(new Color(153, 0, 102));
		btnCancel.setBackground(new Color(51, 204, 102));
		btnCancel.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setForeground(new Color(0, 153, 102));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 40));
		lblNewLabel.setBounds(182, 25, 282, 59);
		panel.add(lblNewLabel);
	}
}
