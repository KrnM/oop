package ua.lpnuai.oop.boksho11;
import java.util.Comparator;

/**
 * FilterByDate class.
 * Contains method for comparing books.
 * 
 *
 */
public class FilterByDate extends SortFilter<Book>{

	/**
	 * Parametrized constructor.
	 * Contains a comparator as a parameter.
	 * 
	 * @param comp - object comparator
	 */
	FilterByDate(Comparator<Book> comp) {
		
		super(comp);
	}
	
	/**
	 * Method for comparing two objects.
	 */
	@Override
	public int compare(Book o1, Book o2) {
		
		int result = o1.getPublishingDate().compareTo(o2.getPublishingDate());
		
		if(result != 0) {
			
			return result;
		}
		
		if(super.filter != null) {
			
			return filter.compare(o1, o2);
		}
		
		return 0;
	}
}