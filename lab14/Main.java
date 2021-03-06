package ua.lpnuai.oop.boksho14;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import ua.khpi.oop.shiyka11.Composition;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Random random = new Random();
		LinkedList<Composition> list = new LinkedList<>();

		final String PATH = "D:\\pro\\java\\kvochka-mykyta\\src\\ua\\khpi\\oop\\kvochka13\\data.txt";
		boolean autoFlag = false;
		if (args.length != 0) {
			if (args[0].equals("-auto")) {
				autoFlag = true;
			}
		}

		if (autoFlag) {
			Scanner in = new Scanner(new File(PATH));
			while (in.hasNext()) {
				Composition temp = new Composition();
				temp.setAuthor(in.nextLine());
				temp.setName(in.nextLine());
				temp.setRating("Rolling Stone", random.nextInt(100));
				temp.setDuration(in.nextLine());
				temp.setDataFormat(in.nextLine());
				list.add(temp);
			}
			in.close();
		} else {
			for (int i = 0; i < 5; i++) {
				Composition temp = new Composition();
				temp.init(temp);
				list.add(temp);
			}
		}

		list.remove();
		Collections.sort(list, new RatingComparator());
		ListSaver.serialize(list);
		LinkedList<Composition> extracted = ListSaver.deserialize();
		for (Composition elem : extracted) {
			System.out.println(elem);
		}
	}
}