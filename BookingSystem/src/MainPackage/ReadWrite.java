import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {

	public void Write(String data, String location) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(location, true));

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
