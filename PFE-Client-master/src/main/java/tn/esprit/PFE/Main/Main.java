package tn.esprit.PFE.Main;



import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.naming.NamingException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try{
            
        java.net.URL url = new File("src/main/java/tn/esprit/pfe/gui/MenuDepSupervisor.fxml").toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/dark-theme.css");
    	//scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
        //stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        } catch(Throwable e)
        {
            System.out.println("error " + e.getMessage());
            System.out.println("cause " + e.getCause());
            System.out.println("local " + e.getLocalizedMessage());
            System.out.println("stack trace " + e.getStackTrace());
        }
    }

    
    public static void main(String[] args) throws NamingException, InterruptedException {
        launch(args);
    }

}
