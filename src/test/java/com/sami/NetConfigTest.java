package com.sami;

import static org.junit.Assert.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;

public class NetConfigTest extends Application implements Initializable
{
    
    public Parent rootNode;
    @FXML private ListView<String> lstFiles ;
    @FXML private Label lblGood; 
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @Override
    public void init() throws Exception
    {
        super.init();
        Font.loadFont(this.getClass().getResource("/others/digital7.ttf").toExternalForm(), 10);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
        lstFiles.setItems( FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App")
            );
        
        Font f = Font.loadFont(this.getClass().getResource("/others/UbuntuMono-R.ttf").toExternalForm(), 20);
        lblGood.setText( "Hello" );
        lblGood.setFont( f);
        
        //lstFiles.setCellFactory( value );
        
    }
    
    @Test
    public void test()
    {
        launch( "" );
        System.out.println("fff");

       System.out.println("fff");
       assertEquals( 1, 1 );
    }
    
    public void btnAdd_Click(){
        lstFiles.setItems( FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App")
            );
        //Font f = Font.loadFont(this.getClass().getResource("/others/UbuntuMono-R.ttf").toExternalForm(), 20);
        Font f = Font.loadFont(this.getClass().getResource("/others/digital7.ttf").toExternalForm(), 24);
        lblGood.setText( "Hello" );
        lblGood.setFont( f);
        //lstFiles.
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        final String fxmlFile = "/fxml/NetConfigGUI.fxml";
        rootNode = (Parent) FXMLLoader.load(getClass().getResource(fxmlFile ));

//        Font.loadFont(this.getClass().getResource("/others/digital7.ttf").toExternalForm(), 10);
//        Font.loadFont(this.getClass().getResource("/others/UbuntuMono-R.ttf").toExternalForm(), 10);

        
        Scene scene = new Scene(rootNode );
        //File f = new File("filecss.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("/styles/styles.css");        

        stage.setScene(scene);

        stage.setTitle("Hello JavaFX and Maven");
        stage.show();

//        lstFiles.setItems( FXCollections.observableArrayList (
//                "Single", "Double", "Suite", "Family App")
//            );

    }


}
