package ua.lpnuai.oop.boksho13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import ua.khpi.oop.shiyka09.LinkedList;
import ua.khpi.oop.shiyska11.Composition;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		final long timeout = 100;
		final String PATH = "D:\\pro\\java\\nedashkivskyi-denys\\src\\ua\\khpi\\oop\\nedashkivskyi13\\data.txt";
		LinkedList<Composition> list = new LinkedList<>();
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

		ThreadOne first = new ThreadOne(list);
		ThreadTwo second = new ThreadTwo(list);
		ThreadThree third = new ThreadThree(list);

		first.start();
		try {
			Thread.sleep(timeout);
			if (!ThreadOne.interrupted()) {
				first.interrupt();
			}
		} catch (InterruptedException e) {

		}

		second.start();
		try {
			Thread.sleep(timeout);
			if (!ThreadTwo.interrupted()) {
				second.interrupt();
			}
		} catch (InterruptedException e) {

		}

		third.start();
		try {
			Thread.sleep(timeout);
			if (!ThreadThree.interrupted()) {
				third.interrupt();
			}
		} catch (InterruptedException e) {

		}
	}

}