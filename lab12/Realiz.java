package ua.lpnuai.oop.boksho12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;
import ua.khpi.oop.ponomarenko09.Container;
import ua.khpi.oop.ponomarenko10.Book;

/**
 * Entry class.
 * Contains entry point of a program.
 * Class is created for general purpose.
 * 
 */
public class Main {

	/**
	 * Main method.
	 * Contains initializations of Book class objects.
	 * Books are processed by the search of author's initials,
	 * by the search of repeated isbn code combinations are also included.
	 * 
	 * @param args 
	 * command prompt arguments
	 * @throws ParseException 
	 * signals if there are some collisions with parsing
	 * @throws IOException
	 * signals if there are some collisions with input/output
	 */
	public static void main(String[] args) throws ParseException, IOException {
		
		for (int it = 0; it < args.length; it++) {
			
			switch(args[it]) {
			
			case "-auto":
				
				Container<Book> list1 = new Container<>();
				
				list1.add(new Book("Test1", "Johnson A. A.", "Test1", "Test1", 20, 2, 2015, "44929292341"));
				
				System.out.println(BookDataParser.searchAuthor(list1, "A"));
				System.out.println(BookDataParser.searchIsbn(list1, 2));
				
				break;
				
			case "-manual":
				
				Container<Book> list = new Container<>();
				
				System.out.println("How many books would you like to add ? - ");
				
				Scanner scan = new Scanner(System.in);
				byte numOfBooks = (byte) scan.nextInt();
				
				Book bookToAdd = new Book();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
				for (int i = 0; i < numOfBooks; i++) {
					
					System.out.println("Title : ");
					bookToAdd.setTitle(reader.readLine());
					
					System.out.print("Author : "); 
					bookToAdd.setAuthor(reader.readLine());
					
					System.out.print("ISBN : ");
					bookToAdd.setIsbn(reader.readLine());
					
					System.out.print("Publishing date : ");
					
					int day = scan.nextInt();
					int month = scan.nextInt();
					int year = scan.nextInt();
					
					bookToAdd.setPublishingDate(day, month, year);
					
					list.add(bookToAdd);
				}
				
				System.out.println(BookDataParser.searchAuthor(list, reader.readLine()));
				System.out.println(BookDataParser.searchIsbn(list, scan.nextInt()));
				
				scan.close();
				reader.close();
				break;
					
			}
		}
	}
}