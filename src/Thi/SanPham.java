package Thi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.RootPaneUI;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SanPham extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField text_ma;
	private JTextField text_ten;
	private JTextField text_mau;
	private JTextField text_gia;
	private JTable table;
	private DefaultTableModel dfModel;
	List<ListSp> dsSP = new ArrayList<>();

	public SanPham() {
		setBackground(new Color(255, 204, 255));
		setBounds(10, 119, 669, 447);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(10, 10, 658, 382);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin \u0110T",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 11, 639, 138);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMinThoi = new JLabel("M\u00E3 \u0110T:");
		lblMinThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinThoi.setBounds(10, 28, 79, 14);
		panel_1.add(lblMinThoi);

		text_ma = new JTextField();
		text_ma.setBounds(195, 26, 282, 20);
		panel_1.add(text_ma);
		text_ma.setColumns(10);

		JLabel lblTnt = new JLabel("T\u00EAn \u0110T:");
		lblTnt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnt.setBounds(10, 52, 79, 14);
		panel_1.add(lblTnt);

		text_ten = new JTextField();
		text_ten.setBounds(195, 50, 282, 20);
		panel_1.add(text_ten);
		text_ten.setColumns(10);

		JLabel lblMuSc = new JLabel("MÀU SẮC:");
		lblMuSc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMuSc.setBounds(10, 77, 79, 14);
		panel_1.add(lblMuSc);

		text_mau = new JTextField();
		text_mau.setBounds(195, 75, 282, 20);
		panel_1.add(text_mau);
		text_mau.setColumns(10);

		JLabel lblGi = new JLabel("GIÁ:");
		lblGi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGi.setBounds(10, 102, 79, 14);
		panel_1.add(lblGi);

		text_gia = new JTextField();
		text_gia.setBounds(195, 100, 282, 20);
		panel_1.add(text_gia);
		text_gia.setColumns(10);

		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String madt = text_ma.getText();
				String tendt = text_ten.getText();
				String maudt = text_mau.getText();
				float giadt = Float.parseFloat(text_gia.getText());
				// phải đúng trình tự bên LÍ
				ListSp sp = new ListSp(madt, tendt, madt, giadt);
				SanPhamList.insert(sp);

				ShowProduce();
			}
		});
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(110, 178, 71, 23);
		panel.add(btnSave);

		JButton btnInsert = new JButton("RESET");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_ma.setText("");
				text_ten.setText("");
				text_mau.setText("");
				text_gia.setText("");
			}
		});
		btnInsert.setForeground(new Color(255, 0, 51));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBounds(221, 178, 71, 23);
		panel.add(btnInsert);

		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String note = JOptionPane.showInputDialog(panel, "Nhập tên bạn muốn tìm kiếm?");
				if (note.length() >= 0) {
					dsSP = SanPhamList.find(note);
				}
				dfModel.setRowCount(0);
				for (ListSp sp : dsSP) {
					dfModel.addRow(new Object[] { sp.getMadt(), sp.getTendt(), sp.getMaudt(), sp.getGiadt() });
				}
			}
		});
		btnFind.setForeground(new Color(0, 0, 255));
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFind.setBounds(332, 178, 71, 23);
		panel.add(btnFind);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					ListSp sp = dsSP.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Bạn muốn xóa dòng này không?", "Xóa", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						SanPhamList.delete(sp.getMadt());
						ShowProduce();
					}
				}
			}
		});
		btnDelete.setForeground(new Color(255, 102, 51));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(447, 178, 79, 23);
		panel.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 639, 153);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "M\u00E3 \u0110T", "T\u00EAn \u0110T", "M\u00E0u s\u1EAFc", "Gi\u00E1" }));
		scrollPane.setViewportView(table);
		dfModel = (DefaultTableModel) table.getModel();

		ShowProduce();

	}

	private void ShowProduce() {
		dsSP = SanPhamList.getAll();
		dfModel.setRowCount(0);
		for (ListSp sp : dsSP) { // TEN BEN LIST
			dfModel.addRow(new Object[] { sp.getMadt(), sp.getTendt(), sp.getMaudt(), sp.getGiadt() });
		}

	}

}