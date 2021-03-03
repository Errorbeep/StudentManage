package priv.matrix.student.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import priv.matrix.student.dao.StudentDAO;
import priv.matrix.student.entity.Student;
import priv.matrix.student.service.StuService;
import priv.matrix.student.utils.DAOFactory;

public class StuServiceImpl implements StuService
{
	private StudentDAO stuDAO = DAOFactory.getStudentDAOInstance();

	@Override
	public List<Student> selectAllStu() {
		List<Student> stuList = new ArrayList<>();
		
		try {
			stuList = stuDAO.selectAllStu();
		} catch (SQLException e) {
			System.err.println("查询所有学生信息出现异常！");
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public List<Student> selectStuLike(String keywords) {

		List<Student> stuList = new ArrayList<>();
		
		try {
			stuList = stuDAO.selectStuLike(keywords);
		} catch (SQLException e) {
			System.err.println("模糊查询出现异常！");
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public int deleteStuById(String id) {
		int result = 0;
		try {
			result = stuDAO.deleteStuById(id);
		} catch (SQLException e) {
			System.err.println("删除学生出现异常！");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStu(Student stu, String id) {
		int result = 0;
		try {
			result = stuDAO.updateStu(stu, id);
		} catch (SQLException e) {
			System.err.println("更新记录出现异常！");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public long insertStu(Student stu) {
		long result = 0;
		try {
			result = stuDAO.insertStu(stu);
		} catch (SQLException e) {
			System.err.println("插入记录出现异常！");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public double getAvgCre() {
		double result = 0;
		try {
			result = stuDAO.getAvgCre();
		} catch (SQLException e) {
			System.err.println("统计平均成绩出现异常！");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int countByCre(int low, int heigh) {
		int result = 0;
		try {
			result = stuDAO.countByCre(low, heigh);
		} catch (SQLException e) {
			System.err.println("按成绩统计人数出现异常！");
			e.printStackTrace();
		}
		return result;
	}

}
