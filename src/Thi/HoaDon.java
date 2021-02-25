package Thi;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class HoaDon extends JPanel {

	private JTextField text_mahd;
	private JTextField text_ngayxuat;
	private JTextField text_soluong;
	private JTextField text_manv;
	private JTextField text_makh;
	private JTextField text_madt;
	private JTable table;
	private DefaultTableModel dfModel;
	List<ListHd> dsHD = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public HoaDon() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 703, 450);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 486, 218);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMHan = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lblMHan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMHan.setBounds(10, 27, 95, 20);
		panel_1.add(lblMHan);

		text_mahd = new JTextField();
		text_mahd.setBounds(159, 24, 302, 20);
		panel_1.add(text_mahd);
		text_mahd.setColumns(10);

		JLabel lblNgyXut = new JLabel("Ng\u00E0y xu\u1EA5t:");
		lblNgyXut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyXut.setBounds(10, 60, 95, 19);
		panel_1.add(lblNgyXut);

		text_ngayxuat = new JTextField();
		text_ngayxuat.setBounds(159, 59, 302, 20);
		panel_1.add(text_ngayxuat);
		text_ngayxuat.setColumns(10);

		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLng.setBounds(10, 90, 95, 20);
		panel_1.add(lblSLng);

		text_soluong = new JTextField();
		text_soluong.setBounds(159, 90, 302, 20);
		panel_1.add(text_soluong);
		text_soluong.setColumns(10);

		JLabel lblMNhnVin = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMNhnVin.setBounds(10, 121, 107, 20);
		panel_1.add(lblMNhnVin);

		text_manv = new JTextField();
		text_manv.setBounds(159, 121, 302, 20);
		panel_1.add(text_manv);
		text_manv.setColumns(10);

		JLabel lblMKhchHng = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMKhchHng.setBounds(10, 153, 120, 20);
		panel_1.add(lblMKhchHng);

		text_makh = new JTextField();
		text_makh.setBounds(159, 152, 302, 20);
		panel_1.add(text_makh);
		text_makh.setColumns(10);

		JLabel lblMinThoi = new JLabel("M\u00E3 \u0111i\u1EC7n tho\u1EA1i:");
		lblMinThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinThoi.setBounds(10, 184, 120, 19);
		panel_1.add(lblMinThoi);

		text_madt = new JTextField();
		text_madt.setBounds(159, 183, 302, 20);
		panel_1.add(text_madt);
		text_madt.setColumns(10);

		JButton btnreset = new JButton("RESET");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_mahd.setText("");
				text_ngayxuat.setText("");
				text_soluong.setText("");
				text_manv.setText("");
				text_makh.setText("");
				text_madt.setText("");
			}
		});
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnreset.setBounds(536, 77, 89, 35);
		panel.add(btnreset);

		JButton btnfind = new JButton("FIND");
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String note = JOptionPane.showInputDialog(panel, "Nhập ngày xuất của hóa đơn");
				if (note.length() >= 0) {
					dsHD = HoaDonList.find(note);
				}
				dfModel.setRowCount(0);
				for (ListHd hd : dsHD) {
					dfModel.addRow(new Object[] { hd.getMahd(), hd.getNgayxuat(), hd.getSoluong(), hd.getManv(),
							hd.getMakh(), hd.getMadt() });
				}
			}
		});
		btnfind.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnfind.setBounds(536, 126, 89, 35);
		panel.add(btnfind);

		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					ListHd hd = dsHD.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Bạn muốn xóa hóa đơn này không?", "Hóa đơn",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						HoaDonList.delete(hd.getMahd());
						ShowProduce();
					}
				}
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btndelete.setBounds(536, 180, 89, 35);
		panel.add(btndelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 239, 648, 182);
		panel.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(0, 153, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "M\u00E3 HD", "Ng\u00E0y xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "M\u00E3 NV",
						"M\u00E3 KH", "M\u00E3 \u0110T" }));
		scrollPane.setViewportView(table);

		JButton btnSave = new JButton("SAVE");
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String mahd = text_mahd.getText();
//				String ngayxuat = text_ngayxuat.getText();
//				int soluong = Integer.parseInt(text_soluong.getText());
//				String manv = text_manv.getText();
//				String makh = text_makh.getText();
//				String madt = text_madt.getText();
//				// pháº£i Ä‘Ãºng trÃ¬nh tá»± bÃªn LÃ�
//				ListHd hd = new ListHd(mahd, ngayxuat, soluong, manv, makh, madt);
//				HoaDonList.insert(hd);
//
//				ShowProduce();
//			}
//		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(540, 23, 85, 35);
		panel.add(btnSave);
		dfModel = (DefaultTableModel) table.getModel();

		ShowProduce();
	}

	private void ShowProduce() {
//		dsHD = HoaDonList.getAll();
//		dfModel.setRowCount(0);
//		for (ListHd hd : dsHD) { // TEN BEN LIST
//			dfModel.addRow(new Object[] { hd.getMahd(), hd.getNgayxuat(), hd.getSoluong(), hd.getManv(), hd.getMakh(),
//					hd.getMadt() });
//		}
//
	}
}
