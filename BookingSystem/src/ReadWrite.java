import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {

	public Employee AddEmployee(Employee employee) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:/Users/Nic/git/HotelSystem/src/employee.txt", true));

			writer.write(employee.getID() + ",");
			writer.write(employee.getName() + ",");
			writer.write(employee.getContact() + ",");
			writer.write(employee.getPosition() + ",");
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
	public Customer WriteCustomer(Customer customer) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:/Users/Nic/git/HotelSystem5/BookingSystem/src/customerinfo.txt", true));
			writer.write(name + ",");
			writer.write(username + ",");
			writer.write(password + ",");
			writer.write(address + ",");
			writer.write(contact);
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
