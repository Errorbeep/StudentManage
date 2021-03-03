package priv.matrix.student.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import priv.matrix.student.JCon;
import priv.matrix.student.dao.AdminDAO;
import priv.matrix.student.entity.Admin;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public List<Admin> selectAdmins() throws SQLException {
        List<Admin> adminList = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = JCon.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM t_admin");
        while(rs.next())
        {
        	Long id = new Long(rs.getInt("id"));
        	String account = rs.getString("account");
        	String password = rs.getString("password");
        	String name = rs.getString("name");
        	adminList.add(new Admin(id, account, password, name));
        	
        }
        con.close();
        return adminList;
    }

    @Override
    public Admin getAdminByAccount(String account) throws SQLException {
        Connection con = null;
        PreparedStatement pstmtSelect = null;
        ResultSet rs = null;

        con = JCon.getConnection();
        pstmtSelect = con.prepareStatement("SELECT * FROM t_admin WHERE account = ?");
        pstmtSelect.setString(1, account);
        rs = pstmtSelect.executeQuery();
        if(rs.next())
        {
        	Long id = new Long(rs.getInt("id"));
        	String password = rs.getString("password");
        	String name = rs.getString("name");
        	con.close();
        	return new Admin(id, account, password, name);
        }
        con.close();
        return null;
    }

    @Override
    public int countAdmins() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = JCon.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT COUNT(*) FROM t_admin");
        if(rs.next())
        {
        	int result = rs.getInt("COUNT(*)");
        	con.close();
        	return result;
        }
        con.close();
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) throws SQLException {
        Connection con = null;
        PreparedStatement pstmtSelect = null;

        con = JCon.getConnection();
        pstmtSelect = con.prepareStatement("UPDATE t_admin SET password = ?, account = ?, name = ? WHERE id = ?");

        System.out.println("cko acnt AdminDAO:\t" + admin.getAccount());
        pstmtSelect.setString(1, admin.getPassword());
        pstmtSelect.setString(2, admin.getAccount());
        pstmtSelect.setString(3, admin.getName());
        pstmtSelect.setLong(4, admin.getId());
        int result = pstmtSelect.executeUpdate();
        con.close();
        return result;
    }
}
