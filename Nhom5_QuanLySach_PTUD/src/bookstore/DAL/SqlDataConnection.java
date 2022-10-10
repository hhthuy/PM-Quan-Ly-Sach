/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Nhom5
 */
public class SqlDataConnection {

	public Connection con;
	private final String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;user=sa;password=123456";

	public boolean openConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = java.sql.DriverManager.getConnection(url);
			if(con!=null) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void closeConnection() throws SQLException {
		con.close();
	}
}
