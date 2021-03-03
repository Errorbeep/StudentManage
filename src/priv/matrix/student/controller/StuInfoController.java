package priv.matrix.student.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import priv.matrix.student.entity.Student;
import priv.matrix.student.service.StuService;
import priv.matrix.student.utils.ServiceFactory;

public class StuInfoController implements Initializable{

    @FXML
    private TableView<Student> stuTable;

	@FXML
	private TableColumn<Student, String> idColumn;

	@FXML
	private TableColumn<Student, String> nameColumn;

	@FXML
	private TableColumn<Student, String> genderColumn;

	@FXML
	private TableColumn<Student, String> addressColumn;

	@FXML
	private TableColumn<Student, String> mobileColumn;

	@FXML
	private TableColumn<Student, String> dormColumn;

	@FXML
	private TableColumn<Student, Double> creditColumn;

    @FXML
    private TextField keywordsField;
    
    private ObservableList<Student> stuData = FXCollections.observableArrayList();
    
    private List<Student> stuList = new ArrayList<>();
    
    private StuService stuService = ServiceFactory.getStudentServiceInstance();
    
    private Student selectedStu = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initTable();
	}
	
    private void showStuData(List<Student> stuList) {
    	if(stuData.size() != 0)//!!!???
    	{
    		stuData.clear();
    	}
        stuData.addAll(stuList);
        stuTable.setItems(stuData);
    }

	private void initTable()
	{
        //水平方向不显示滚动条，表格的列宽会均匀分布
        stuTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        stuList = stuService.selectAllStu();
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));  //<--------------------
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("sname"));  //<--------------------
        genderColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));  //<--------------------
        addressColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));  //<--------------------
        mobileColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("mobile"));  //<--------------------
        dormColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("dorm"));  //<--------------------
        creditColumn.setCellValueFactory(new PropertyValueFactory<Student, Double>("credit"));  //<--------------------

        showStuData(stuList);
		
        stuTable.setRowFactory(tv ->
        {
            TableRow<Student> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
//                    String id = row.getItem().getId();
//                    String sname = row.getItem().getSname();
//                    String gender = row.getItem().getGender();
//                    String address = row.getItem().getAddress();
//                    String dorm = row.getItem().getDorm();
//                    double credit = row.getItem().getCredit();
                    
                	selectedStu = row.getItem();
                	System.out.println(selectedStu.getSname());
                }
            });
            return row;
        });
	}

    public void search() {
        stuTable.getItems().removeAll(stuData);
        //获得输入的查询关键字
        String keywords = keywordsField.getText().trim();
        stuList = stuService.selectStuLike(keywords);
        showStuData(stuList);
    }
    
    public void alterStuStage()
    {
    	
        Stage alterStuStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alterStu.fxml"));
        AnchorPane root = null;
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        AlterStuController alterStuController = fxmlLoader.getController();
        System.out.println(selectedStu.getSname());
        System.out.println("-------->---->" + selectedStu.getMobile());
        alterStuController.setSelected(selectedStu);
        alterStuStage.setTitle("修改学生信息界面");
        //界面大小不可变
        alterStuStage.setResizable(false);
        alterStuStage.setScene(scene);
        alterStuStage.show();
    }
    
    public void addStuStage()
    {
        Stage addStuStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/addStu.fxml"));
        AnchorPane root = null;
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        addStuStage.setTitle("新增图书界面");
        //界面大小不可变
        addStuStage.setResizable(false);
        addStuStage.setScene(scene);
        addStuStage.show();
    }
    
    public void deleteStu()
    {
    	
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("确认对话框");
    	alert.setHeaderText("姓名：" + selectedStu.getSname() + "\n学号：" + selectedStu.getId());
    	alert.setContentText("确定要删除这行记录吗?");
    	Optional<ButtonType> result = alert.showAndWait();
    	//点击了确认按钮，执行删除操作，同时移除一行模型数据
    	if (result.get() == ButtonType.OK) {
    		stuData.remove(selectedStu);
    		stuService.deleteStuById(selectedStu.getId());
    	}
    }
    
    public void refresh()
    {
    	stuList = stuService.selectAllStu();
    	showStuData(stuList);
    }
}
