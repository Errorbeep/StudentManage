package priv.matrix.student.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import priv.matrix.student.JCon;
import priv.matrix.student.dao.StudentDAO;
import priv.matrix.student.entity.Student;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public List<Student> selectAllStu() throws SQLException {
        List<Student> stuList = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = JCon.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM student");
        while(rs.next())
        {
        	String id = rs.getString("id");
        	String name = rs.getString("sname");
        	String gender = rs.getString("gender");
        	String address = rs.getString("address");
        	String mobile = rs.getString("mobile");
        	String dorm = rs.getString("dorm");
        	double credit = rs.getDouble("credit");
        	stuList.add(new Student(id, name, gender, address, mobile, dorm, credit));
        	
        }
        con.close();
        return stuList;
	}

	@Override
	public List<Student> selectStuLike(String keywords) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Student> stuList = new ArrayList<>();
        con = JCon.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM student WHERE sname like '%" + keywords + "%'");
        while(rs.next())
        {
        	String id = rs.getString("id");
        	String name = rs.getString("sname");
        	String gender = rs.getString("gender");
        	String address = rs.getString("address");
        	String mobile = rs.getString("mobile");
        	String dorm = rs.getString("dorm");
        	double credit = rs.getDouble("credit");
        	stuList.add(new Student(id, name, gender, address, mobile, dorm, credit));
        	
        }
        con.close();
        return stuList;
	}

	@Override
	public int deleteStuById(String id) throws SQLException {
        Connection con = null;
        Statement stmt = null;

        con = JCon.getConnection();
        stmt = con.createStatement();
        int result = stmt.executeUpdate("DELETE FROM student WHERE id = '" + id + "'");
        con.close();
        return result;
	}

	@Override
	public int updateStu(Student stu, String id) throws SQLException {
        Connection con = null;
        Statement stmt = null;

        con = JCon.getConnection();
        stmt = con.createStatement();
        System.out.println("Check out stuID" + stu.getId());
        int result = stmt.executeUpdate("UPDATE student SET id = '" + stu.getId() + "' WHERE id = '" + id + "'") +
        		stmt.executeUpdate("UPDATE student SET sname = '" + stu.getSname() + "' WHERE id = '" + id + "'") +
        		stmt.executeUpdate("UPDATE student SET gender = '" + stu.getGender() + "' WHERE id = '" + id + "'") +
        		stmt.executeUpdate("UPDATE student SET address = '" + stu.getAddress() + "' WHERE id = '" + id + "'") +
        		stmt.executeUpdate("UPDATE student SET mobile = '" + stu.getMobile() + "' WHERE id = '" + id + "'") +
        		stmt.executeUpdate("UPDATE student SET dorm = '" + stu.getDorm() + "' WHERE id = '" + id + "'") +
        		stmt.executeUpdate("UPDATE student SET credit = " + stu.getCredit() + " WHERE id = '" + id + "'");

        
        con.close();
        return result;
	}

	@Override
	public long insertStu(Student stu) throws SQLException {
        Connection con = null;
        Statement stmt = null;

        con = JCon.getConnection();
        stmt = con.createStatement();
        long result = (long) stmt.executeUpdate("INSERT INTO student VALUES('" + stu.getId() + "', '" + 
         stu.getSname() + "', '" + stu.getGender() + "', '" + stu.getAddress() + "', '" + stu.getMobile() + "', '" + 
        stu.getDorm() + "'," + stu.getCredit() +  ")");

        con.close();
        return result;
	}

	@Override
	public double getAvgCre() throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = JCon.getConnection();
        stmt = con.createStatement();

        double result = 0;
        rs = stmt.executeQuery("SELECT AVG(credit) FROM student");
        if(rs.next())
        {
        	result = rs.getDouble("AVG(CREDIT)");
        }
        con.close();
        return result;
	}

	@Override
	public int countByCre(int low, int heigh) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = JCon.getConnection();
        stmt = con.createStatement();

        int result = 0;
        rs = stmt.executeQuery("SELECT COUNT(*) FROM student WHERE credit BETWEEN " + low + "AND " + heigh);
        if(rs.next())
        {
        	result = rs.getInt("COUNT(*)");
        }
        con.close();
        return result;
	}

}
