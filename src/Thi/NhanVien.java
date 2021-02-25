package Thi;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class NhanVien extends JPanel {
	
	private DefaultTableModel dfModel;
	List<ListNv> dsnv = new ArrayList<>();
	
	private JTable table;
	private JTextField text_ma;
	private JTextField text_sdt;
	private JTextField text_hoten;
	private JTextField text_ngaysinh;
	private JTextField text_diachi;

	/**
	 * Create the panel.
	 */
	public NhanVien() {
		setBackground(new Color(255, 204, 255));
		setBounds(10, 119, 669, 447);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(10, 11, 487, 174);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(53, 22, 80, 14);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn:");
		lblHTn.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblHTn.setBounds(53, 47, 80, 14);
		panel.add(lblHTn);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh:");
		lblNgySinh.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblNgySinh.setBounds(53, 72, 80, 14);
		panel.add(lblNgySinh);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGiiTnh.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblGiiTnh.setBounds(53, 97, 80, 14);
		panel.add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblaCh.setBounds(53, 122, 80, 14);
		panel.add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblSinThoi.setBounds(53, 147, 80, 14);
		panel.add(lblSinThoi);
		
		text_ma = new JTextField();
		text_ma.setBounds(143, 17, 276, 20);
		panel.add(text_ma);
		text_ma.setColumns(10);
		
		text_sdt = new JTextField();
		text_sdt.setBounds(143, 142, 276, 20);
		panel.add(text_sdt);
		text_sdt.setColumns(10);
		
		text_hoten = new JTextField();
		text_hoten.setBounds(143, 42, 276, 20);
		panel.add(text_hoten);
		text_hoten.setColumns(10);
		
		text_ngaysinh = new JTextField();
		text_ngaysinh.setBounds(143, 67, 276, 20);
		panel.add(text_ngaysinh);
		text_ngaysinh.setColumns(10);
		
		text_diachi = new JTextField();
		text_diachi.setBounds(143, 117, 276, 20);
		panel.add(text_diachi);
		text_diachi.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Chưa rõ..."}));
		comboBox.setBounds(143, 91, 140, 22);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), new Color(160, 160, 160)), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(507, 11, 161, 174);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					ListNv nv = dsnv.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Bạn muốn xóa dòng này không?", "Xóa", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						SanPhamList.delete(nv.getManv());
						hienthi();
					}
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HightS\\Pictures\\D\u1EF1 \u00E1n\\D\u1EF1 \u00E1n\\2x\\Actions-edit-delete-icon.png"));
		btnNewButton.setBounds(37, 129, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Find");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String note = JOptionPane.showInputDialog(panel, "Nhập tên bạn muốn tìm kiếm?");
				if (note.length() >= 0) {
					dsnv = NhanVienList.find(note);
				}
				dfModel.setRowCount(0);
				for (ListNv nv : dsnv) {
					dfModel.addRow(new Object[] { nv.getManv(), nv.getHoten(), nv.getNgaysinh(), nv.getGioitinh(), nv.getDiachi(),
							nv.getSdt()});
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HightS\\Pictures\\D\u1EF1 \u00E1n\\D\u1EF1 \u00E1n\\2x\\search-icon.png"));
		btnNewButton_1.setBounds(37, 95, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_ma.setText("");
				text_hoten.setText("");
				text_ngaysinh.setText("");
				comboBox.setSelectedIndex(0);
				text_diachi.setText("");
				text_sdt.setText("");
			hienthi();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\HightS\\Pictures\\D\u1EF1 \u00E1n\\D\u1EF1 \u00E1n\\2x\\Button-Refresh-icon.png"));
		btnNewButton_2.setBounds(37, 61, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_ma.getText();
				String hoten = text_hoten.getText();
				String ngaysinh = text_ngaysinh.getText();
				String gioitinh = comboBox.getSelectedItem().toString();
				String diachi = text_diachi.getText();
				String sdt = text_sdt.getText();
				
				ListNv nv = new ListNv(ma, hoten, ngaysinh, gioitinh, diachi, sdt);
				NhanVienList.insert(nv);

				hienthi();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\HightS\\Pictures\\D\u1EF1 \u00E1n\\D\u1EF1 \u00E1n\\2x\\Save-as-icon.png"));
		btnNewButton_3.setBounds(37, 27, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 196, 658, 240);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MANV", "HOTENNV", "NGAYSINHNV", "GIOITINHNV", "DIACHINV", "SDTNV"
			}
		));
		scrollPane.setViewportView(table);
		
		dfModel = (DefaultTableModel) table.getModel();

		hienthi();
	}
	public void hienthi(){
		dsnv = NhanVienList.getAll();
		dfModel.setRowCount(0);
		for (ListNv nv : dsnv) { 
			dfModel.addRow(new Object[] { nv.getManv(), nv.getHoten(), nv.getNgaysinh(), nv.getGioitinh(),
					nv.getDiachi(), nv.getSdt()});
		}
	}
}
