package Thi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.MouseMotionAdapter;

public class MainFrame extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("QUẢN LÝ SẢN PHẨM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(new Color(216, 191, 216));
		panel_Menu.setBounds(681, 119, 198, 447);
		contentPane.add(panel_Menu);
		panel_Menu.setLayout(null);

		JPanel panel_trangchu = new JPanel();	
		panel_trangchu.setBackground(new Color(204, 51, 102));
		panel_trangchu.setBounds(10, 23, 178, 56);
		panel_Menu.add(panel_trangchu);
		panel_trangchu.setLayout(null);

		JPanel panel_nhanvien = new JPanel();
		panel_nhanvien.setLayout(null);
		panel_nhanvien.setBackground(new Color(51, 102, 0));
		panel_nhanvien.setBounds(10, 103, 178, 56);
		panel_Menu.add(panel_nhanvien);

		JLabel lbl_nhanvien = new JLabel("Nh\u00E2n vi\u00EAn");
		lbl_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nhanvien.setIcon(new ImageIcon(
				"C:\\Users\\phant\\Downloads\\supervisor_account-white-24dp\\2x\\baseline_supervisor_account_white_24dp.png"));
		lbl_nhanvien.setForeground(Color.WHITE);
		lbl_nhanvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_nhanvien.setBounds(0, 0, 178, 56);
		panel_nhanvien.add(lbl_nhanvien);

		JPanel panel_khachhang = new JPanel();
		panel_khachhang.setLayout(null);
		panel_khachhang.setBackground(new Color(204, 204, 0));
		panel_khachhang.setBounds(10, 186, 178, 56);
		panel_Menu.add(panel_khachhang);

		JLabel lbl_khachhang = new JLabel("Kh\u00E1ch h\u00E0ng");
		lbl_khachhang.setIcon(
				new ImageIcon("C:\\Users\\phant\\Downloads\\groups-white-24dp\\2x\\baseline_groups_white_24dp.png"));
		lbl_khachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_khachhang.setForeground(Color.WHITE);
		lbl_khachhang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_khachhang.setBounds(0, 11, 178, 34);
		panel_khachhang.add(lbl_khachhang);

		JPanel panel_hoadon = new JPanel();
		panel_hoadon.setLayout(null);
		panel_hoadon.setBackground(new Color(153, 102, 153));
		panel_hoadon.setBounds(10, 274, 178, 56);
		panel_Menu.add(panel_hoadon);

		JLabel lbl_hoadon = new JLabel("H\u00F3a \u0111\u01A1n");
		lbl_hoadon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hoadon.setIcon(new ImageIcon("C:\\Users\\phant\\Downloads\\2x\\baseline_sticky_note_2_white_24dp.png"));
		lbl_hoadon.setForeground(Color.WHITE);
		lbl_hoadon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_hoadon.setBounds(0, 0, 178, 56);
		panel_hoadon.add(lbl_hoadon);

		JPanel panel_sanpham = new JPanel();
		panel_sanpham.setLayout(null);
		panel_sanpham.setBackground(new Color(0, 139, 139));
		panel_sanpham.setBounds(10, 359, 178, 64);
		panel_Menu.add(panel_sanpham);

		JLabel lbl_sanpham = new JLabel("Sản phẩm");
		lbl_sanpham.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sanpham.setIcon(new ImageIcon("C:\\Users\\phant\\Downloads\\2x\\baseline_phone_iphone_white_24dp.png"));
		lbl_sanpham.setForeground(Color.WHITE);
		lbl_sanpham.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_sanpham.setBounds(0, 0, 178, 64);
		panel_sanpham.add(lbl_sanpham);

		JPanel panel_Table = new JPanel();
		panel_Table.setBackground(new Color(250, 235, 215));
		panel_Table.setBounds(10, 119, 669, 447);
		contentPane.add(panel_Table);

		JPanel panel_Title = new JPanel();
		panel_Title.setBackground(new Color(255, 204, 51));
		panel_Title.setBounds(10, 10, 869, 98);
		contentPane.add(panel_Title);
		panel_Title.setLayout(null);

		JLabel lbltITitle = new JLabel("CỬA HÀNG ĐIỆN THOẠI TST\r\n\r\n");
		lbltITitle.setForeground(new Color(0, 0, 128));
		lbltITitle.setBackground(new Color(175, 238, 238));
		lbltITitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltITitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltITitle.setBounds(139, 10, 575, 40);
		panel_Title.add(lbltITitle);

		JLabel lblPhone = new JLabel("SDT: 0794161220");
		lblPhone.setForeground(new Color(153, 0, 102));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(24, 69, 149, 19);
		panel_Title.add(lblPhone);

		JLabel lblNewLabel = new JLabel("Địa chỉ: 155 Trần Phú - TP Huế");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(319, 68, 222, 20);
		panel_Title.add(lblNewLabel);

		JLabel lblSlogan = new JLabel("Uy Tín - Chất Lượng - Hợp Lý");
		lblSlogan.setForeground(new Color(255, 51, 0));
		lblSlogan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSlogan.setBounds(646, 68, 213, 20);
		panel_Title.add(lblSlogan);
		
		JLabel lbltrangchu = new JLabel("Trang Chủ");
		lbltrangchu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltrangchu.setIcon(new ImageIcon("C:\\Users\\phant\\Downloads\\house-white-24dp\\2x\\baseline_house_white_24dp.png"));
		lbltrangchu.setForeground(new Color(255, 255, 255));
		lbltrangchu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltrangchu.setBounds(0, 0, 178, 56);
		panel_trangchu.add(lbltrangchu);
		
		List<DanhMuc> listDanhMuc = new ArrayList<>();
		listDanhMuc.add(new DanhMuc("TrangChu", panel_trangchu, lbltrangchu));
		listDanhMuc.add(new DanhMuc("NhanVien", panel_nhanvien, lbl_nhanvien));
		listDanhMuc.add(new DanhMuc("KhachHang", panel_khachhang, lbl_khachhang));
		listDanhMuc.add(new DanhMuc("HoaDon", panel_hoadon, lbl_hoadon));
		listDanhMuc.add(new DanhMuc("SanPham", panel_sanpham, lbl_sanpham));

		ChuyenManHinh controller = new ChuyenManHinh(panel_Table);
		panel_Table.setLayout(null);
		controller.setView(panel_trangchu, lbltrangchu); 
		controller.setEvent(listDanhMuc);
	}

}