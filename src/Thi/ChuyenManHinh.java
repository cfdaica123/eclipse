package Thi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuyenManHinh<listDanhMuc> {
	private JPanel panelRoot;
	private String choose = "";
	private List<DanhMuc> listDanhMuc;

	public ChuyenManHinh(JPanel panelRoot) {
		this.panelRoot = panelRoot;
	}

	public void setView(JPanel panelItem, JLabel lblItem) {
		choose = "TrangChu";
		panelItem.setBackground(new Color(255, 105, 180));
		panelItem.setBackground(new Color(255, 105, 180));
		TrangChu node = new TrangChu();
		panelRoot.removeAll();
		panelRoot.setLayout(new BorderLayout());
		panelRoot.add(node);
		panelRoot.validate();
		panelRoot.repaint();
	}

	public void setEvent(List<DanhMuc> listDanhMuc) {
		this.listDanhMuc = listDanhMuc;
		for (DanhMuc item : listDanhMuc) {
			item.getLbl()
					.addMouseListener((MouseListener) new LabelEvent(item.getKind(), item.getPanel(), item.getLbl()));
		}
	}

	class LabelEvent implements MouseListener {

		private JPanel node;
		private String kind;

		private JPanel panelItem;
		private JLabel lblItem;

		public LabelEvent(String kind, JPanel PanelItem, JLabel LblItem) {
			this.kind = kind;
			this.panelItem = PanelItem;
			this.lblItem = LblItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (kind) {
			case "TrangChu":
				node = new TrangChu();
				break;
			case "NhanVien":
				node = new NhanVien();
				break;
			case "KhachHang":
				node = new KhachHang();
				break;
			case "HoaDon":
				node = new HoaDon();
				break;
			case "SanPham":
				node = new SanPham();
				break;
			default:
				break;
			}
			panelRoot.removeAll();
			panelRoot.setLayout(new BorderLayout());
			panelRoot.add(node);
			panelRoot.validate();
			panelRoot.repaint();

		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override // onmouseenter
		public void mouseEntered(MouseEvent e) {
		}

		@Override // onmouseleave
		public void mouseExited(MouseEvent e) {
		}

	}
}
