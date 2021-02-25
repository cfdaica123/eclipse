package Thi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class khachhang_list {
	public static List<danhsach_kh> findAll() {
		List<danhsach_kh> khachhang = new ArrayList<>();
		Connection conn = null;
		Statement statement = null; // TRUY XUAT CAU LENH
		ResultSet result = null; // KET QUA
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from KHACHHANG";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {// trung voi ten cot trong csdl
				danhsach_kh khach = new danhsach_kh(result.getString("MAKH"), result.getString("HOTENKH"),
						result.getString("NGAYSINH"), result.getString("GIOITINH"), result.getString("DIACHI"),
						result.getString("SDT"));
				khachhang.add(khach);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return khachhang;
	}

	public static void insert(danhsach_kh khach) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into KHACHHANG(MAKH, HOTENKH, NGAYSINH, GIOITINH, DIACHI, SDT) values(?,?,?,?,?,?)";

			statement = conn.prepareCall(sql);

			statement.setString(1, khach.getMa_kh());
			statement.setString(2, khach.getTen_kh());
			statement.setString(3, khach.getNgaysinh());
			statement.setString(4, khach.getGioitinh());
			statement.setString(5, khach.getDiachi());
			statement.setString(6, khach.getSdt_kh());

			statement.execute();

			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public static void delete(String MAKH) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			String sql = "delete from KHACHHANG where MAKH=?";

			statement = conn.prepareCall(sql);

			statement.setString(1, MAKH);

			statement.execute();

			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static List<danhsach_kh> find(String HOTENKH, String MAKH) {
		List<danhsach_kh> khachhang = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from KHACHHANG where HOTENKH like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + MAKH + "%");
			statement.setString(2, "%" + HOTENKH + "%");

			result = statement.executeQuery();

			while (result.next()) {
				danhsach_kh khach = new danhsach_kh(result.getString("MAKH"), result.getString("HOTENKH"),
						result.getString("NGAYSINH"), result.getString("GIOITINH"), result.getString("DIACHI"),
						result.getString("SDT"));
				khachhang.add(khach);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return khachhang;
	}

}
