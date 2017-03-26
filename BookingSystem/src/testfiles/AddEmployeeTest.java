package testfiles;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class AddEmployeeTest {

	@Test
	public void AddEmployeeTest1() {
		
		String empid = "", name = "", address = "", number = "";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest2() {
		
		String empid = "fjasdkjflkasjfkla", name = "fjasdkjflkasjfkla", address = "fjasdkjflkasjfkla", number = "fjasdkjflkasjfkla";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		            
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		            
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest3() {
		
		String empid = "1234123412412", name = "1234123412412", address = "1234123412412", number = "1234123412412";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		          
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest4() {
		
		String empid = "!@#$%^&*()(*&^%$#@!", name = "!@#$%^&*()(*&^%$#@!", address = "!@#$%^&*()(*&^%$#@!", number = "!@#$%^&*()(*&^%$#@!";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		            
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		            
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest5() {
		
		String empid = "asdfasd123243", name = "asdfasd123243", address = "asdfasd123243", number = "asdfasd123243";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
		
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		         
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();

		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest6() {
		
		String empid = "AJSKFLJ!@#$%^&*", name = "AJSKFLJ!@#$%^&*", address = "AJSKFLJ!@#$%^&*", number = "AJSKFLJ!@#$%^&*";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();

			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		           
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		            
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest7() {
		
		String empid = "sadfvasd!@#$%^$#", name = "sadfvasd!@#$%^$#", address = "sadfvasd!@#$%^$#", number = "sadfvasd!@#$%^$#";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		           
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		           
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
	
	@Test
	public void AddEmployeeTest8() {
		
		String empid = "qwertyuiopasdfghjklzxcvbnmmmmnbvcxzasdfghjkl", 
				name = "qwertyuiopasdfghjklzxcvbnmmmmnbvcxzasdfghjkl", 
				address = "qwertyuiopasdfghjklzxcvbnmmmmnbvcxzasdfghjkl", 
				number = "qwertyuiopasdfghjklzxcvbnmmmmnbvcxzasdfghjkl";
		
		Connection con = null;
		Statement statement = null;
		int add = 0;
		empid.trim();
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			
			/* SQL Statement */
			add = statement.executeUpdate("INSERT INTO employee values('e"+empid+"', '"+name+"', '"+address+"', '"+number+"')");
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			if (statement != null) {
		        try {
		            statement.close();
		            
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		      
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		}
		
		assertFalse(add == 1);
	}
}
