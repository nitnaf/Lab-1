package Labs;

import java.util.Scanner;

import org.apache.poi.ss.formula.functions.*;

public class Lab1 {

	public static void main(String[] args) {
		
		// New Instance of Scanner Class
		Scanner keyboard = new Scanner(System.in);
		
		// Years Working
		System.out.println("How many years do you plan on working?");
		double yrsWorking = keyboard.nextDouble();

        // Interest Rate: Working
		System.out.println("What is the interest rate on the money you save? Eg. If your rate is 10%, enter '10'.");
		double workIR = (keyboard.nextDouble() / 100);
		while ((workIR < 0) || (workIR > .2)) {
			System.out.println("Please enter a value between 0 and 20.");
			workIR = (keyboard.nextDouble() / 100);
		}
		
		// Years Retired
		System.out.println("How many years do you plan on drawing from your savings?");
		double yrsRetired = keyboard.nextDouble();

		// Interest Rate: Retired
		System.out.println("What is the annual interest rate on your savings during retirement? Eg. If your rate is 1%, enter '1'.");
		double retireIR = (keyboard.nextDouble() / 100);
		while ((retireIR < 0) || (retireIR > .03)) {
			System.out.println("Please enter a value between 0 and 3.");
			retireIR = (keyboard.nextDouble() / 100);
		}

		// Monthly Income
		System.out.println("What is your desired monthly income during retirement?");
		double monthlyIncome = keyboard.nextDouble();

		// Monthly SSI
		System.out.println("What is your expected monthly SSI income during retirement?");
		double monthlySSI = keyboard.nextDouble();

		// Calculating total you need to save - SSI payments
		double totalNeedSaved = (-1 *(FinanceLib.pv((retireIR / 12), (yrsRetired * 12), (monthlyIncome - monthlySSI), 0, false)));
		
		// Calculating amount to save each month
		double answer = (-1 * (FinanceLib.pmt((workIR / 12), (yrsWorking * 12), 0, totalNeedSaved, false)));
		System.out.printf("Amount to save each month: $%2.2f", answer);
		
	
	}

}
