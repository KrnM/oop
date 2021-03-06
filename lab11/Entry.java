package ua.lpnuai.oop.boksho11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;


public class Entry {

	/**
	 * Main method.
	 * Contains implementation of two modes 
	 * of creating the library of books.
	 * 
	 * @param args - parameters of command line
	 * @throws IOException - if there are some collisions in input/output
	 * @throws ParseException - if parsed object cannot be resolved
	 */
	public static void main(String[] args) throws IOException, ParseException {
		
		/* Library declaration. */
		SourceLibrary lib = new SourceLibrary();
		
			for(int i = 0; i < args.length; i++) {	
			
				switch(args[i]) {
				
					/* Auto mode of adding, sorting, displaying books. */
					case "-auto":
						lib.add(new Book("ÂÂÂ", "ððð", "æææ", "24-04-2016"));
						lib.add(new Book("ÀÀÀ", "ïïï", "ççç", "14-09-2017"));
						lib.add(new Book("ÄÄÄ", "ñññ", "ééé", "08-10-2015"));
						lib.add(new Book("ÃÃÃ", "óóó", "èèè", "08-10-2015"));
						
						System.out.println("Four elements are being added...");
						
						lib.display();

						System.out.println("Elements are being sorted by priority...");
						
						lib.sort(new FilterByTitle(new FilterByPublisher(null)));
						
						lib.display();
					
						break;
						
					/* Manual mode with menu. */
					case "-manual":
						Scanner scanner = new Scanner(System.in);
						
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						
						System.out.println("Switched to manual control.");
						System.out.println("1. Add element");
						System.out.println("2. Display elements");
						System.out.println("3. Sort elements by priority");
						System.out.println("4. Exit");

						int key = 0;
						
						final int EXIT_CASE = 5;
						
						while (key != EXIT_CASE) {
							
							key = scanner.nextInt();
						
							switch (key) {
								 
							case 1:
								
								Book newBook = new Book();
								
								System.out.print("Title : ");  
								newBook.setTitle(reader.readLine());
								
								System.out.print("Publisher : ");  
								newBook.setPublisher(reader.readLine());
								
								System.out.print("Genre : ");  
								newBook.setGenre(reader.readLine());
								
								System.out.print("Date : ");  
								newBook.setPublishingDate(reader.readLine());
								
								lib.add(newBook);
								break;
								
							case 2:
								
								lib.display();
								break;
								
							case 3:
								System.out.println("Elements are being sorted...");
								
								lib.sort(new FilterByTitle(new FilterByPublisher(
										new FilterByGenre(new FilterByDate(null)))));
								break;
								
							case 4:
								break;
								
							default : break;
							
						}
					}
						
				scanner.close();
				reader.close();
					
				break;
					
				default : break;
					
			}	
		}	
	}
}