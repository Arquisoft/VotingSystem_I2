package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.junit.Test;

import es.uniovi.electoral.Main;


public class ElectoralTest {

	@Test
	public void testWrongStationCode() {
		String input = "1";
		StringWriter output = new StringWriter();
		
		Main.run(new Scanner(input), new PrintWriter(output));
		assertTrue(output.toString().contains("polling stations"));
		assertFalse(output.toString(). contains("configuration"));
	}

}
