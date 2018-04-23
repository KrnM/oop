package ua.lpnuai.oop.boksho09;

import java.util.Comparator;

/**
 * @author nick
 * ?iieaiaioao?y eiiia?aoi?o aey ni?ooaaiiy ca e?eue?no? neiaie?a o ?yaeo.
 */
public class Sorter implements Comparator<String> {

	@Override
	public final int compare(final String o1, final String o2) {
		if (o1.length() > o2.length()) {
			return 1;
		} else {
			if (o1.length() < o2.length()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}