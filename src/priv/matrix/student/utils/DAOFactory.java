package priv.matrix.student.utils;

import priv.matrix.student.dao.AdminDAO;
import priv.matrix.student.dao.StudentDAO;
import priv.matrix.student.dao.impl.AdminDAOImpl;
import priv.matrix.student.dao.impl.StudentDAOImpl;

/**
 * 工厂类，用静态方法来生成各个DAO实例
 */
public class DAOFactory {
    public static AdminDAO getAdminDAOInstance() {
        return new AdminDAOImpl();
    }

    public static StudentDAO getStudentDAOInstance() {
        return new StudentDAOImpl();
    }
    
}
