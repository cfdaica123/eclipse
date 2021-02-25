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

public class NhanVienList {
	public static List<ListNv> getAll() {
		List<ListNv> dsnv = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from NHANVIEN";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				ListNv nv = new ListNv(result.getString("MANV"), result.getString("HOTENNV"), result.getString("NGAYSINHNV"),
						result.getString("GIOITINHNV"), result.getString("DIACHINV"), result.getString("SDTNV"));
				dsnv.add(nv);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsnv;
	}
	public static void insert(ListNv nv) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into NHANVIEN(MANV, HOTENNV, NGAYSINHNV, GIOITINHNV, DIACHINV, SDTNV) values(?,?,?,?,?,?)";

			statement = conn.prepareCall(sql);

			statement.setString(1, nv.getManv());
			statement.setString(2, nv.getHoten());
			statement.setString(3, nv.getNgaysinh());
			statement.setString(4, nv.getGioitinh());
			statement.setString(5, nv.getDiachi());
			statement.setString(6, nv.getSdt());

			statement.execute();

			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	public static void delete(String manv) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			String sql = "delete from NHANVIEN where MANV=?";

			statement = conn.prepareCall(sql);

			statement.setString(1, manv);

			statement.execute();

			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	public static List<ListNv> find(String Tennv) {
		List<ListNv> dsnv = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLCH;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from NHANVIEN where HOTENNV like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + Tennv + "%");

			result = statement.executeQuery();

			while (result.next()) {
				ListNv nv = new ListNv(result.getString("MANV"), result.getString("HOTENNV"), result.getString("NGAYSINHNV"),
						result.getString("GIOITINHNV"), result.getString("DIACHINV"), result.getString("SDTNV"));
				dsnv.add(nv);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsnv;
	}
}
