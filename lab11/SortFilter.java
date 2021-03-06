package ua.lpnuai.oop.boksho11;

import java.util.Comparator;

/**
 * SortFilter abstract class.
 * Contains member as a filter.
 * If filter is not null, 
 * it has next criteria to sort library books by.
 *
 * @param <T> - 
 * generic type to set when instantiating a class object
 */
public abstract class SortFilter<T> implements Comparator<T> {
	
	 /** Filter to set on. */
	Comparator <T> filter;
	
	/**
	 * Parametrized constructor.
	 * 
	 * @param comp - specified comparator
	 */
	SortFilter(Comparator <T> comp) {
		
		filter = comp;
	}
	
}