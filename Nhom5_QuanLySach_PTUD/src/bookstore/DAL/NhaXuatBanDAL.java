/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.NhaXuatBan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nhom5
 */
public class NhaXuatBanDAL extends SqlDataConnection {

	private final String INSERT = "insert into tb_NXB(maNXB,tenNXB,diaChi,dienThoai,email) values(?,?,?,?,?)";
	private final String UPDATE = "UPDATE [dbo].[tb_NXB] SET [tenNXB] = ? ,[diaChi] = ? ,[dienThoai] = ? ,[email] = ? WHERE [maNXB] = ?";
	private final String DELETE = "DELETE FROM [dbo].[tb_NXB] WHERE maNXB = ?";

	public ArrayList<NhaXuatBan> getAll(String TOP, String WHERE, String ORDER) {
		String GET_ALL = "select * from tb_NXB";
		ArrayList<NhaXuatBan> arr = new ArrayList<>();
		if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
			GET_ALL = "SELECT ";
			if (TOP.length() != 0) {
				GET_ALL += "TOP " + TOP;
			}
			GET_ALL += "* FROM tb_NXB ";
			if (WHERE.length() != 0) {
				GET_ALL += "WHERE " + WHERE;
			}
			if (ORDER.length() != 0) {
				GET_ALL += "ORDER BY " + ORDER;
			}
		}
//        System.out.println(GET_ALL);
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(GET_ALL);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					NhaXuatBan item = new NhaXuatBan();
					item.setMaNXB(rs.getString("maNXB"));
					item.setTenNXB(rs.getString("tenNXB"));
					item.setDiaChi(rs.getString("diaChi"));
					item.setDienThoai(rs.getString("dienThoai"));
					item.setEmail(rs.getString("email"));
					arr.add(item);
				}
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public boolean insertData(NhaXuatBan data) {
		boolean check = false;
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, data.getMaNXB());
			ps.setString(2, data.getTenNXB());
			ps.setString(3, data.getDiaChi());
			ps.setString(4, data.getDienThoai());
			ps.setString(5, data.getEmail());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				check = true;
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public boolean updateData(NhaXuatBan data) {
		boolean check = false;
		try {
			openConnection();
			PreparedStatement ps = con.prepareCall(UPDATE);
			ps.setString(1, data.getTenNXB());
			ps.setString(2, data.getDiaChi());
			ps.setString(3, data.getDienThoai());
			ps.setString(4, data.getEmail());
			ps.setString(5, data.getMaNXB());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				check = true;
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public boolean deleteData(String id) {
		boolean check = false;
		try {
			openConnection();
			PreparedStatement ps = con.prepareCall(DELETE);
			ps.setString(1, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				check = true;
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public String getIdByName(String name) {
		String id = null;
		String sql = "select maNXB from tb_NXB where tenNXB like ?";
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public ArrayList<NhaXuatBan> search(NhaXuatBan nxb){
		ArrayList<NhaXuatBan> ls = new ArrayList<>();
		String sql = "select * from tb_NXB";
		String where = "";
		if(nxb.getTenNXB()!=null) {
			where += "tenNXB like ? AND ";
		}
		if(nxb.getDiaChi()!=null) {
			where += "diaChi like ? AND ";
		}
		if(nxb.getDienThoai()!=null) {
			where += "dienThoai like ? AND ";
		}
		if (where.length() > 0) {
            sql += " WHERE " + where.substring(0, where.length() - 5);
        }
		try {
			openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			int i = 1;
			if(nxb.getTenNXB()!=null) {
				ps.setString(i++, "%"+nxb.getTenNXB()+"%");
			}
			if(nxb.getDiaChi()!=null) {
				ps.setString(i++, "%"+nxb.getDiaChi()+"%");
			}
			if(nxb.getDienThoai()!=null) {
				ps.setString(i++, nxb.getDienThoai());
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				NhaXuatBan xb = new NhaXuatBan();
				xb.setMaNXB(rs.getString(1));
				xb.setTenNXB(rs.getString(2));
				xb.setDiaChi(rs.getString(3));
				xb.setDienThoai(rs.getString(4));
				xb.setEmail(rs.getString(5));
				ls.add(xb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
