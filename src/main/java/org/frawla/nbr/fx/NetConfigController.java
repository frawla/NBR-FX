package org.frawla.nbr.fx;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.aerofx.AeroFX;
import org.frawla.nbr.core.common.Util;
import org.frawla.nbr.core.controller.ERCController;
import org.frawla.nbr.core.exporting.SheetExporter;

import com.aquafx_project.AquaFx;
import com.guigarage.flatterfx.FlatterFX;
import com.guigarage.flatterfx.FlatterInputType;

public class NetConfigController implements Initializable 
{
    @FXML private ListView<String> lstFiles ;
    @FXML private Button btnRun;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        FilesListViewFactory.MakeListViewSupportFileIcons( lstFiles );

        Font f = Font.loadFont(this.getClass().getResource("/org.frawla.nbr.fx.others/UbuntuMono-R.ttf").toExternalForm(), 20);
        btnRun.setFont(f); 
    }
    
    public void Flatter(){
        FlatterFX.style( FlatterInputType.TOUCH );
        FlatterFX.style();
        //AeroFX.styleAllAsGroupBox(  MainApp.rootNode);
    }

    public void Win7(){
        AeroFX.style();
        //AeroFX.styleAllAsGroupBox(  MainApp.rootNode);
    }
    public void MacOS(){
        AquaFx.style();        
    }

    public void makelist(){
        System.out.println("OK");
    }
    

    public void RunExport() throws IOException 
    {

        if(lstFiles.getItems().size()==0)
            return;
        
        List<String> mylist = lstFiles.getItems();
        
        ERCController erc = new ERCController(mylist);
        erc.export(new SheetExporter());
        System.out.println("Good Byi !!!");
    }
    
    public void btnAdd_Click()  
    {
        FileChooser fc = new FileChooser();
        
        fc.setTitle("Open Resource File");
        fc.getExtensionFilters().addAll(
                new ExtensionFilter("Text & Archives", "*.txt", "*.zip", "*.gz", "*.jar", "*.war", "*.tar"),
                new ExtensionFilter("Text Only", "*.txt"),
                new ExtensionFilter("Archive Only", "*.zip", "*.gz", "*.jar", "*.war", "*.tar"),
                new ExtensionFilter("All Files", "*.*"));
        fc.setTitle("Select the Network Backup File(s)");
        fc.setInitialDirectory(new File("."));
        List<File> selectedFile = fc.showOpenMultipleDialog(null);

        if (selectedFile == null) {
            return;
        }

        ObservableList<String> items = lstFiles.getItems() ;
        for (File file : selectedFile) {
            items.add( file.getAbsolutePath() ) ;
        }
        lstFiles.setItems(items);
    }
    
    public void btnRemove_Click()
    {
        final int selectedIdx = lstFiles.getSelectionModel().getSelectedIndex();

        if (selectedIdx != -1) {
            final int newSelectedIdx =
                (selectedIdx == lstFiles.getItems().size() - 1)
                   ? selectedIdx - 1
                   : selectedIdx;
            
            lstFiles.getItems().remove(selectedIdx);
            lstFiles.getSelectionModel().select(newSelectedIdx);
        }
    }
    
    public void btnAbout_Click()
    {
        
        JOptionPane.showMessageDialog(null, 
                "<html><code>" + 
                "<b>Version :</b> 1.1 <br>" +
                "<b>License:</b> Freeware <br>" +
                "<br><br><br><b>All copy rights are recieved (c) 2014.</b><br><br>" +
                "<b>Programmed By:</b> Eng. Sami A. Alfattani <br>" +
                "<b>Contact:</b> <a href='mailto:Sami_Alfattani@hotmail.com'>Sami_alfattani@hotmail.com<a> <br>" +
                "<b>Mobile:</b> +966-5-645-99127 <br>" +
                "</code></html>", "About Assembly Simulator",  JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Toolkit.getDefaultToolkit().getImage( Util.getMainResourcesPath("/images/index.jpg")) )
         );        
    }
    
    
    public void btnExit_Click(){
        
        System.exit( 0 );
        
    }
    
}//end class

