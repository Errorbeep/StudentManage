package priv.matrix.student.dao;

import java.sql.SQLException;
import java.util.List;

import priv.matrix.student.entity.Student;

public interface StudentDAO {
	
	/**��ѯ����ѧ����Ϣ
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Student> selectAllStu() throws SQLException;
	
	/**��������ѧ��ģ����ѯ
	 * 
	 * @param keywords
	 * @return
	 * @throws SQLException
	 */
	List<Student> selectStuLike(String keywords) throws SQLException;
	
	/**��ѧ��ɾ��ѧ��
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteStuById(String id) throws SQLException;
	
	/**����ѧ����Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int updateStu(Student stu, String id) throws SQLException;

	/**����ѧ����Ϣ
	 * 
	 * @param stu
	 * @return
	 * @throws SQLException
	 */
	long insertStu(Student stu) throws SQLException;
	
	/**
	 * ����ƽ���ɼ�
	 * @return
	 * @throws SQLException
	 */
	double getAvgCre() throws SQLException;

	/**
	 * ���ɼ�ͳ������
	 * @param low
	 * @param heigh
	 * @return
	 * @throws SQLException
	 */
	int countByCre(int low, int heigh) throws SQLException;

}
