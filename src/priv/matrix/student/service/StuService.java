package priv.matrix.student.service;

import java.util.List;

import priv.matrix.student.entity.Student;

public interface StuService {
	
	
	/**
	 * 查询所有学生
	 * @return
	 */
	List<Student> selectAllStu();
	
	
	/**
	 * 根据姓名关键字模糊查询学生信息
	 * @param keywords
	 * @return
	 */
	List<Student> selectStuLike(String keywords);
	
	
	/**
	 * 根据学号删除学生信息
	 * @param id
	 * @return
	 */
	int deleteStuById(String id);
	
	
	/**
	 * 更新学生信息
	 * @param stu
	 * @param id
	 * @return
	 */
	int updateStu(Student stu, String id);
	
	
	/**
	 * 新增学生信息
	 * @param stu
	 * @return
	 */
	long insertStu(Student stu);

	/**
	 * 计算平均分
	 * @return
	 */
	double getAvgCre();

	/**
	 * 按成绩统计人数
	 * @param low
	 * @param heigh
	 * @return
	 */
	int countByCre(int low, int heigh);
}
