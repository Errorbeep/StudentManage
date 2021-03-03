package priv.matrix.student.utils;

import priv.matrix.student.service.AdminService;
import priv.matrix.student.service.StuService;
import priv.matrix.student.service.imp.AdminServiceImpl;
import priv.matrix.student.service.imp.StuServiceImpl;

public class ServiceFactory {

    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }

    public static StuService getStudentServiceInstance() {
        return new StuServiceImpl();
    }
}
