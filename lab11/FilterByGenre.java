package ua.lpnuai.oop.boksho11;
import java.util.Comparator;

/**
 * FilterByGenre class.
 * Contains method for comparing books.
 * 
 *
 */
public class FilterByGenre extends SortFilter<Book>{


	/**
	 * Parametrized constructor.
	 * Contains a comparator as a parameter.
	 * 
	 * @param comp - object comparator
	 */
	FilterByGenre(Comparator<Book> comp) {
		
		super(comp);
	}
	
	/**
	 * Method for comparing two objects.
	 */
	@Override
	public int compare(Book o1, Book o2) {
		
		int result = o1.getGenre().compareTo(o2.getGenre());
		
		if(result != 0) {
			
			return result;
		}
		
		if(super.filter != null) {
			
			return filter.compare(o1, o2);
		}
		
		return 0;
	}
}