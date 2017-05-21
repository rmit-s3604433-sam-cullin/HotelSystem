package MainPackage.Owner;

import java.io.File;
import java.io.IOException;

import MainPackage.BookingSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class SettingsController {

	@FXML
	TextField oldbusinessname;
	@FXML
	TextField newbusinessname;
	@FXML
	ImageView uploadimage;
	@FXML
	Label invalidbname1;
	@FXML
	Label invalidbname2;
	@FXML
	Label uploadlabel;
	
	private String imageFile;
	
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
        }
	}
	@FXML
	public void onUpdateBusinessName() throws IOException{
	
		String oldbname = oldbusinessname.getText();
		String newbname = newbusinessname.getText();
		if(oldbname.equals("")){
			invalidbname1.setVisible(true);
		}
		else{
			invalidbname1.setVisible(false);
		}
		if(newbname.equals("")){
			invalidbname2.setVisible(true);
		}
		else{
			invalidbname2.setVisible(false);
		}
		if(!oldbname.equals("") && !newbname.equals("")){
			OwnerMenuController nc = new OwnerMenuController();
			nc.updatename();
			/*nc.businessname.setVisible(false);*/
			/*BookingSystem.showOwnerMenu();*/
		}
	}
}
