package mortage_plan;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadFile {

	// Variable used for checking input
	int startPos = 0;

	// Method for reading file
	public void readingFile() {

		String[] inputArray = new String[4];
		String customerName;
		String totalLoan;
		String interest;
		String year;
		float totalLoanFloat;
		float interestFloat;
		float yearsFloat;

		try {
			File customerFile = new File("prospects.txt");
			Scanner textFromFile = new Scanner(customerFile);
			String dataFromFile;

			// Skip first line in file
			textFromFile.nextLine();

			// Loop for reading each line in file into an array
			while (textFromFile.hasNext()) {

				dataFromFile = textFromFile.nextLine();

				// Checking file for correct data input
				for (int i = 0; i <= 3; i++) {
					inputArray[i] = getNextElement(dataFromFile);

					if (startPos == 0) {
						break;
					}
				}

				// If statement for checking that there is data in the array
				if (inputArray[0] != "") {

					customerName = inputArray[0];
					totalLoan = inputArray[1]; // float
					interest = inputArray[2]; // float
					year = inputArray[3]; // float

				} else {
					break;
				}

				// Converting tring to float
				totalLoanFloat = Float.parseFloat(inputArray[1]);
				interestFloat = Float.parseFloat(inputArray[2]);
				yearsFloat = Float.parseFloat(inputArray[3]);

				// Method call to countMortage class
				Mortage mortage = new Mortage(customerName, interestFloat / 12, totalLoanFloat, yearsFloat * 12);
				mortage.countMortage();

			}
		} catch (FileNotFoundException e) {
			// Handling exception for when file is not found
			System.out.println("File not found.");
		}

	}

	// Method for checking characters in given string
	public String getNextElement(String dataFromFile) {
		int commaPos = dataFromFile.indexOf(',', startPos);
		int citatPos = dataFromFile.indexOf('"', startPos);
		String element;

		while (citatPos < commaPos && citatPos > -1) {
			citatPos = dataFromFile.indexOf('"', citatPos + 1);
			commaPos = dataFromFile.indexOf(',', citatPos + 1);
			citatPos = dataFromFile.indexOf('"', citatPos + 1);
		}

		if (startPos < commaPos) {
			element = dataFromFile.substring(startPos, commaPos);
			startPos = commaPos + 1;
		} else {
			element = dataFromFile.substring(startPos, dataFromFile.length());
			startPos = 0;
		}

		return element;
	}

}
