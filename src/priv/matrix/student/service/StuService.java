package priv.matrix.student.service;

import java.util.List;

import priv.matrix.student.entity.Student;

public interface StuService {
	
	
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	List<Student> selectAllStu();
	
	
	/**
	 * ���������ؼ���ģ����ѯѧ����Ϣ
	 * @param keywords
	 * @return
	 */
	List<Student> selectStuLike(String keywords);
	
	
	/**
	 * ����ѧ��ɾ��ѧ����Ϣ
	 * @param id
	 * @return
	 */
	int deleteStuById(String id);
	
	
	/**
	 * ����ѧ����Ϣ
	 * @param stu
	 * @param id
	 * @return
	 */
	int updateStu(Student stu, String id);
	
	
	/**
	 * ����ѧ����Ϣ
	 * @param stu
	 * @return
	 */
	long insertStu(Student stu);

	/**
	 * ����ƽ����
	 * @return
	 */
	double getAvgCre();

	/**
	 * ���ɼ�ͳ������
	 * @param low
	 * @param heigh
	 * @return
	 */
	int countByCre(int low, int heigh);
}
