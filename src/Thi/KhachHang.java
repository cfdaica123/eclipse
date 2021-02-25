package Thi;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
public class KhachHang extends JPanel {
	private JTable table;
	private JTextField textma_kh;
	private JTextField textten_kh;
	private JTextField textngaysinh;
	private JTextField textgioitinh;
	private JTextField textdiachi;
	private JTextField textsdt;
	private DefaultTableModel dfModel;
	List<danhsach_kh> khachhang = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public KhachHang() {
		setBackground(new Color(255, 228, 225));
		setLayout(null);

		JPanel panel_nhap = new JPanel();
		panel_nhap.setBackground(new Color(176, 224, 230));
		panel_nhap.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin kh\u00E1ch h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_nhap.setBounds(6, 228, 484, 210);
		add(panel_nhap);
		panel_nhap.setLayout(null);

		JLabel lblmakh = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblmakh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmakh.setBounds(10, 27, 122, 17);
		panel_nhap.add(lblmakh);

		JLabel lbltenkh = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng:");
		lbltenkh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltenkh.setBounds(10, 54, 122, 19);
		panel_nhap.add(lbltenkh);

		JLabel lblngaysinh = new JLabel("Ng\u00E0y sinh:");
		lblngaysinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblngaysinh.setBounds(10, 83, 122, 19);
		panel_nhap.add(lblngaysinh);

		JLabel lblgioitinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblgioitinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblgioitinh.setBounds(10, 112, 81, 17);
		panel_nhap.add(lblgioitinh);

		JLabel lbldiachi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lbldiachi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldiachi.setBounds(10, 139, 81, 17);
		panel_nhap.add(lbldiachi);

		JLabel lbldienthoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lbldienthoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldienthoai.setBounds(10, 166, 122, 17);
		panel_nhap.add(lbldienthoai);

		textma_kh = new JTextField();
		textma_kh.setBounds(199, 27, 256, 19);
		panel_nhap.add(textma_kh);
		textma_kh.setColumns(10);

		textten_kh = new JTextField();
		textten_kh.setBounds(199, 56, 256, 19);
		panel_nhap.add(textten_kh);
		textten_kh.setColumns(10);

		textngaysinh = new JTextField();
		textngaysinh.setBounds(199, 85, 256, 19);
		panel_nhap.add(textngaysinh);
		textngaysinh.setColumns(10);

		textgioitinh = new JTextField();
		textgioitinh.setBounds(199, 113, 256, 19);
		panel_nhap.add(textgioitinh);
		textgioitinh.setColumns(10);

		textdiachi = new JTextField();
		textdiachi.setBounds(199, 140, 256, 19);
		panel_nhap.add(textdiachi);
		textdiachi.setColumns(10);

		textsdt = new JTextField();
		textsdt.setBounds(199, 167, 256, 19);
		panel_nhap.add(textsdt);
		textsdt.setColumns(10);

		JPanel panel_button = new JPanel();
		panel_button.setBackground(new Color(176, 224, 230));
		panel_button.setBounds(500, 228, 169, 210);
		add(panel_button);
		panel_button.setLayout(null);

		JButton btnthem = new JButton("     TH\u00CAM     ");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma_kh = textma_kh.getText();
				String ten_kh= textten_kh.getText();
				String ngaysinh = textngaysinh.getText();
				String gioitinh = textgioitinh.getText();
				String diachi = textdiachi.getText();
				String sdt_kh = textsdt.getText();
				danhsach_kh khach = new danhsach_kh(ma_kh, ten_kh, ngaysinh, gioitinh, diachi, sdt_kh);
				khachhang_list.insert(khach);

				hienthikhachhang();
			}
		});
		btnthem.setBackground(SystemColor.menu);
		btnthem.setForeground(new Color(204, 0, 0));
		btnthem.setBounds(31, 10, 116, 31);
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_button.add(btnthem);

		JButton btnxoa = new JButton("      X\u00D3A     ");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					danhsach_kh kh = khachhang.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Bạn muốn xóa dòng này không?", "Xóa dòng", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						khachhang_list.delete(kh.getMa_kh());
						hienthikhachhang();
					}
				}
			}
		});
		btnxoa.setBackground(SystemColor.menu);
		btnxoa.setForeground(new Color(153, 51, 102));
		btnxoa.setBounds(31, 64, 116, 31);
		btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_button.add(btnxoa);

		JButton btntimkiem = new JButton("  T\u00CCM KI\u1EBEM  ");
		btntimkiem.addActionListener(new ActionListener() {
			private Component panel;
			public void actionPerformed(ActionEvent e) {
				String find = JOptionPane.showInputDialog(panel, "Nhập tên bạn muốn tìm kiếm?");
				if (find.length() >= 0) {
					khachhang = khachhang_list.find(find, find);
				}
				dfModel.setRowCount(0);
				for (danhsach_kh khachhang : khachhang) {
					dfModel.addRow(new Object[] { 
							khachhang.getMa_kh(), khachhang.getTen_kh(), khachhang.getNgaysinh(), 
							khachhang.getGioitinh(), khachhang.getDiachi(), khachhang.getSdt_kh()});
				}
			}
		});
		btntimkiem.setBackground(SystemColor.menu);
		btntimkiem.setForeground(new Color(255, 0, 0));
		btntimkiem.setBounds(31, 116, 116, 31);
		btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_button.add(btntimkiem);

		JButton btnxoatrang = new JButton("X\u00D3A TR\u1EAENG");
		btnxoatrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textma_kh.setText("");
				textten_kh.setText("");
				textngaysinh.setText("");
				textgioitinh.setText("");
				textdiachi.setText("");
				textsdt.setText("");
			}
		});
		btnxoatrang.setBackground(SystemColor.control);
		btnxoatrang.setForeground(new Color(138, 43, 226));
		btnxoatrang.setBounds(31, 169, 116, 31);
		btnxoatrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_button.add(btnxoatrang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 10, 633, 200);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBackground(new Color(220, 220, 220));
		table.setForeground(new Color(153, 0, 102));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "M\u00E3 KH", " H\u1ECD t\u00EAn ", "Ng\u00E0y sinh ", "Gi\u1EDBi t\u00EDnh",
						"\u0110\u1ECBa ch\u1EC9", "S\u0110T" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		scrollPane.setViewportView(table);
		dfModel = (DefaultTableModel) table.getModel();

		hienthikhachhang();

	}

	private void hienthikhachhang() {
		khachhang = khachhang_list.findAll();
		dfModel.setRowCount(0);
		for (danhsach_kh khachhang : khachhang) {
			dfModel.addRow(new Object[] { khachhang.getMa_kh(), khachhang.getTen_kh(), khachhang.getNgaysinh(), khachhang.getGioitinh(), khachhang.getDiachi(), khachhang.getSdt_kh()});
		}

	}
}