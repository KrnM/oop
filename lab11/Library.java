package ua.lpnuai.oop.boksho11;

/**
 * Library interface.
 * Contains declarations of add and display methods.
 */
public interface Library {
	
	/**
	 * Method to implement for adding books.
	 * 
	 * @param newBook - book to add
	 */
	public void add(Book newBook);
	
	/**
	 * Method to implement for displaying the whole library.
	 */
	public void display();
}