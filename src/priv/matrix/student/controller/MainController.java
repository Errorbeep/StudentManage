package priv.matrix.student.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import priv.matrix.student.entity.Admin;

public class MainController implements Initializable{
	
	@FXML
	private StackPane mainContainer;
	
	@FXML
	private Label adminNameLab;
	
    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //显示管理员姓名
                adminNameLab.setText(admin.getName());
            }
        });
        try {
            AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/Stu_info.fxml")).load();
            mainContainer.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    private void switchView(String fileName) throws Exception {
        //清空原有内容
        mainContainer.getChildren().clear();
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }

    public void viewStu() throws Exception {
        switchView("stu_info.fxml");
    }

    public void viewCredits() throws Exception {
        switchView("CreditAnalysis.fxml");
    }

    public void viewAdmin() throws Exception {
        switchView("Admin_info.fxml");
    }

    public void listPersonal() throws Exception {
        mainContainer.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/personal.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        mainContainer.getChildren().add(anchorPane);
        PersonalController personalController = fxmlLoader.getController();
        personalController.setAdmin(admin);
    }

    public void logout() throws Exception {
        //关闭主界面
        Stage mainStage = (Stage) mainContainer.getScene().getWindow();
        mainStage.close();
        //弹出登录界面
        Stage loginStage = new Stage();
        loginStage.setTitle("Admin Login");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        //loginStage.setMaximized(true);
        //loginStage.getIcons().add(new Image("/img/logo_4.png"));
        loginStage.setScene(scene);
        loginStage.show();
    	loginStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				System.exit(0);
			}
    	});
    }
}
