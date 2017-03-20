package mainpackage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWrite {
	
	public void saveToFile(String cusString) {
		try {
			PrintWriter outputStream = new PrintWriter(BookingSystem.customertxt);
			outputStream.write(cusString.toString() + ":");
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*public ReadWrite(){
		
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
	}*/
	
}
