package es.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.junit.Test;

import es.uniovi.PollingStation.Main;

public class PollingTest {

	@Test
	public void testNonValidUser1() {
		String input = "test@notvalid1\npassword";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains(
				"User has already voted"));
	
	}

	@Test
	public void testNonValidUser2() {
		String input = "test@notvalid2\npassword";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains(
				"Your polling station is not available for voting"));	
	}
	
	@Test
	public void testValidUserWrongPassword() {
		String input = "test@valid\nassword";
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains(
				"Invalid login data"));	
	}
	

	@Test
	public void testWrongOption() {
		String input = "test@valid\n" +
				"password\n" +
				"3"; //only 2 options
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("Please select an option"));
		assertTrue(output.toString().contains(
				"Selected option is not available"));
	}

	@Test
	public void testCorrect() {
		String input = "test@valid\n" +
				"password\n" +
				"2"; //only 2 options
		StringWriter output = new StringWriter();

		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("Please select an option"));
		assertTrue(output.toString().contains(
				"Vote has been stored"));
	}
}
