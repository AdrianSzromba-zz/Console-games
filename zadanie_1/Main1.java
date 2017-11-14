package zadanie_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		Random random = new Random();
		int randomNumber = random.nextInt(101); // do zmiennej int przypisze losowo wybraną liczbę 0 -1
		int answer = -1;

		System.out.println("Witaj w grze \"ZGADNIJ LICZBE 1-100\"");

		System.out.print("Podaj liczbę: ");
		Scanner scan = new Scanner(System.in);

		while (answer != randomNumber) {
			System.out.print("Podaj liczbę: ");
			try {
				answer = scan.nextInt(); // jeśli nie int, przeniesie do obługi wyjątku
				if (answer > randomNumber) {
					System.out.println("Za dużo");
				} else if (answer < randomNumber) {
					System.out.println("Za mało");
				}
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba!");
				scan.nextLine(); //w tym wypadku, pozwala powtórzyć proces przypisania
			}
		}
		System.out.println("Brawo, zgadłeś!");
		scan.close();
	}
}
