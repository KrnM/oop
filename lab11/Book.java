package ua.lpnuai.oop.boksho11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.regex.Matcher;

/**
 * LibraryStorage class.
 * Class defines the entity of a special task.
 * Library stores books that have isbn, name(title), authors etc.
 */
public class Book { 

	/** Isbn of a book. */
	private String isbn;
	
	/** The title of a book. */
	private String title;
	
	/** The authors of a book. */
	private String[] authors;
	
	/** The publisher of a book. */
	private String publisher;
	
	/** The genre of a book. */
	private String genre;
	
	/** The publishing date of a book. */
	private Calendar publishingDate;
	
	/** Default constructor. */
	public Book() { }
	
	/**
	 * Parametrized constructor.
	 * 
	 * @param title - the title of a book
	 * @param publisher - the publisher of a book
	 * @param genre - the genre of a book
	 * @param date - the date of a book
	 * @throws ParseException - 
	 * if date cannot be resolved according to its pattern
	 */
	public Book(String title, String publisher, String genre, String date) throws ParseException {
		
		this.title = title;
		this.publisher = publisher;
		this.genre = genre;
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal  = Calendar.getInstance();
		cal.setTime(df.parse(date));
		
		this.publishingDate = cal;
	}
	
	/**
	 * Getter for book isbn.
	 * 
	 * @return the isbn
	 */
	public String getIsbn() {
		
		return isbn;
	}

	/**
	 * Setter for book isbn.
	 * 
	 * @param isbn the isbn to set
	 */
	public void setIsbn(final String isbn) {
		
		if(checkIsbn(isbn)) {
			
			this.isbn = isbn;
			
		} else {
			
			return;
		}
		
	}
	
	private boolean checkIsbn(final String isbn) {
		
		Pattern pattern;
		Matcher matcher;
		
		final String REGEX = "^[0-9]{3}[-]{1}[0-9]{1}[-]"
				+ "{1}[0-9]{2}[-]{1}[0-9]{6}[-]{1}[0-9]{1}$";
		
		pattern = Pattern.compile(REGEX);
		
		matcher = pattern.matcher(isbn);
		
		if (matcher.matches()) {
			
			return true;
			
		} else {
			
			return false;
		}
		
	}

	/**
	 * Getter for book title.
	 * 
	 * @return the name
	 */
	public String getTitle() {
		
		return title;
	}

	/**
	 * Setter for book title.
	 * 
	 * @param name the name to set
	 */
	public void setTitle(final String name) {
		
		if(checkTitle(name)) {
			
			this.title = name;
			
		} else {
			
			return;
		}
	}
	
	private boolean checkTitle(final String name) {
		
		Pattern pattern;
		Matcher matcher;
		
		final String REGEX = "^[À-ß][à-ÿ]+((\\s[À-ß][à-ÿ]+){1,})?$";
		
		pattern = Pattern.compile(REGEX);
		
		matcher = pattern.matcher(name);
		
		if (matcher.matches()) {
			
			return true;
			
		} else {
			
			return false;
		}
		
	}

	/**
	 * Getter for book authors.
	 * 
	 * @return the authors
	 */
	public String[] getAuthors() {

		return authors;
	}
	
	/**
	 * Setter for book authors.
	 * 
	 * @param authorsAmount - the authors to set
	 * @throws IOException - if there is any unresolved input/output
	 */
	public void setAuthors(final int authorsAmount) throws IOException {
		
		BufferedReader reader = new BufferedReader(
		new InputStreamReader(System.in));
		
		this.authors = new String[authorsAmount];
		
		System.out.println("Ââåäèòå " + authorsAmount + " àâòîðîâ");
		
		String getAuthName;
		
		for (int i = 0; i < authorsAmount; i++) {
			
			System.out.print((i + 1) + ". ");
			
			getAuthName = reader.readLine();
			
			if(checkAuthors(getAuthName)) {
				
				this.authors[i] = getAuthName;
				
			} else {
				
				i--;
			}
		}
		
		reader.close();
	}
	
	private boolean checkAuthors(final String getAuthName) {
		
		Pattern pattern;
		Matcher matcher;
		
		final String REGEX = "^[À-ß][à-ÿ]+([ ][À-ß][.]){2}$";
		pattern = Pattern.compile(REGEX);
		
		matcher = pattern.matcher(getAuthName);
		
		if (matcher.matches()) {
			
			return true;
			
		} else {
			
			return false;
		}
	}

	/**
	 * Getter for book publisher.
	 * 
	 * @return the publisher
	 */
	public String getPublisher() {
		
		return publisher;
	}
	
	/**
	 * Setter for book publisher.
	 * 
	 * @param publisher the publisher to set
	 */
	public void setPublisher(final String publisher) {

		if(checkPublisher(publisher)) {
			
			this.publisher = publisher;
			
		} else {
			
			return;
		}
	}
	
	private boolean checkPublisher(final String publisher) {
		
		Pattern pattern;
		Matcher matcher;
		
		final String REGEX = "^[À-ß][à-ÿ]+((\\s[À-ß][à-ÿ]+){1,})?$";
		
		pattern = Pattern.compile(REGEX);
		
		matcher = pattern.matcher(publisher);
		
		if (matcher.matches()) {
			
			return true;
			
		} else {
			
			return false;
		}
	}	

	/**
	 * Getter for book genre.
	 * 
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Setter for book genre.
	 * 
	 * @param genre the genre to set
	 */
	public void setGenre(final String genre) {

		if(checkGenre(genre)) {
			
			this.genre = genre;
			
		} else {
			
			return;
		}
	}
	
	private boolean checkGenre(final String genre) {
		
		Pattern pattern;
		Matcher matcher;
		
		final String REGEX = "^[À-ß][à-ÿ]+((\\s[À-ß]?[à-ÿ]+){1,2})?$";
		
		pattern = Pattern.compile(REGEX);
		
		matcher = pattern.matcher(genre);
		
		if (matcher.matches()) {
			
			return true;
			
		} else {
			
			return false;
		}
		
	}
	
	/**
	 * Getter for book publishing date.
	 * 
	 * @return the publishingDate
	 */
	public String getPublishingDate() {
		return publishingDate.toInstant().toString();
	}
	
	/**
	 * Setter for book publishing date.
	 * 
	 * @param publishingDate the publishingDate to set
	 * @throws ParseException 
	 */
	public void setPublishingDate(final String publishingDate) throws ParseException { 
		
		if (checkPubDate(publishingDate)) {
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal  = Calendar.getInstance();
			cal.setTime(df.parse(publishingDate));
			
			this.publishingDate = cal;
			
		} else {
			
			return;
			
		}
	}
	
	private boolean checkPubDate(final String publishingDate) {
		
		final String DATE_FORMAT = "dd-MM-yyyy";
		
		try {
			
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            
            df.setLenient(false);
            df.parse(publishingDate);
            
            return true;
            
        } catch (ParseException e) {
        	
            return false;
            
        }
	}
}