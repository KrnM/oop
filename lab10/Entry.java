package ua.lpnuai.oop.boksho10;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Entry {

	/**
	 * Main method - entry point of a program.
	 * Contains user menu for library control.
	 * 
	 * @param args - command line parameters
	 * @throws IOException - if there is any unresolved input/output
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		/* Holds objects that define the entity of books. */
		LibraryStorage[] books = null;
		
		/* User menu output. */
		System.out.println("---MENU---");
		System.out.println("1. Define quantity of array elements");
		System.out.println("2. Assign array elements");
		System.out.println("3. Save array for a long term");
		System.out.println("4. Extract array");
		System.out.println("5. Exit");
		
		/* Holds key for menu point. */
		String key = new String();
		
		/* Processes user's choices. */
		while (!key.equals("5")) {
			
			key = reader.readLine();
			
			switch (key) {
				
				case "1" :
				
					System.out.print("Enter value :");
					
					/* 
					 * Defines the number
					 * of books to store. 
					 *  */
					books = new LibraryStorage
							[Integer.parseInt(
							reader.readLine())];
					break;
				
				case "2" :
					
					String init = new String();
				
					/* 
					 * The following for-loop construction 
					 * initializes new objects.
					 */
					for (int i = 0; i < books.length; i++) {
					
						books[i] = new LibraryStorage();
						
						System.out.print("Name : ");
						
						init = reader.readLine();
						books[i].setName(init);
					
						System.out.print("Genre : ");
						
						init = reader.readLine();
						books[i].setGenre(init);
					
						System.out.print(
								"Publisher : ");
						
						init = reader.readLine();
						books[i].setPublisher(init);
					}
				
					System.out.println();
					break;
				
				case "3" :
				
					/*
					 * Pattern and Matcher class objects.
					 * 
					 * Pattern is used for processing regex.
					 * Matcher is used 
					 * for matching two strings.
					 */
					Pattern pattern;
					Matcher matcher;
					
					StringBuilder direct = 
							new StringBuilder("");
					
					final String SEMICOLON = ";";
					
					pattern = Pattern.compile(SEMICOLON);
					matcher = pattern.matcher("");
					
					System.out.println(
							"Enter directory "
							+ "to save array : ");
					
					while (!matcher.find()) {
						
						System.out.print(
							direct.toString());
						
						direct.append(
							reader.readLine());
						
						matcher = pattern.matcher(
							direct.toString());
						
						File directory = 
						new File(direct.toString());
						File[] list = 
							directory.listFiles();
						
						if (list == null) {
							
							System.out.println(
							"Incorrect or "
							+ "result directory!");
							continue;
						}
					
						System.out.println(
						"---------------");
							
						for (File it : list) {
							
							if (it.isDirectory()) {
								
								System.out.print(it.getName());
								System.out.println("(...)");
								continue;
							}
							
							System.out.println(
							"\n" + 
							it.getName() + "\n");
						}
						
						System.out.println(
						"---------------");
					}
					
					String currentDir = direct.toString();
					
					/* Removes a semicolon from a string. */
					currentDir = 
					currentDir.replaceAll(
					SEMICOLON, "");
					
					/* 
					 * Writes to the user-defined 
					 * directory XML file.
					 * Library(the array of objects)
					 *  is loaded to XML file.
					 */
					FileOutputStream fos = 
						new FileOutputStream(
						currentDir + "\\JavaBean.xml");
					BufferedOutputStream bos = 
						new BufferedOutputStream(fos);
					XMLEncoder xmlEncoder = 
						new XMLEncoder(bos);
					
					xmlEncoder.writeObject(books);
					
					xmlEncoder.close();
					
					break;
			
				case "4" :
					
					System.out.println(
					"Enter directory to extract"
					+ " XML encoded array : ");
					String dirToExtract = reader.readLine();
					
					/*
					 * Extracts XML file 
					 * from user-defined directory. 
					 */
					FileInputStream fis = 
					new FileInputStream(dirToExtract);
					
					BufferedInputStream bis = 
					new BufferedInputStream(fis);
					
					XMLDecoder xmlDecoder = 
					new XMLDecoder(bis);
					
					LibraryStorage[] getBooks = (
					LibraryStorage[]) 
					xmlDecoder.readObject();
					
					xmlDecoder.close();
					
					break;
				
				case "5" :
				
					System.out.println("Exiting...");
					
					/* Exits the user menu. */
					break;
				
				default : break;
				
			}	
		}
		
		reader.close();
	}
}