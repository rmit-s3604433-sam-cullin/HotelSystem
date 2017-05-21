package MainPackage.Owner;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import MainPackage.BookingSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class SettingsController {

	
	@FXML
	TextField newbusinessname;
	@FXML
	ImageView uploadimage;
	@FXML
	Label uploadlabel;
	
	@FXML
	Label invalidbname2;
	
	@FXML
	Label currentName;
	
	private String imageFile;
	
	@FXML
	private void initialize() {
		currentName.setText(BookingSystem.companyname);
	}
	
	@FXML
	public void onUploadImage() throws IOException {
		FileChooser filechooser = new FileChooser();
		//Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        filechooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
          
        //Show open file dialog
        File file = filechooser.showOpenDialog(null);
        if(file != null){
        	imageFile = file.toURI().toString();
        	Image image = new Image(imageFile);
        	uploadimage.setImage(image);
        	uploadlabel.setVisible(false);
        	BookingSystem.companylogo = image;
        	OwnerMenuController.connector1.setImage(image);
        }
	}
	@FXML
	public void onUpdateBusinessName() throws IOException{
		if(this.newbusinessname.getText().equals("")){
			
		}else{
			Connection con = null;
			
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				
				con.createStatement().execute("UPDATE owner SET businessname ='"+this.newbusinessname.getText()+"' Where ownid = '"+BookingSystem.companyLogin+"'");
				con.close();
				BookingSystem.companyname = this.newbusinessname.getText();
				OwnerMenuController.connector.setText(this.newbusinessname.getText());
				this.currentName.setText(this.newbusinessname.getText());
				BookingSystem.log.info("Updated companyname"+this.newbusinessname.getText());
			} catch (SQLException e) {
				BookingSystem.log.error(e.toString());
				e.printStackTrace();
			}
		}
		
	}
	
	
}
