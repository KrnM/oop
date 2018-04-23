package ua.lpnuai.oop.boksho09;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author nick
 *
 */
public class Container implements Iterable<String>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4397592531729104565L;
	/**
	 * Array of strings.
	 */
	public String[] data;

	/**
	 * @param array ianea ?yae?a
	 */
	public Container(final String[] array) {
		data = new String[array.length];
		System.arraycopy(array, 0, data, 0, array.length);
	}

	/**
	 * Eiino?oeoi?.
	 */
	public Container() {
		data = new String[0];
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String item : data) {
			result.append(item);
		}
		return result.toString();
	}

	/**
	 * @param string ?yaie, ui aiaa?ouny o e?iaou eiioaeia?o.
	 */
	final void add(final String string) {
		String[] temp = new String[data.length];
		System.arraycopy(data, 0, temp, 0, data.length);
		int newLength = data.length + 1;
		data = new String[newLength];
		System.arraycopy(temp, 0, data, 0, temp.length);
		data[newLength - 1] = string;
	}

	/**
	 * I?euaiiy ianeao ?yae?a.
	 */
	final void clear() {
		data = new String[0];
	}

	/**
	 * @param string ?yaie aey aeaaeaiiy.
	 * @return true/false caea?ii a?a iayaiino? ?yaea o eiioaeia??.
	 */
	final boolean remove(final String string) {
		for (int i = 0; i < data.length; i++) {
			if (string.equals(data[i])) {
				int removed = data.length - i - 1;
				if (removed > 0) {
					System.arraycopy(data, i + 1, data, i, removed);
				}
				data[data.length - 1] = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * @return array
	 */
	final Object[] toArray() {
		return Arrays.copyOf(data, data.length);
	}

	/**
	 * @return size of array
	 */
	final int size() {
		return data.length;
	}

	/**
	 * @param string text to search
	 * @return boolean value
	 */
	final boolean contains(final String string) {
		for (String item : data) {
			if (item == string) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param container eiioaeia? aey ii??aiyiiy
	 * @return boolean value
	 */
	final boolean containsAll(final Container container) {
		if (Arrays.equals(this.data, container.data)) {
			return true;
		}
		return false;
	}

	public Iterator<String> iterator() {
		return new Iterator<String>(data);
	}

	/**
	 * Ni?ooaaiiy ianeao ?yae?a ca e?eue?no? neiaie?a.
	 */
	final void sort() {
		Comparator<String> lenghtComparator = new Sorter();
		Arrays.sort(data, lenghtComparator);
	}

	/**
	 * @param string ?yaie - ee?? iiooeo.
	 * @return ?iaaen o eiioaeia??, aai -1 ca a?anooiino? o iuiio.
	 */
	final int search(final String string) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(string)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @author nick
	 *
	 * @param <String>
	 */
	@SuppressWarnings("hiding")
	class Iterator<String> implements java.util.Iterator<String> {

		private int cursor;
		private final int end;

		/**
		 * @param data ianea ?yae?a.
		 */
		public Iterator(final java.lang.String[] data) {
			this.cursor = 0;
			this.end = data.length;
		}

		@Override
		public boolean hasNext() {
			return this.cursor < end;
		}

		@SuppressWarnings("unchecked")
		@Override
		public String next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			int current = cursor;
			cursor++;
			return (String) data[current];
		}
	}
}