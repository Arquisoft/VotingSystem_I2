package es.uniovi.PollingStation;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import es.uniovi.PollingStation.model.*;
import es.uniovi.PollingStation.ports.*;
import es.uniovi.db.VerificationException;

public class Main {

	private static Scanner scnr = null;
	private static PrintWriter prnt = null;

	private static Voter voter;
	private static List<Option> options;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		run(new Scanner(System.in), new PrintWriter(System.out));
	}

	public static void run(Scanner scanner, PrintWriter out) {
		scnr = scanner;
		prnt = out;
		try {
			if (verify()) {
				vote();
			}
		} catch (VerificationException e) {
			print(e.getMessage());
		}
	}

	private static void vote() {
		options = OptionsP.getOptions();
		if (options == null) {
			print("There has been an issue reading options from the database.");
		} else {
			print("Please select an option: ");
			int i = 0;
			for (Option opt : options) {
				print("\t" + i++ + opt.toString());
			}
			int opt = Integer.parseInt(process(""));

			InsertVoteP.insertVote(opt, voter);
		}
	}

	private static boolean verify() throws VerificationException {
		print("Starting verification process");
		String login = process("Login: ");
		String pass = process("Password: ");

		voter = VoterP.getVoter(login, pass);

		return voter == null;
	}

	private static void print(String printString) {
		prnt.println(printString);
		System.out.println(printString);
	}

	private static String process(String text) {
		return process(text, scnr, prnt);
	}

	public static String process(String text, Scanner input, PrintWriter out) {
		print(text);
		String temp = input.nextLine();
		return temp;
	}

}
