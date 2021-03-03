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
        //���õ�¼����
        if (adminService.login(account, password)) {
        //if (adminService.login("admin1", "admin1")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("��ʾ");
            alert.setContentText("��¼�ɹ�!");
            alert.showAndWait();
            //������������̨
            Stage mainStage = new Stage();
            //���벼��
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
            BorderPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/css/style.css");
            mainStage.setTitle("ѧ����Ϣ����ϵͳ");
            //mainStage.setMaximized(true);
            mainStage.setScene(scene);
            //mainStage.getIcons().add(new Image("/img/logo_4.png"));
            mainStage.show();
            //���������Ա��Ϣ������������
            Admin admin = adminService.getAdminByAccount(account);
            System.out.println("adminName:\t" + admin.getName());
            MainController mainController = fxmlLoader.getController();
            mainController.setAdmin(admin);
            Stage loginStage = (Stage) accountField.getScene().getWindow();
            loginStage.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("��ʾ");
            alert.setContentText("�˺Ż�������󣬵�¼ʧ��!");
            alert.showAndWait();
        }
	}
	
	public void reset() throws Exception
	{
		accountField.clear();
		passwordField.clear();
	}
	
	

}
