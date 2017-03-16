package MainPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {
	
	private String address;
	
	public ReadWrite(String address){
		this.address = address;
	}

	public void Write(String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(this.address, true));

			writer.write(data);
			writer.newLine();
			writer.flush();
		} 
		catch (IOException e) {
				e.printStackTrace();
		} 
		finally {
			if(writer != null) try {
				writer.close();
			} 
			catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
