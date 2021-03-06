package ua.lpnuai.oop.boksho15;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import ua.khpi.oop.shiyka10.Composition;
import ua.khpi.oop.shiyka14.ListSaver;
import ua.khpi.oop.shiyka14.RatingComparator;

public class ListAction {

	private static final String PATH = "D:\\pro\\java\\nedashkivskyi-denys\\src\\ua\\khpi\\oop\\nedashkivskyi13\\data.txt";
	private static LinkedList<Composition> list = new LinkedList<>();

	public static void init() throws FileNotFoundException {
		Random random = new Random();

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
	}

	public static void show() {
		for (Composition elem : list) {
			System.out.println(elem);
		}
	}

	public static void save() throws FileNotFoundException, IOException {
		ListSaver.serialize(list);
	}

	public static void extract() throws FileNotFoundException, ClassNotFoundException, IOException {
		ListSaver.deserialize();
	}

	public static void sort() {
		Collections.sort(list, new RatingComparator());
		System.out.println("List was sorted!");
	}
}