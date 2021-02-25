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
import javax.swing.JTextField;

public class SanPhamList {
	public static List<ListSp> getAll() {
		List<ListSp> dsSP = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from DIENTHOAI";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {// trung voi ten cot trong csdl
				ListSp sp = new ListSp(result.getString("MADT"), result.getString("TENDT"), result.getString("MAUSAC"),
						result.getFloat("DONGIA"));
				dsSP.add(sp);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsSP;
	}

	public static void insert(ListSp sp) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into DIENTHOAI(MADT, TENDT, MAUSAC, DONGIA) values(?,?,?,?)";

			statement = conn.prepareCall(sql);

			statement.setString(1, sp.getMadt());
			statement.setString(2, sp.getTendt());
			statement.setString(3, sp.getMaudt());
			statement.setFloat(4, sp.getGiadt());

			statement.execute();

			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public static void delete(String MANV) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			String sql = "delete from NHANVIEN where MANV=?";

			statement = conn.prepareCall(sql);

			statement.setString(1, MANV);

			statement.execute();

			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static List<ListSp> find(String Tennv) {
		List<ListSp> dsSP = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from DIENTHOAI where TENDT like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + Tennv + "%");

			result = statement.executeQuery();

			while (result.next()) {// trung voi ten cot trong csdl
				ListSp sp = new ListSp(result.getString("MADT"), result.getString("TENDT"), result.getString("MAUSAC"),
						result.getFloat("DONGIA"));
				dsSP.add(sp);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsSP;
	}
}
