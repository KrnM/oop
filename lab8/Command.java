package ua.lpnuai.oop.boksho08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class Command {
	public static boolean exit = false;
	public static String text;
	private static ArrayList<String> longest;
	private static ArrayList<String> shortest;

	private Command() {

	}

	public static void doActionByCommand(int command) throws IOException {
		switch (command) {
		case 1:
			System.out.println("1. input");
			System.out.println("Введіть текст латинкою:");
			StringBuilder stringBuilder = new StringBuilder();

			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			while ((text = buf.readLine()) != null) {
				if (text.compareTo("end") == 0) {
					break;
				}
				stringBuilder.append(text);
			}
			text = stringBuilder.toString();
			if (Options.debugParam == true)
				System.out.println("~dbg.Створено буфер.\n    Зчитано текст.");
			break;
		case 2:
			System.out.println("2. data");
			System.out.println(text);
			if (Options.debugParam == true)
				System.out.println("~dbg.Виконано операцію виведення на екран.");
			break;
		case 3:
			System.out.println("3. calculate");
			assert text == null;
			ArrayList<String> sentences = (ArrayList<String>) Text.extractAllSentences(text);
			longest = (ArrayList<String>) Text.findLongestWordsInLines(sentences);
			shortest = (ArrayList<String>) Text.findShortestWordsInLines(sentences);

			break;
		case 4:
			System.out.println("4. result");
			if (Options.debugParam == true)
				System.out.println("~dbg.Буде виведено усі результати обчислень.");
			for (int i = 0; i < longest.size(); i++) {
				System.out.format("%d\t%s\t%s\n", i, shortest.get(i), longest.get(i));
			}
			break;
		case 5:
			System.out.println("5. exit");
			if (Options.debugParam == true)
				System.out.println("~dbg.Вихід з програми.");
			exit = true;
			break;
		default:
			System.out.println("Некоректне введення коду команди!");
			break;
		}

	}
}