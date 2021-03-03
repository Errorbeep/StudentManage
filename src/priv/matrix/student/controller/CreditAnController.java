package priv.matrix.student.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import priv.matrix.student.service.StuService;
import priv.matrix.student.utils.ServiceFactory;

public class CreditAnController implements Initializable{

	@FXML
	private Label totalField, underField, satisField, avgField, midField, excelField; 

	@FXML
	private StackPane pieChartPane, barChartPane;

	private StuService stuService = ServiceFactory.getStudentServiceInstance();
	
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	int total = stuService.countByCre(0, 100);
    	int under = stuService.countByCre(0, 59);
    	int sati = stuService.countByCre(60, 100);
    	double avg = stuService.getAvgCre();
    	int mid = stuService.countByCre(60, 85);
    	int excel = stuService.countByCre(86, 100);
    	pieChartData.add(new PieChart.Data("不及格", under));
    	pieChartData.add(new PieChart.Data("中等", mid));
    	pieChartData.add(new PieChart.Data("优秀", excel));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("成绩统计饼图");
        pieChartPane.getChildren().add(chart);
        
        totalField.setText(String.valueOf(total));
        underField.setText(String.valueOf(under));
        satisField.setText(String.valueOf(sati));
        avgField.setText(String.valueOf(avg));
        midField.setText(String.valueOf(mid));
        excelField.setText(String.valueOf(excel));
		
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
        bc.setTitle("成绩分段统计柱形图");
        xAxis.setLabel("分数");
        yAxis.setLabel("人数");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("成绩统计数据");
        int zero_six = stuService.countByCre(0, 60);
        int six_seven = stuService.countByCre(60, 70);
        int seven_eight = stuService.countByCre(70, 80);
        int eight_nine = stuService.countByCre(80, 90);
        int nine_hund = stuService.countByCre(90, 100);
        series1.getData().add(new XYChart.Data("0~60", zero_six));
        series1.getData().add(new XYChart.Data("60~70", six_seven));
        series1.getData().add(new XYChart.Data("70~80", seven_eight));
        series1.getData().add(new XYChart.Data("80~90", eight_nine));
        series1.getData().add(new XYChart.Data("90~100", nine_hund));
//        List<Type> typeList = typeService.getAllTypes();
//        for (Type type : typeList) {
//            int count = bookService.countByType(type.getId());
//            series1.getData().add(new XYChart.Data(type.getTypeName(), count));
//        }
        bc.getData().addAll(series1);
        barChartPane.getChildren().add(bc);
	}

}
