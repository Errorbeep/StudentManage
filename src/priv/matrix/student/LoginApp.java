package priv.matrix.student;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				System.exit(0);
			}
    	});
    	
        primaryStage.setTitle("Admin Login");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        //primaryStage.getIcons().add(new Image("/img/logo_4.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
