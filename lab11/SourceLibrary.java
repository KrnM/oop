
package ua.lpnuai.oop.boksho11;

import java.util.Comparator;


/**
 * SourceLibrary class that describes the entity of a library.
 * 
 * Contains methods for adding books, 
 * displaying the whole library, 
 * sorting books by prioritized criteria.
 */
public class SourceLibrary implements Library {

	ContainerList <Book> list = new ContainerList<>();
	
	/** 
	 * Method for adding new books to a library.
	 * 
	 * @param newBook - book to add
	 */
	public void add(Book newBook)  {

		list.add(newBook);
	}

	/**
	 * Method for displaying all books in a library.
	 */
	public void display() {
		
		if(this.list.size() == 0) {
			
			System.out.println("Nothing to display!");
			return;
		}
		
		Object[] objArr = this.list.toArray();
		
		Book[] getArr = new Book[this.list.size()];
		
		for (int i = 0; i < this.list.size(); i++) {
			
			getArr[i] = (Book) objArr[i];
		}
		
		System.out.println("List : ");
		
		for (int i = 0; i < getArr.length; i++) {
			
			System.out.println(getArr[i].getTitle() + 
					'\n' + getArr[i].getGenre() + 
					'\n' + getArr[i].getPublisher() + 
					'\n' + getArr[i].getPublishingDate());
		}
	}
	
	/**
	 * Method for sorting books in a library.
	 * Sort is criteria-prioritized.
	 * 
	 * @param comp - 
	 * comparator as a prioritized criteria to sort by
	 */
	public void sort(Comparator<Book> comp) {
		
		if(this.list.size() == 0) {
			
			System.out.println("Nothing to sort!");
			return;
		}
		
		Object[] objArr = this.list.toArray();
	
		Book[] getArr = new Book[this.list.size()];
		
		for (int i = 0; i < this.list.size(); i++) {
			
			getArr[i] = (Book) objArr[i];
		}
		
		Book temp = null;
		
		for (int i = getArr.length - 1 ; i > 0 ; i--) {
			
	        for (int j = 0 ; j < i ; j++) {
	            
	            if (comp.compare(getArr[j], getArr[j + 1]) > 0) {
	            	
	            	temp = getArr[j];
					getArr[j] = getArr[j + 1];
					getArr[j + 1] = temp;
	            }
	        }
	    }
		
		this.list.deleteList();
		
		for (Book book : getArr) {
			
			this.add(book);
		}
	}
}