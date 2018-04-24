package ua.lpnuai.oop.boksho12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import ua.khpi.oop.kvochka09.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {

		final String PATH = "D:\\pro\\java\\bashkatov\\src\\ua\\khpi\\oop\\bashkatov11\\data.txt";

		boolean autoFlag = false;
		if (args.length != 0) {
			if (args[0].equals("-auto")) {
				autoFlag = true;
			}
		}

		LinkedList<Composition> list = new LinkedList<>();

		if (autoFlag) {
			Scanner in = new Scanner(new File(PATH));
			while (in.hasNext()) {
				Composition temp = new Composition();
				temp.setAuthor(in.nextLine());
				temp.setName(in.nextLine());
				temp.setGenre(in.nextLine());
				temp.setDuration(in.nextLine());
				temp.setDataFormat(in.nextLine());
				list.add(temp);
			}
			in.close();
		} else {
			for (int i = 0; i < 3; i++) {
				Composition temp = new Composition();
				temp.init(temp);
				list.add(temp);
			}
		}

		for (Composition item : list) {
			System.out.println(item);
		}
	}
}