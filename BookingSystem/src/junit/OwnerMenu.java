package junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import views.Menu;

public class OwnerMenu {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void OwnerMenuTest() throws IOException {
		Menu test = new Menu();
		test.OwnerMenu();
	}

}
