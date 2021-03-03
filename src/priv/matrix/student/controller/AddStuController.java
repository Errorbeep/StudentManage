package priv.matrix.student.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import priv.matrix.student.entity.Student;
import priv.matrix.student.service.StuService;
import priv.matrix.student.utils.ServiceFactory;

public class AddStuController implements Initializable{

	@FXML
	private TextField idField;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField genderField;
	
	@FXML
	private TextField addressField;
	
	@FXML
	private TextField mobileField;
	
	@FXML
	private TextField dormField;
	
	@FXML
	private TextField creditField;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	
	
	public void addStu()
	{
		String id = idField.getText();
		String name = nameField.getText();
		String gender = genderField.getText();
		String address = addressField.getText();
		String mobile = mobileField.getText();
		String dorm = dormField.getText();
		double credit = Double.valueOf(creditField.getText());
        if(id.isEmpty()  || name.isEmpty())//wrong: name == null 
        {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
        	alert.setTitle("提示信息");
        	alert.setHeaderText("输入信息不完整，新增学生信息失败!");
        	alert.showAndWait();
        	Stage stage = (Stage) nameField.getScene().getWindow();
        	stage.close();
        	return;
        	
        }
		Student stu = new Student(id, name, gender, address, mobile, dorm, credit);
		StuService stuService = ServiceFactory.getStudentServiceInstance();
		stuService.insertStu(stu);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("成功添加学生信息!");
        alert.showAndWait();
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
	}
	

}
