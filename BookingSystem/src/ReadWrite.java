import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {

	public Employee AddEmployee(Employee employee) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:/Users/Nic/git/HotelSystem/src/employee.txt", true));

			writer.write(employee.getname() + ",");
			writer.write(age + ",");
			writer.write(contact + ",");
			writer.write(address + ",");
			writer.write(econtact);
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
