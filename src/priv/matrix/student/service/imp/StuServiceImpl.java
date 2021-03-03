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
			System.err.println("��ѯ����ѧ����Ϣ�����쳣��");
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
			System.err.println("ģ����ѯ�����쳣��");
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
			System.err.println("ɾ��ѧ�������쳣��");
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
			System.err.println("���¼�¼�����쳣��");
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
			System.err.println("�����¼�����쳣��");
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
			System.err.println("ͳ��ƽ���ɼ������쳣��");
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
			System.err.println("���ɼ�ͳ�����������쳣��");
			e.printStackTrace();
		}
		return result;
	}

}
