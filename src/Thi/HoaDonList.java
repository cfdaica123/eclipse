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


public class HoaDonList {
	public static List<List> getAll() {
		List<List> dsHD = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from HOADON";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {// trung ten cot trong csdl
//				List hd = new List(result.getString("MAHD"), result.getString("NGAYXUAT"), result.getInt("SOLUONG"),
//						result.getString("MANV"),result.getString("MAKH"),result.getString("MADT"));
//				dsHD.add(hd);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsHD;
	}
	
	public static void insert(ListHd hd) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL ="jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into HOADON(MAHD, NGAYXUAT, SOLUONG, MANV, MAKH, MADT) values(?,?,?,?,?,?)";

			statement = conn.prepareCall(sql);

			statement.setString(1, hd.getMahd());
			statement.setString(2, hd.getNgayxuat());
			statement.setInt(3, hd.getSoluong());
			statement.setString(4, hd.getManv());
			statement.setString(5, hd.getMakh());
			statement.setString(6, hd.getMadt());

			statement.execute();

			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public static void delete(String MAHD) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			String sql = "delete from HOADON where MAHD=?";

			statement = conn.prepareCall(sql);

			statement.setString(1, MAHD);

			statement.execute();

			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static List<ListHd> find(String NGAYXUAT) {
		List<ListHd> dsHD = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from HOADON where NGAYXUAT like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + NGAYXUAT + "%");

			result = statement.executeQuery();

			while (result.next()) {
//				ListHd hd = new ListHd(result.getString("MAHD"), result.getString("NGAYXUAT"), result.getInt("SOLUONG"),
//						result.getString("MANV"),result.getString("MAKH"),result.getString("MADT"));
//				dsHD.add(hd);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsHD;
	}
}

