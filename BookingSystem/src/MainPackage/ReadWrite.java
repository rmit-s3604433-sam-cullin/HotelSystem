package MainPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {
	

	
	public ReadWrite(){
		
	}

	public void Write(String data, String address) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(address, true));
			writer.write(data);
			writer.newLine();
			writer.flush();
			writer.close();
		} 
		catch (IOException e) {
				e.printStackTrace();
		} 
	}
	
}
