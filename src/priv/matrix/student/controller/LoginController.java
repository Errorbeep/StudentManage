package priv.matrix.student.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import priv.matrix.student.entity.Admin;
import priv.matrix.student.service.AdminService;
import priv.matrix.student.utils.ServiceFactory;

public class LoginController {
	
	@FXML
	private TextField accountField;
	@FXML
	private PasswordField passwordField;

    private AdminService adminService = ServiceFactory.getAdminServiceInstance();
	
	public void login() throws Exception
	{
		System.out.println("Login......");
        String account = accountField.getText().trim();
        String password = passwordField.getText().trim();
        //调用登录功能
        if (adminService.login(account, password)) {
        //if (adminService.login("admin1", "admin1")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("登录成功!");
            alert.showAndWait();
            //创建主界面舞台
            Stage mainStage = new Stage();
            //读入布局
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
            BorderPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/css/style.css");
            mainStage.setTitle("学生信息管理系统");
            //mainStage.setMaximized(true);
            mainStage.setScene(scene);
            //mainStage.getIcons().add(new Image("/img/logo_4.png"));
            mainStage.show();
            //将这个管理员信息传给主控制器
            Admin admin = adminService.getAdminByAccount(account);
            System.out.println("adminName:\t" + admin.getName());
            MainController mainController = fxmlLoader.getController();
            mainController.setAdmin(admin);
            Stage loginStage = (Stage) accountField.getScene().getWindow();
            loginStage.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
	}
	
	public void reset() throws Exception
	{
		accountField.clear();
		passwordField.clear();
	}
	
	

}
