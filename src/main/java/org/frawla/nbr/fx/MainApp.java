package org.frawla.nbr.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application 
{
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    public static Parent rootNode;
    
    public static void main(String[] args) throws Exception 
    {
        launch(args);
    }
  
    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");
        
        final String fxmlFile = "NetConfigGUI.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        rootNode = (Parent) FXMLLoader.load(getClass().getResource(fxmlFile ));

        log.debug("Showing JFX scene");

        stage.getIcons().add(new Image(MainApp.class.getResourceAsStream( "index.jpg")));

        Scene scene = new Scene(rootNode );
        //File f = new File("filecss.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("styles.css");        

        stage.setScene(scene);
        stage.setTitle("Hello JavaFX and Maven");
        stage.show();
    }

}
