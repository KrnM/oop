package ua.lpnuai.oop.boksho12;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.khpi.oop.ponomarenko09.Container;
import ua.khpi.oop.ponomarenko10.Book;

/**
 * Utility class. 
 * specific isbn and year search methods are included.
 */
class BookDataParser  {
	
	/**
	 * Method of searching author's initials.
	 * 
	 * @param list a range of books to process
	 * @return the title of book to match the initials
	 * @throws IOException 
	 * signals if there are some collisions with input/output
	 */
	public static String searchAuthor(final Container<Book> list, final String inits) throws IOException {
		
		Book[] booksByYear = searchPubYear(list);	
		
		Pattern pattern;
		Matcher matcher;
		
		StringBuilder foundBooks = new StringBuilder();
		
		foundBooks.append("Books with the author's initials " +
					inits + "." + " " + inits + ". :");
		
		pattern = Pattern.compile(inits + "." + " " + inits + ".");
		
		for (int i = 0; i < booksByYear.length; i++) {
			
			if (booksByYear[i] == null) {
				
				continue;
			}
			
			String author = booksByYear[i].getAuthor();
			
			matcher = pattern.matcher(author);
				
			if(matcher.find()) {
				
				foundBooks.append(booksByYear[i].getTitle() + " ");
			}
		}
		
		return foundBooks.toString();
	}
	
	/**
	 * Method of searching specific isbn.
	 * Searches the combinations of 9X9X, 
	 * where X is a user-predefined value.
	 * 
	 * @param list the range of books to process
	 * @return the title of book to match the isbn pattern
	 */
	public static String searchIsbn(final Container<Book> list, final int X) {
		
		Book[] booksByYear = searchPubYear(list);
		
		Pattern pattern;
		Matcher matcher;
		
		StringBuilder foundBooks = new StringBuilder();
		
		foundBooks.append("Books with the 9X9X isbn : ");
		
		String definedX = defineSpecificIsbn(X);
		
		pattern = Pattern.compile("([9][" + definedX + "]){1,}");
		
		for (int i = 0; i < booksByYear.length; i++) {
			
			String isbn = booksByYear[i].getIsbn();
			
			matcher = pattern.matcher(isbn);
			
			if(matcher.find()) {
				
				foundBooks.append(booksByYear[i].getTitle() + " ");
			}
		}
		
		return foundBooks.toString();
	}
	
	/**
	 * Method of outseeding books by specific year bounds.
	 * 
	 * @param list the range of books to process
	 * @return outseeded range of books
	 */
	private static Book[] searchPubYear(final Container<Book> list) {
		
		Object[] objArr = list.toArray();
		
		Book[] bookArr = new Book[objArr.length];
		
		for (int i = 0; i < objArr.length; i++) {
			
			if(objArr[i] == null) {
				
				continue;
				
			} else {
				
				bookArr[i] = (Book) objArr[i];
			}
		}
		
		Pattern pattern;
		Matcher matcher;
		
		final String REGEX_BOUNDS = "^[201]{3}[2-7]";
		
		pattern = Pattern.compile(REGEX_BOUNDS);
		
		for (int i = 0; i < bookArr.length; i++) {
			
			String year = bookArr[i].getPublishingDate().substring(0, 4);
			
			matcher = pattern.matcher(year);
			
			if (!matcher.matches()) {
				
				bookArr[i] = null;
			}
		}
		
		return bookArr;
	}

	/**
	 * Method of specific isbn pattern definition.
	 * Defines X for 9X9X isbn pattern.
	 * 
	 * @return X, user-defined value
	 */
	private static String defineSpecificIsbn(final int X) {
		
		return Integer.toString(X);
	}
}