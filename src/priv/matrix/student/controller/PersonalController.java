package priv.matrix.student.controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import priv.matrix.student.entity.Admin;
import priv.matrix.student.service.AdminService;
import priv.matrix.student.utils.ServiceFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalController implements Initializable {

    @FXML
    private Label adminName;
    @FXML
    private TextField adminPassword;
    @FXML
    private TextField adminAccount;
    @FXML
    private ImageView adminImg;

    private AdminService adminService = ServiceFactory.getAdminServiceInstance();

    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                adminName.setText(admin.getName());
                adminPassword.setText(admin.getPassword());
                adminAccount.setText(admin.getAccount());
            }
        });
    }

    public void edit() {
    	adminPassword.setEditable(true);
    	adminPassword.getStyleClass().add("input-group");
    	adminPassword.setOnMouseClicked(event -> {
    		adminPassword.setText("");
    	});
    	adminAccount.setEditable(true);
    	adminAccount.getStyleClass().add("input-group");
    	adminAccount.setOnMouseClicked(event -> {
    		adminAccount.setText("");
    	});
    }

    public void save() {
        //获取密码框的值
        String passString = adminPassword.getText().trim();
        String acntString = adminAccount.getText().trim();
        System.out.println("cko acnt PerC\t" + acntString);
        if(passString.isEmpty() || acntString.isEmpty())
        {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
        	alert.setTitle("提示信息");
        	alert.setHeaderText("输入信息不完整， 修改失败!");
        	alert.showAndWait();
        	adminPassword.setText(admin.getPassword());
        	adminAccount.setText(admin.getAccount());
        	return;
        	
        }
        //更新管理员密码
        admin.setPassword(passString);
        admin.setAccount(acntString);
        adminService.updateAdmin(admin);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setContentText("信息修改成功");
        alert.showAndWait();
    }
}
