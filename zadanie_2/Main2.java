package zadanie_2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		System.out.println("Witaj w grze \"LOTTO\"");
		System.out.print("Podaj 6 liczb z zakresu 1 - 49: ");

		int[] userTab = readNumbers();
		int[] computerTab = generateNumbers();
		System.out.println("Twoje cyfry to - " + Arrays.toString(userTab));
		System.out.println("Wylosowane cyfry to - " + Arrays.toString(computerTab));
		checkResult(userTab, computerTab);
	}

	static int[] readNumbers() {
		int[] result = new int[6];
		int counter = 0;
		int number;
		Scanner scan = new Scanner(System.in);

		while (counter < 6) {
			try {
				number = scan.nextInt();
				if (number < 1 || number > 49) {
					System.out.println("Musisz podać liczbę z zakresu 1 - 49");
				} else if (contains(result, number)) {
					System.out.println("Już podałeś tą liczbę");
				} else {
					result[counter] = number;
					counter++;
				}
				System.out.println("Podaj kolejną liczbę: ");
			} catch (InputMismatchException e) {
				System.out.println("This is not a number");
				scan.nextLine();
			}
		}
		Arrays.sort(result);
		scan.close();
		return result;
	}

	static int[] generateNumbers() {
		int[] result = new int[6];
		int counter = 0;
		int num = 0;
		Random random = new Random();
		while (counter < 6) {
			num = random.nextInt(49) + 1; // z zakresu od 0 do 49 + 1 aby pozbyć się 0
			if (!contains(result, num)) {
				result[counter] = num;
				counter++;
			}
		}
		Arrays.sort(result);
		return result;
	}

	static void checkResult(int[] numbers, int[] generated) {
		int result = 0;
		for (int el : numbers) {
			if (contains(generated, el)) {
				result++;
			}
		}

		switch (result) {
		case 3:
			System.out.println("Trafiłeś 3!");
			break;
		case 4:
			System.out.println("Trafiłeś 3!");
			break;
		case 5:
			System.out.println("Trafiłeś 3!");
			break;
		case 6:
			System.out.println("Trafiłeś 3!");
			break;
		default:
			System.out.println("Nic nie wygrałeś");
		}

	}

	static boolean contains(int[] tab, int elem) {
		for (int el : tab) {
			if (el == elem) {
				return true;
			}
		}
		return false;
	}
}
