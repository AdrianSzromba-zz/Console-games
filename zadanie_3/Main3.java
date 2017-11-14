package zadanie_3;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		int min = 0;
		int max = 1000;
		System.out.println("Pomyśl sobie liczbę od 1-1000, ja odgadnę ją w maksymalnie 10 próbach");
		System.out.println("Możliwe warianty odpowiedzi: \"za mało\", \"za dużo\", \"zgadłeś\"");
		readAnswer(min, max);
	}

	static void readAnswer(int min, int max) {
		String toLittle = "za mało";
		String toMuch = "za dużo";
		String win = "zgadłeś";
		int guess = ((max - min) / 2) + min;
		int counter = 1;

		Scanner scan = new Scanner(System.in);
		String answer = "";

		while (counter <= 10) {
			System.out.println("Zgaduję liczbę, czy jest nią: " + guess + "?");
			answer = scan.nextLine();
			if (answer.equals(toLittle)) {
				if (counter < 10) {
					min = guess;
					counter++;
					guess = ((max - min) / 2) + min;
				} else {
					System.out.println("Nie oszukuj!");
				}
			} else if (answer.equals(toMuch)) {
				if (counter < 10) {
					max = guess;
					counter++;
					guess = ((max - min) / 2) + min;
				} else {
					System.out.println("Nie oszukuj!");
				}
			} else if (answer.equals(win)) {
				System.out.println("Hurra, udało mi się odgadnąć liczbę za: " + counter + " razem");
				scan.close();
				return;
			} else {
				System.out.println("Nie rozumiem twojej odpowiedzi, spróbuj jeszcze raz");
			}
		}
		scan.close();
	}
}
