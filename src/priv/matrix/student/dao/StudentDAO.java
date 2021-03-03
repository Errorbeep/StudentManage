package priv.matrix.student.dao;

import java.sql.SQLException;
import java.util.List;

import priv.matrix.student.entity.Student;

public interface StudentDAO {
	
	/**查询所有学生信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Student> selectAllStu() throws SQLException;
	
	/**按姓名对学生模糊查询
	 * 
	 * @param keywords
	 * @return
	 * @throws SQLException
	 */
	List<Student> selectStuLike(String keywords) throws SQLException;
	
	/**按学号删除学生
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteStuById(String id) throws SQLException;
	
	/**更新学生信息
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int updateStu(Student stu, String id) throws SQLException;

	/**新增学生信息
	 * 
	 * @param stu
	 * @return
	 * @throws SQLException
	 */
	long insertStu(Student stu) throws SQLException;
	
	/**
	 * 计算平均成绩
	 * @return
	 * @throws SQLException
	 */
	double getAvgCre() throws SQLException;

	/**
	 * 按成绩统计人数
	 * @param low
	 * @param heigh
	 * @return
	 * @throws SQLException
	 */
	int countByCre(int low, int heigh) throws SQLException;

}
