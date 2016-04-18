package es.uniovi.electoral.main;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.uniovi.electoral.model.*;

public class Main {

	private static Scanner scnr = null;
	private static PrintWriter prnt = null;
	
	private static List<Option> options = new ArrayList<Option>();
	private static List<PollingStation> stations = new ArrayList<PollingStation>();
	private static String type = "";
	static Configuration conf;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		run(new Scanner(System.in), new PrintWriter(System.out));
	}

	public static void run(Scanner scanner, PrintWriter out) {
		scnr = scanner;
		prnt = out;
		out.println("Welcome to the Electoral Process Management\n\n"
				+ "Please select an electoral option:" + "\n\t1- Referendum"
				+ "\n\t2- Election");
		Integer option = null;

		while (option == null) {
			try {
				option = Integer
						.parseInt(process("Introduce an option number"));
			} catch (Exception e) {
				out.println("Invalid data, please try again");
				option = null;
			}
		}
		try {
			options(option);
			stations();
			configuration();
		} catch (Exception e) {
			out.println("Invalid data or format, exiting manager");
		} finally {
			out
					.println("Thank you for using our electoral system manager");
		}
	}

	private static void configuration() {
		String name = process("Name your elections");
		String date = process("Opening date of elections (dd/mm/yyyy):");
		String time = process("Time of opening (hh:mm):");
		String[] temp = date.split("/");
		String[] temp2 = time.split(":");
		Timestamp start = new Timestamp(Integer.parseInt(temp[2]) - 1990,
				Integer.parseInt(temp[1]), Integer.parseInt(temp[0]),
				Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), 0, 0);
		prnt.println(start);
		date = process("Closing date of elections (dd/mm/yyyy):");
		time = process("Time of closing (hh:mm):");
		temp = date.split("/");
		temp2 = time.split(":");
		Timestamp end = new Timestamp(Integer.parseInt(temp[2]),
				Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[0]),
				Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), 0, 0);

		String comments = process("Additional comments:");

		conf = new Configuration(name, start, end, type, comments);
	}

	private static void stations() {
		prnt
				.println("Please fill out the information of the polling stations");
		boolean more = true;
		while (more) {
			stations.add(new PollingStation(Long.parseLong(process("Code:")),
					process("Province:"), process("City:"),
					process("District:"), process("Country:")));
			if (process("Exit polling station adding?(Y/N)").equalsIgnoreCase("y"))
				more = false;
		}
	}

	private static String process(String text) {
		return process(text, scnr, prnt);
	}

	public static String process(String text, Scanner input, PrintWriter out) {
		out.println(text);
		String temp = input.next();

		assert temp.equalsIgnoreCase("Q");
		return temp;
	}

	private static void options(int option) throws Exception {
		switch (option) {
		case 1:
			options.add(new Option(1, "Agree", ""));
			options.add(new Option(2, "Disagree", ""));
			type = "Referendum";
			break;
		case 2:
			while (process("Add a new voting option? (Y/N)").equalsIgnoreCase("y")) {
				int i = 1;
				options.add(new Option(i, process("Name:"),
						process("Comments:")));
				i++;
			}
			type = "Elections";
			break;
		default:
			throw new Exception();
		}
		prnt.println("Voting options completed");
	}
}
