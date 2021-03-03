package priv.matrix.student.dao;

import java.sql.SQLException;
import java.util.List;

import priv.matrix.student.entity.Admin;


/**
 * 管理员DAO接口
 */
public interface AdminDAO {
	
    /**
     * 查询�?有管理员
     *
     * @return List<Admin>
     * @throws SQLException
     */
    List<Admin> selectAdmins() throws SQLException;

    /**
     * 根据账号查询管理�?
     *
     * @param account
     * @return 
     * @throws SQLException
     */
    Admin getAdminByAccount(String account) throws SQLException;

    /**
     * 统计管理员�?�数
     *
     * @return
     * @throws SQLException
     */
    int countAdmins() throws SQLException;

    /**
     * 更新管理员信�?
     * @param admin
     * @return
     * @throws SQLException
     */
    int updateAdmin(Admin admin) throws SQLException;
}
